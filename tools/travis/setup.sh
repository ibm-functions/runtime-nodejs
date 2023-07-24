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

set -e

# Build script for Travis-CI.

SCRIPTDIR=$(cd $(dirname "$0") && pwd)
ROOTDIR="$SCRIPTDIR/../.."
HOMEDIR="$SCRIPTDIR/../../../"

# OpenWhisk stuff
cd $HOMEDIR

# Clone and setup openwhisk to have a local test environment.
git clone  https://github.com/ibm-functions/openwhisk.git openwhisk
cd openwhisk

git checkout 03ce08c5b3fdac1a6dd3ae59f893e07cdc8628a2 #8d7f1dfc85b12fda81153c34a540f6c01a4780f4

./tools/travis/setup.sh

