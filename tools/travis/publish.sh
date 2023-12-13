#!/bin/bash

set -eux

# Build script for Travis-CI.

SCRIPTDIR=$(cd $(dirname "$0") && pwd)
ROOTDIR="$SCRIPTDIR/../.."
WHISKDIR="$ROOTDIR/../openwhisk"

export OPENWHISK_HOME=$WHISKDIR

IMAGE_PREFIX=$1
RUNTIME_VERSION=$2
IMAGE_TAG=$3

if [ ${RUNTIME_VERSION} == "10" ]; then
  RUNTIME="nodejs10"
elif [ ${RUNTIME_VERSION} == "12" ]; then
  RUNTIME="nodejs12"
elif [ ${RUNTIME_VERSION} == "14" ]; then
  RUNTIME="nodejs14"
elif [ ${RUNTIME_VERSION} == "16" ]; then
  RUNTIME="nodejs16"
  elif [ ${RUNTIME_VERSION} == "20" ]; then
  RUNTIME="nodejs20"
fi

# run login in a subshell with disabled trace to avoid having credentials in the logs
# when trace is on (set -x)
(
  set +x # disable trace in this subshell
  # Login to hub.docker.com to get user specific pull rate.
  if [ ! -z "${DOCKER_USER}" ] && [ ! -z "${DOCKER_PASSWORD}" ]; then
    echo "Run docker login..."
    echo ${DOCKER_PASSWORD} | docker login -u "${DOCKER_USER}" --password-stdin
  fi
)

if [[ ! -z ${RUNTIME} ]]; then
TERM=dumb ./gradlew \
${RUNTIME}:pushImage \
-PdockerRegistry=docker.io \
-PdockerImagePrefix=${IMAGE_PREFIX} \
-PdockerImageTag=${IMAGE_TAG}
fi
