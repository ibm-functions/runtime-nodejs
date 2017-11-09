
## Dev Notes:


### proxycode
- proxy code is copy here temporarly until we can extend an openwhisk action image for nodejs v8
  - the nodejs v8 should have a minimum set of packages, then we add the rest of packages in ibm runtime
- extending nodejs v6 will bring npm packages that probabily will be replace or deleted, making an extra layer never used.
Another alternative is to have the nodejs proxy as an npm module `@openwhisk/runtime-proxy-nodejs`
