#!/bin/bash
set -ex

# Build script for Travis-CI.

SCRIPTDIR=$(cd $(dirname "$0") && pwd)
ROOTDIR="$SCRIPTDIR/../.."
HOMEDIR="$SCRIPTDIR/../../../"
WHISKDIR="$ROOTDIR/../openwhisk"

#Deployment
WHISK_CLI="${WHISKDIR}/bin/wsk -i"

# Check kind from manifest nodejs-ibm:8.5
curl -s -k https://${WHISK_APIHOST} | jq '.runtimes.nodejs | any(.kind == "nodejs-ibm:8.5")'

# Run a simple action using the kind
${WHISK_CLI} action update getNodeVersion ${ROOTDIR}/tests/dat/getNodeVersion.js --kind nodejs-ibm:8.5
${WHISK_CLI} action invoke getNodeVersion -r

