#!/bin/bash

SCRIPTDIR=$(cd $(dirname "$0") && pwd)
ROOTDIR="$SCRIPTDIR/../.."

docker run -d -p 50000:50000 -e DB2INST1_PASSWORD=db2inst1-pwd -e LICENSE=accept --name db2test  ibmcom/db2express-c:latest db2start
sleep 30

db2_container_exists=$(docker inspect -f {{.State.Running}} db2test)

if [[ $db2_container_exists -ne 0 ]]; then
  echo "Despite issuing container start command; the container ibmcom/db2express-c is not running. Exiting ..."
  exit 1
fi

docker cp $ROOTDIR/tools/travis/setup.sql db2test:/home/db2inst1/setup.sql
docker exec -it --user db2inst1 db2test bash -c "~/sqllib/bin/db2 -tvf ~/setup.sql"
