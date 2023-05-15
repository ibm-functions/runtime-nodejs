# IBM Cloud Functions runtime for nodejs

[![Build Status](https://travis-ci.org/ibm-functions/runtime-nodejs.svg?branch=master)](https://travis-ci.com/ibm-functions/runtime-nodejs)

- The runtime provides [nodejs v16](nodejs16/) with a set of [npm packages](nodejs16/package.json) see [nodejs16/CHANGELOG.md](nodejs16/CHANGELOG.md)


The runtime provides the following npm packages for [IBM Cloud](https://bluemix.net):
- IBM DB2/DashDB and IBM Informix [ibm_db](https://www.npmjs.com/package/ibm_db)
- IBM Cloudant [@cloudant/cloudant](https://www.npmjs.com/package/@cloudant/cloudant)
- IBM Watson Cloud [watson-developer-cloud](https://www.npmjs.com/package/watson-developer-cloud)
- IBM Cloud Object Storage [ibm-cos-sdk](https://www.npmjs.com/package/ibm-cos-sdk)


### How to use as a docker Action
To use as a docker action
```
ibmcloud wsk action update myAction myAction.js --docker ibmfunctions/action-nodejs-ibm-v16
```
This works on any deployment of Apache OpenWhisk or IBM Cloud Functions

### Future: IBM Cloud Functions (based on Apache OpenWhisk)
To use as a nodejs kind action
```
ibmcloud wsk action update myAction myAction --kind nodejs:16
```
Tip: Not available yet in the IBM Cloud

### Working with the local git repo
Prerequisite: *Export* OPENWHISK_HOME to point to your incubator/openwhisk cloned directory.

To build the `nodejs:16` runtime:
```
./gradlew nodejs16:distDocker
```
This will produce the image `whisk/action-nodejs-ibm-v16`


Build and Push image
```
docker login
./gradlew nodejs16:distDocker -PdockerImagePrefix=$prefix-user -PdockerRegistry=docker.io
```

Deploy OpenWhisk using ansible environment that adds the new king `nodejs:16`
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
docker tag whisk/action-nodejs-ibm-v16 $user_prefix/action-nodejs-ibm-v16
docker push $user_prefix/action-nodejs-ibm-v16
```
Then create the action using your the image from dockerhub
```
wsk action update myAction myAction.js --docker $user_prefix/action-nodejs-ibm-v16
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
        "apikey": ""
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
  ],
  "cloud-object-storage":[
      {
        "credentials": {
          "resource_instance_id": "",
          "apikey": ""
        }
      }
  ],

}
```
Then update the `whisk.properties` file located in the directory `$OPENWHISK_HOME`, using the variable `vcap.services.file`

## Maintenance Tasks

### Updating Node.js 16 runtime
- Get the version of the latest tag ibm image
```
VERSION=$(git tag | grep 16@ | tail -2 | head -1 | awk -F"@" '{print $2 }')
```
- Check the version of nodejs on the latest ibm image released
```
docker run --rm -it ibmfunctions/action-nodejs-v16:$VERSION sh -c "node -v"
```
- Check if there is a new version of the [Node.js LTS 16](https://github.com/nodejs/node/blob/master/doc/changelogs/CHANGELOG_V16.md).
```
nvm ls-remote | grep v16.
```
  - If there is a new version update the [OpenWhisk Node.js 16 Dockerfile](https://github.com/apache/openwhisk-runtime-nodejs/blob/master/core/nodejs16Action/Dockerfile#L18) and submit PR.
  - After PR is merged wait for Travis CI to build and push a new tag image for [openwhisk/action-nodejs-v16](https://hub.docker.com/r/openwhisk/action-nodejs-v16/tags)
  - Update the ibm image [nodejs16/Dockerfile](nodejs16/Dockerfile) FROM usign the new upstream tag
- Check if there are new npm packages available
  - Use the latest released image to check the outdated npm packages
  ```
  docker run --rm -it ibmfunctions/action-nodejs-v16:$VERSION sh -c "cd / && npm outdated"
  ```
  - Update [nodejs16/package.json](nodejs16/package.json)
  - Update [nodejs16/CHANGELOG.md](nodejs16/CHANGELOG.md)

### Pushing new versions for runtimes
- After the PR is merged and the master pass Travis CI, checkout master.
- Create tag for each runtime and push upstream
```
git tag 16@<new version>
git push upstream 16@<new version>
```
- After the image is deployed to production update the `latest` tag for each runtime.
```
git tag 16@latest -f
git push upstream 16@latest -f
```


# License
[Apache 2.0](LICENSE.txt)
