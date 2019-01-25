# IBM Cloud Functions runtime for nodejs

[![Build Status](https://travis-ci.org/ibm-functions/runtime-nodejs.svg?branch=master)](https://travis-ci.org/ibm-functions/runtime-nodejs)

- The runtime provides [nodejs v8](nodejs8/) with a set of [npm packages](nodejs8/package.json) see [nodejs8/CHANGELOG.md](nodejs8/CHANGELOG.md)
- The runtime provides [nodejs v10](nodejs10/) with a set of [npm packages](nodejs10/package.json) see [nodejs8/CHANGELOG.md](nodejs10/CHANGELOG.md)


The runtime provides the following npm packages for [IBM Cloud](https://bluemix.net):
- IBM DB2/DashDB and IBM Informix [ibm_db](https://www.npmjs.com/package/ibm_db)
- IBM Cloudant [@cloudant/cloudant](https://www.npmjs.com/package/@cloudant/cloudant)
- IBM Watson Cloud [watson-developer-cloud](https://www.npmjs.com/package/watson-developer-cloud)
- IBM Cloud Object Storage [ibm-cos-sdk](https://www.npmjs.com/package/ibm-cos-sdk)

*Note: Nodejs10 runtime does not include Watson npm package yet, this will be added soon.

### How to use as a docker Action
To use as a docker action
```
bx wsk action update myAction myAction.js --docker ibmfunctions/action-nodejs-ibm-v10
```
This works on any deployment of Apache OpenWhisk or IBM Cloud Functions

### Future: IBM Cloud Functions (based on Apache OpenWhisk)
To use as a nodejs kind action
```
bx wsk action update myAction myAction --kind nodejs:10
```
Tip: Not available yet in the IBM Cloud

### Working with the local git repo
Prerequisite: *Export* OPENWHISK_HOME to point to your incubator/openwhisk cloned directory.

To build the `nodejs:8` runtime:
```
./gradlew nodejs8:distDocker
```
This will produce the image `whisk/action-nodejs-ibm-v8`

To build the `nodejs:10` runtime:
```
./gradlew nodejs10:distDocker
```
This will produce the image `whisk/action-nodejs-ibm-v10`


Build and Push image
```
docker login
./gradlew nodejs10:distDocker -PdockerImagePrefix=$prefix-user -PdockerRegistry=docker.io
```

Deploy OpenWhisk using ansible environment that adds the new king `nodejs:10`
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
docker tag whisk/action-nodejs-ibm-v10 $user_prefix/action-nodejs-ibm-v10
docker push $user_prefix/action-nodejs-ibm-v10
```
Then create the action using your the image from dockerhub
```
wsk action update myAction myAction.js --docker $user_prefix/action-nodejs-ibm-v8
```
The `$user_prefix` is usually your dockerhub user id.

### Testing
Install dependencies from the root directory on $OPENWHISK_HOME repository
```
./gradlew install
```

#### Using IntelliJ:
- Import project as gradle project.
- Make sure working directory is root of the project/repo

#### Using Gradle

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
      "credentials": {
        "url": "",
        "host": "",
        "port": "" ,
        "password": "",
        "username": ""
      }
    }
  ],
  "dashDB":[
      {
        "credentials": {
          "ssldsn": "DATABASE=BLUDB;HOSTNAME=<hostname_value>;PORT=50001;PROTOCOL=TCPIP;UID=<username_value>;PWD=<password_value>;Security=SSL;"
        }
      }
    ]
}
```
Then update the `whisk.properties` file located in the directory `$OPENWHISK_HOME`, using the variable `vcap.services.file`

## Maintenance Tasks

### Updating Node.js 10 runtime
- Check if there is a new version of the [Node.js LTS 10](https://github.com/nodejs/node/blob/master/doc/changelogs/CHANGELOG_V10.md).
  - If there is a new version update the [OpenWhisk Node.js 10 Dockerfile](https://github.com/apache/incubator-openwhisk-runtime-nodejs/blob/master/core/nodejs10Action/Dockerfile#L18) and submit PR.
  - After PR is merged wait for Travis CI to build and push a new tag image for [openwhisk/action-nodejs-v10](https://hub.docker.com/r/openwhisk/action-nodejs-v10/tags)
  - Update the ibm image [nodejs10/Dockerfile](nodejs10/Dockerfile) FROM usign the new upstream tag
- Check if there are new npm packages available
  - Use the latest released image to check the outdated npm packages
  ```
  docker run --rm -it ibmfunctions/action-nodejs-v10:1.6.0 sh -c "cd / && npm outdated"
  ```
  - Update [nodejs10/package.json](nodejs10/package.json)
  - Update [nodejs10/CHANGELOG.md](nodejs10/CHANGELOG.md)

### Updating Node.js 8 runtime
- Check if there is a new version of the [Node.js LTS 8](https://github.com/nodejs/node/blob/master/doc/changelogs/CHANGELOG_V8.md).
  - If there is a new version update the [OpenWhisk Node.js 8 Dockerfile](https://github.com/apache/incubator-openwhisk-runtime-nodejs/blob/master/core/nodejs8Action/Dockerfile#L18) and submit PR.
  - After PR is merged wait for Travis CI to build and push a new tag image for [openwhisk/action-nodejs-v8](https://hub.docker.com/r/openwhisk/action-nodejs-v8/tags)
  - Update the ibm image [nodejs8/Dockerfile](nodejs8/Dockerfile) FROM usign the new upstream tag
- Check if there are new npm packages available
  - Use the latest released image to check the outdated npm packages
  ```
  docker run --rm -it ibmfunctions/action-nodejs-v8:1.33.0 sh -c "cd / && npm outdated"
  ```
  - Update [nodejs8/package.json](nodejs8/package.json) only minor and patch levels.
  - Update [nodejs8/CHANGELOG.md](nodejs8/CHANGELOG.md)

### Pushing new versions for runtimes
- After the PR is merged and the master pass Travis CI, checkout master.
- Create tag for each runtime and push upstream
```
git tag 10@<new version>
git push upstream 10@<new version>
```
- After the image is deployed to production update the `latest` tag for each runtime.
```
git tag 10@latest -f
git push upstream 10@latest -f
```


# License
[Apache 2.0](LICENSE.txt)
