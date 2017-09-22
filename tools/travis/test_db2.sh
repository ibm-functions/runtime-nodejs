#!/bin/bash
set -ex

SCRIPTDIR=$(cd $(dirname "$0") && pwd)
ROOTDIR="$SCRIPTDIR/../.."
WHISKDIR="$ROOTDIR/../openwhisk"

#Deployment
WHISK_CLI="${WHISKDIR}/bin/wsk -i"
DB2_HOST=172.17.0.1

# Run a simple action using the kind
${WHISK_CLI} action update db2action tests/dat/testdb2action.js --kind nodejs-ibm:8 --param hostname $DB2_HOST
${WHISK_CLI} action get db2action

${WHISK_CLI} action invoke db2action -b | grep '"message": "Tested db2 create, select, and delete of a table row."'
