#!/bin/bash
set -ex

# Build script for Travis-CI.

SCRIPTDIR=$(cd $(dirname "$0") && pwd)
ROOTDIR="$SCRIPTDIR/../.."
WHISKDIR="$ROOTDIR/../openwhisk"
IMAGE_PREFIX="testing"

export OPENWHISK_HOME=$WHISKDIR

# Build IBM nodejs runtime
cd $ROOTDIR
TERM=dumb ./gradlew \
:nodejs8:distDocker \
-PdockerImagePrefix=${IMAGE_PREFIX}


# Build OpenWhisk
cd $WHISKDIR
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

# Deploy OpenWhisk
cd $WHISKDIR/ansible
ANSIBLE_CMD="ansible-playbook -i ${ROOTDIR}/ansible/environments/local -e docker_image_prefix=testing"
$ANSIBLE_CMD setup.yml
$ANSIBLE_CMD prereq.yml
$ANSIBLE_CMD couchdb.yml
$ANSIBLE_CMD initdb.yml
$ANSIBLE_CMD wipe.yml
$ANSIBLE_CMD openwhisk.yml

docker images
docker ps

cat $WHISKDIR/whisk.properties
curl -s -k https://172.17.0.1 | jq .
curl -s -k https://172.17.0.1/api/v1 | jq .

#Deployment
WHISK_APIHOST="172.17.0.1"
WHISK_AUTH=`cat ${WHISKDIR}/ansible/files/auth.guest`
WHISK_CLI="${WHISKDIR}/bin/wsk -i"

${WHISK_CLI} property set --apihost ${WHISK_APIHOST} --auth ${WHISK_AUTH}
${WHISK_CLI} property get
