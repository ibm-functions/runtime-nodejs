IBM Functions runtimes for nodejs
[![Build Status](https://travis-ci.org/ibm-functions/runtime-nodejs.svg?branch=master)](https://travis-ci.org/ibm-functions/runtime-nodejs)

**Work in progress**

[nodejs v8.5](8.5/)

# Local development

Build image
```
cd 8.5
docker build . -t action-nodejs-ibm-v8.5 
```

Push image
```
docker tag action-nodejs-ibm-v8.5 $prefix-user/action-nodejs-ibm-v8.5
docker login
docker push $prefix-user/action-nodejs-ibm-v8.5
```

To use as docker action
```
bx wsk action update myAction myAction.js --docker $prefix-user/action-nodejs-ibm-v8.5
```

# Future use
To use as special nodejs kind action
```
bx wsk action update myACtion myAction --kind nodejs-ibm:8.5
```

# License
[Apache 2.0](LICENSE.txt)


