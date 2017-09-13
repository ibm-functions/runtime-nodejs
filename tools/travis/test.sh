#!/bin/bash
set -ex

# Build script for Travis-CI.

SCRIPTDIR=$(cd $(dirname "$0") && pwd)
ROOTDIR="$SCRIPTDIR/../.."
HOMEDIR="$SCRIPTDIR/../../../"
WHISKDIR="$ROOTDIR/../openwhisk"

#Deployment
WHISK_APIHOST="172.17.0.1"
WHISK_AUTH=`cat ${WHISKDIR}/ansible/files/auth.guest`
WHISK_CLI="${WHISKDIR}/bin/wsk"

# Check kind from manifest nodejs-ibm:8.5
curl -s -k https://${WHISK_APIHOST} | jq '.runtimes.nodejs | any(.kind == "nodejs-ibm:8.5")'



