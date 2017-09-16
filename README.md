#IBM Functions runtimes for nodejs
[![Build Status](https://travis-ci.org/ibm-functions/runtime-nodejs.svg?branch=master)](https://travis-ci.org/ibm-functions/runtime-nodejs)

## Work in progress**
This repository is work in progress, braking changes might occur

The runtime provides [nodejs v8.5](8.5/) with a set of [npm packages](8.5/package.json)
The images provides the following npm packages for IBM Services/Products
- IBM DB2/DashDB and IBM Informix [ibm_db@2.1.0](https://www.npmjs.com/package/ibm_db)
- IBM Cloudant [cloudant@1.8.0](https://www.npmjs.com/package/cloudant)
- IBM Watson Cloud [watson-developer-cloud@2.39.0](https://www.npmjs.com/package/watson-developer-cloud)

### Give it a try today
To use as a docker action
```
bx wsk action update myAction myAction.js --docker ibmfunctions/action-nodejs-ibm-v8.5
```
This works on any deployment of Apache OpenWhisk

### Future: IBM Functions (Apache OpenWhisk on IBM Cloud)
To use as a special nodejs kind action
```
bx wsk action update myAction myAction --kind nodejs-ibm:8.5
```

### Local development
```
./gradlew 8.5:distDocker
```
This will produce the image `whisk/action-nodejs-ibm-v8.5`

Build and Push image
```
docker login
./gradlew 8.5:distDocker -PdockerImagePrefix=$prefix-user -PdockerRegistry=docker.io 
```

Deploy OpenWhisk using ansible environment that adds the new king `nodejs-ibm:8.5`
Assuming you have OpenWhisk already deploy localy and `OPENWHISK_HOME` pointing to root directory of OpenWhisk core repository.

Set `ROOTDIR` to the root directory of this repository.

Redeploy OpenWhisk
```
cd $OPENWHISK_HOME/ansible
ANSIBLE_CMD="ansible-playbook -i ${ROOTDIR}/ansible/environments/local"
$ANSIBLE_CMD setup.yml
$ANSIBLE_CMD couchdb.yml
$ANSIBLE_CMD initdb.yml
$ANSIBLE_CMD wipe.yml
$ANSIBLE_CMD openwhisk.yml
```

To use as docker action push to your own dockerhub account
```
docker tag whisk/action-nodejs-ibm-v8.5 $user_prefix/action-nodejs-ibm-v8.5
docker push $user_prefix/action-nodejs-ibm-v8.5
```
Then create the action using your the image from dockerhub
```
wsk action update myAction myAction.js --docker $user_prefix/action-nodejs-ibm-v8.5
```
The `$user_prefix` is usually your dockerhub user id.



# License
[Apache 2.0](LICENSE.txt)


