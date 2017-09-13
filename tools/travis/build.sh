#!/bin/bash
set -ex

# Build script for Travis-CI.

SCRIPTDIR=$(cd $(dirname "$0") && pwd)
ROOTDIR="$SCRIPTDIR/../.."
HOMEDIR="$SCRIPTDIR/../../../"
WHISKDIR="$ROOTDIR/../openwhisk"

# Build IBM nodejs runtime
cd $ROOTDIR/8.5
docker build . -t action-nodejs-ibm-v8.5
docker tag action-nodejs-ibm-v8.5 testing/action-nodejs-ibm-v8.5


# Build OpenWhisk

cd $WHISKDIR
export OPENWHISK_HOME=$WHISKDIR
IMAGE_PREFIX="testing"
#superfast option
docker pull openwhisk/controller
docker tag openwhisk/controller ${IMAGE_PREFIX}/controller
docker pull openwhisk/invoker
docker tag openwhisk/invoker ${IMAGE_PREFIX}/invoker
docker pull openwhisk/nodejs6action
docker tag openwhisk/nodejs6action ${IMAGE_PREFIX}/nodejs6action

#Build CLI
TERM=dumb ./gradlew \
:tools:cli:distDocker \
-PdockerImagePrefix=${IMAGE_PREFIX}

#fast options only build what we need
#TERM=dumb ./gradlew \
#:core:controller:distDocker \
#:core:invoker:distDocker \
#:core:nodejs6Action:distDocker \
#:tools:cli:distDocker \
#-PdockerImagePrefix=testing

#long version
#TERM=dumb ./gradlew distDocker -PdockerImagePrefix=testing

# Deploy OpenWhisk
cd $WHISKDIR/ansible
RUNTIMES_MANIFEST='{"runtimesManifest":{"defaultImagePrefix": "openwhisk", "defaultImageTag": "latest", "blackboxes": [{"name": "dockerskeleton"}], "runtimes": { "nodejs": [{"deprecated": false, "kind": "nodejs-ibm:8.5", "image": {"name": "action-nodejs-ibm-v8.5"}}, {"default": true, "deprecated": false, "kind": "nodejs:6", "image": {"name": "nodejs6action"}}]}}}'
ANSIBLE_CMD="ansible-playbook -i environments/local -e docker_image_prefix=testing"
$ANSIBLE_CMD setup.yml
$ANSIBLE_CMD prereq.yml
$ANSIBLE_CMD couchdb.yml
$ANSIBLE_CMD initdb.yml
$ANSIBLE_CMD wipe.yml
$ANSIBLE_CMD openwhisk.yml -e "${RUNTIMES_MANIFEST}"

cat $WHISKDIR/whisk.properties
curl -s -k https://172.17.0.1 | jq .
curl -s -k https://172.17.0.1/api/v1 | jq .

#Deployment
WHISK_APIHOST="172.17.0.1"
WHISK_AUTH=`cat ${WHISKDIR}/ansible/files/auth.guest`
WHISK_CLI="${WHISKDIR}/bin/wsk"

${WHISK_CLI} property set --apihost ${WHISK_APIHOST} --auth ${WHISK_AUTH} 
${WHISK_CLI} property get


