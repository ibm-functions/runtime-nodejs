#!/bin/bash
set -eu

# Build script for Travis-CI.

SCRIPTDIR=$(cd $(dirname "$0") && pwd)
ROOTDIR="$SCRIPTDIR/../.."
WHISKDIR="$ROOTDIR/../openwhisk"

dockerhub_image_prefix="$1"
dockerhub_image_tag="$2"

docker login -u "${DOCKER_USER}" -p "${DOCKER_PASSWORD}"

cd ${ROOTDIR}
export OPENWHISK_HOME=$WHISKDIR
TERM=dumb ./gradlew :8.5:distDocker \
-PdockerImagePrefix=${dockerhub_image_prefix} 
-PdockerImageTag=${dockerhub_image_tag}
-PdockerRegistry=docker.io
