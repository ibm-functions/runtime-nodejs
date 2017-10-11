#!/bin/bash
set -eu

# Build script for Travis-CI.

SCRIPTDIR=$(cd $(dirname "$0") && pwd)
ROOTDIR="$SCRIPTDIR/../.."
WHISKDIR="$ROOTDIR/../openwhisk"

dockerhub_image_prefix="$1"
dockerhub_image_tag="$2"

docker login -u "${DOCKER_USER}" -p "${DOCKER_PASSWORD}"

export OPENWHISK_HOME=$WHISKDIR
cd $ROOTDIR
pwd 
ls
DEBUG_CMD="TERM=dumb ./gradlew :8:distDocker -PdockerImagePrefix=${dockerhub_image_prefix} -PdockerImageTag=${dockerhub_image_tag}"
echo $DEBUG_CMD
TERM=dumb ./gradlew \
:nodejs8:distDocker \
-PdockerImagePrefix=${dockerhub_image_prefix} \
-PdockerImageTag=${dockerhub_image_tag} \
-PdockerRegistry=docker.io
