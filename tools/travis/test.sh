#!/bin/bash
set -ex

# Build script for Travis-CI.

SCRIPTDIR=$(cd $(dirname "$0") && pwd)
ROOTDIR="$SCRIPTDIR/../.."
WHISKDIR="$ROOTDIR/../openwhisk"

#Deployment
WHISK_CLI="${WHISKDIR}/bin/wsk -i"

# Run a simple action using the kind
${WHISK_CLI} action update getNodeVersion ${ROOTDIR}/tests/dat/getNodeVersion.js --kind nodejs-ibm:8
${WHISK_CLI} action get getNodeVersion

#This command sometimes it fails
if ! ${WHISK_CLI} action invoke getNodeVersion -b; then
  #DEBUG get the logs to check why it failed
  cat /tmp/wsklogs/controller0/controller0_logs.log
  cat /tmp/wsklogs/invoker0/invoker0_logs.log
fi

export OPENWHISK_HOME=$WHISKDIR
cd ${ROOTDIR}
TERM=dumb ./gradlew :tests:checkScalafmtAll
if [ "$TRAVIS_PULL_REQUEST" = "false" ]; then
  TERM=dumb ./gradlew :tests:test
else
  TERM=dumb ./gradlew :tests:testWithoutCredentials
fi




#For some reason there no activations, maybe index not ready
#${WHISK_CLI} activation get --last
