#!/bin/bash
#
# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

set -ex

# Build script for Travis-CI.

SCRIPTDIR=$(cd $(dirname "$0") && pwd)
ROOTDIR="$SCRIPTDIR/../.."
WHISKDIR="$ROOTDIR/../openwhisk"

export OPENWHISK_HOME=$WHISKDIR

IMAGE_PREFIX="testing"

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

# Build OpenWhisk
cd $WHISKDIR

#pull down images
docker pull ibmfunctions/controller:nightly
docker tag ibmfunctions/controller:nightly ${IMAGE_PREFIX}/controller
docker pull ibmfunctions/invoker:nightly
docker tag ibmfunctions/invoker:nightly ${IMAGE_PREFIX}/invoker

TERM=dumb ./gradlew install

# Build runtime
cd $ROOTDIR
TERM=dumb ./gradlew distDocker -PdockerImagePrefix=${IMAGE_PREFIX}
