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
export OPENWHISK_HOME="$ROOTDIR/../openwhisk"

# run scala tests
cd ${ROOTDIR}
TERM=dumb ./gradlew :tests:checkScalafmtAll
if [ "$TRAVIS_PULL_REQUEST" = "false" ] && [ "$TRAVIS_REPO_SLUG" = "ibm-functions/runtime-nodejs" ]; then
  TERM=dumb ./gradlew :tests:test
else
  TERM=dumb ./gradlew :tests:testWithoutCredentials
fi

if [[ "$?" != "0" ]]; then
  # debugging notes
  # || true;  set -x; docker ps -a; for i in $(docker ps -a --format="{{.Names}}"); do  docker logs $i || true; done; ls -alhR /tmp/wsklogs; 
  # || true;  set -x; docker ps -a; ls -R /tmp/wsklogs ;cat /tmp/wsklogs/invoker0/invoker0_logs.log; cat /tmp/wsklogs/controller0/controller0_logs.log
  cat /tmp/wsklogs/invoker0/invoker0_logs.log
  cat /tmp/wsklogs/controller0/controller0_logs.log
  exit 1
fi 


