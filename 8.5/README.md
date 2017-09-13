
## Dev Notes:

### log4js
Using log4js@0.6.38 for now because upgrading to latest it errors out
```
Error: Problem with log4js configuration: ({ appenders:
   [ { type: 'dateFile',
       filename: 'logs/nodejsaction.log',
       pattern: '-yyyy-MM-dd',
       alwaysIncludePattern: true,
       layout:
        { type: 'pattern',
          pattern: '[%d{yyyy-MM-ddThh:mm:ss.SSSO}] [%h] [%p] [%c] %m' } } ] }) - must have a property "appenders" of type object.
    at tests.forEach (/nodejsAction/node_modules/log4js/lib/configuration.js:38:15)
    at Array.forEach (<anonymous>)
```

### proxycode
- proxy code is copy here temporarly untile we can extend an openwhisk action image for nodejs v8
  - the nodejs v8 should have a minimum set of packages, then we add the rest of packages in ibm runtime
- extending nodejs v6 will bring npm packages that probabily will be replace or deleted, making an extra layer never used.
