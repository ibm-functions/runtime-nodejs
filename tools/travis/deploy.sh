#!/bin/bash
set -ex

# Build script for Travis-CI.

SCRIPTDIR=$(cd $(dirname "$0") && pwd)
ROOTDIR="$SCRIPTDIR/../.."
WHISKDIR="$ROOTDIR/../openwhisk"

export OPENWHISK_HOME=$WHISKDIR

IMAGE_PREFIX="testing"

# Setup Ansible CMD
cd $WHISKDIR/ansible
ANSIBLE_CMD="ansible-playbook -vvv -i ${ROOTDIR}/ansible/environments/local -e docker_image_prefix=${IMAGE_PREFIX}"

# Weird probem with Travis container names already taken, but we are suppose to get a clean VM
$ANSIBLE_CMD teardown.yml

# Deploy OpenWhisk
$ANSIBLE_CMD setup.yml
$ANSIBLE_CMD prereq.yml
$ANSIBLE_CMD couchdb.yml
$ANSIBLE_CMD initdb.yml
$ANSIBLE_CMD wipe.yml
$ANSIBLE_CMD openwhisk.yml -e cli_installation_mode=remote
$ANSIBLE_CMD properties.yml
$ANSIBLE_CMD postdeploy.yml

docker images
docker ps

#update whisk.properties to add tests/credentials.json file to vcap.services.file, which is needed in tests
VCAP_SERVICES_FILE="$(readlink -f ${ROOTDIR}/tests/credentials.json)"
WHISKPROPS_FILE="$WHISKDIR/whisk.properties"
sed -i 's:^[ \t]*vcap.services.file[ \t]*=\([ \t]*.*\)$:vcap.services.file='$VCAP_SERVICES_FILE':'  $WHISKPROPS_FILE

cat $WHISKPROPS_FILE

curl -s -k https://172.17.0.1 | jq .
curl -s -k https://172.17.0.1/api/v1 | jq .

#Deployment
WHISK_APIHOST="172.17.0.1"
WHISK_AUTH=`cat ${WHISKDIR}/ansible/files/auth.guest`
WHISK_CLI="${WHISKDIR}/bin/wsk -i"

${WHISK_CLI} property set --apihost ${WHISK_APIHOST} --auth ${WHISK_AUTH}
${WHISK_CLI} property get
