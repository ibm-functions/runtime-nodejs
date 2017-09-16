#!/bin/bash
set -x

# Build script for Travis-CI.

SCRIPTDIR=$(cd $(dirname "$0") && pwd)
ROOTDIR="$SCRIPTDIR/../.."
WHISKDIR="$ROOTDIR/../openwhisk"

#Deployment
WHISK_CLI="${WHISKDIR}/bin/wsk -i"

# Check kind from manifest nodejs-ibm:8.5
curl -s -k https://${WHISK_APIHOST} | jq '.runtimes.nodejs | any(.kind == "nodejs-ibm:8.5")'

# Run a simple action using the kind
${WHISK_CLI} action update getNodeVersion ${ROOTDIR}/tests/dat/getNodeVersion.js --kind nodejs-ibm:8.5
${WHISK_CLI} action get getNodeVersion

#This command sometimes it fails
if ! ${WHISK_CLI} action invoke getNodeVersion -b; then
  #DEBUG get the logs to check why it failed
  cat /tmp/wsklogs/controller0/controller0_logs.log
  cat /tmp/wsklogs/controller1/controller1_logs.log
  cat /tmp/wsklogs/invoker0/invoker0_logs.log
  cat /tmp/wsklogs/invoker1/invoker1_logs.log
fi

set -e
export OPENWHISK_HOME=$WHISKDIR
cd ${ROOTDIR}
TERM=dumb ./gradlew :tests:checkScalafmtAll
TERM=dumb ./gradlew :tests:test

#For some reason there no activations, maybe index not ready
#${WHISK_CLI} activation get --last


