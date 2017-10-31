#IBM Functions runtimes for nodejs
[![Build Status](https://travis-ci.org/ibm-functions/runtime-nodejs.svg?branch=master)](https://travis-ci.org/ibm-functions/runtime-nodejs)

## Work in progress**
This repository is work in progress, braking changes might occur

The runtime provides [nodejs v8](8/) with a set of [npm packages](8/package.json)
The images provides the following npm packages for IBM Services/Products
- IBM DB2/DashDB and IBM Informix [ibm_db@2.2.1](https://www.npmjs.com/package/ibm_db)
- IBM Cloudant [cloudant@1.9.0](https://www.npmjs.com/package/cloudant)
- IBM Watson Cloud [watson-developer-cloud@2.41.1](https://www.npmjs.com/package/watson-developer-cloud)
- IBM Cloud Object Storage [ibm-cos-sdk@1.0.2](https://www.npmjs.com/package/ibm-cos-sdk)

### Give it a try today
To use as a docker action
```
bx wsk action update myAction myAction.js --docker ibmfunctions/action-nodejs-ibm-v8
```
This works on any deployment of Apache OpenWhisk

### Future: IBM Functions (Apache OpenWhisk on IBM Cloud)
To use as a special nodejs kind action
```
bx wsk action update myAction myAction --kind nodejs-ibm:8
```

### Local development  
Prerequisite: *Export* OPENWHISK_HOME to point to your incubator/openwhisk cloned directory.

```
./gradlew nodejs8:distDocker
```
This will produce the image `whisk/action-nodejs-ibm-v8`

Build and Push image
```
docker login
./gradlew nodejs8:distDocker -PdockerImagePrefix=$prefix-user -PdockerRegistry=docker.io
```

Deploy OpenWhisk using ansible environment that adds the new king `nodejs-ibm:8`
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
docker tag whisk/action-nodejs-ibm-v8 $user_prefix/action-nodejs-ibm-v8
docker push $user_prefix/action-nodejs-ibm-v8
```
Then create the action using your the image from dockerhub
```
wsk action update myAction myAction.js --docker $user_prefix/action-nodejs-ibm-v8
```
The `$user_prefix` is usually your dockerhub user id.

### Testing


To run all tests: `./gradlew tests:test` this include tests depending on credentials

To run all tests except those which do not rely on credentials `./gradlew tests:testWithoutCredentials`

To run a single test-class: `./gradlew tests:test --tests <SomeGradleTestFilter>`

For example, in order to execute the tests in /tests/src/test/scala/actionContainers/IBMNodeJSActionDB2Tests.scala, run:  `./gradlew tests:test --tests *IBMNodeJsActionDB2Tests`

Note: If you're running all tests locally with credentials like `./gradlew tests:test` or `./gradlew tests:test --tests *CredentialsIBMNodeJsActionWatsonTests`
you need to set up a tests/credentials.json file containing Watson credentials in the format of:
```  
{  
  "language_translation":[  
    {
      "credentials": {  
        "url": "",  
        "password": "",  
        "username": ""  
      }  
    }  
  ],  
  "cloudantNoSQLDB":[
    {
      "name":"",  
      "label":"",  
      "plan":"",  
      "credentials": {  
        "url": "",  
        "host": "",  
        "port": "" ,  
        "password": "",  
        "username": ""  
      }  
    }
  ]
}  
```
Then update the `whisk.properties` file located in the directory `$OPENWHISK_HOME`, using the variable `vcap.services.file`


# License
[Apache 2.0](LICENSE.txt)
