# IBM Functions NodeJS 10 Runtime Container

# Attention
This runtime is deprecated and will not be supported anymore. The code is still here for reference only and might be deleted at any time!

## Migrating from `nodejs:8` to `nodejs:10`
- The `cloudant` npm package is not available in `nodejs:10`, the package is deprecated, you need to use the official npm package [@cloudant/cloudant](https://www.npmjs.com/package/@cloudant/cloudant) v3.x when importing the nodejs module (i.e `require('@cloudant/cloudant')`) also [v3.x only returns Promises](https://github.com/cloudant/nodejs-cloudant/blob/master/api-migration.md#2x--3x).
- The `watson-developer-cloud` npm package available in `nodejs:10` is version 4.x. This version includes support for Promises. [A list of the changes made is documented](https://github.com/watson-developer-cloud/node-sdk/blob/master/UPGRADE-4.0.md).
  *Attention:* This package is deprecated and is not supported anymore. It will not receive updates and will be removed in the future. Move your action to the successor package `ibm-watson`.
- The `ibm-watson` npm package available in `nodejs:10` is version 4.x. This package is the successor of package `watson-developer-cloud`. Upgrade your action code to this new package, since the former will not receive updates anymore. This version includes support for Promises. [A list of the changes made is documented](https://github.com/watson-developer-cloud/node-sdk/blob/master/UPGRADE-4.0.md).
- The package `ibmiotf` has been renamed by the maintainers to `@wiotp/sdk`. Make sure to update your action code to the new package. See https://www.npmjs.com/package/@wiotp/sdk for all changes. The package `ibmiotf` will not receive updates anymore and will be removed from this runtime in the future.
- The `cradle` NPM package is not available in nodejs:10.

# 1.17.1
NodeJS version:
  - [10.24.1](https://nodejs.org/en/blog/release/v10.24.1)

# 1.17.0
Changes:
  - update @ibm-functions/iam-token-manager from `1.0.4` to `1.0.5`
  - update ibm-cos-sdk from `1.5.0` to `1.10.0`
  - update ibm_db from `2.7.0` to `2.7.3`
  - update socket.io from `2.3.0` to `2.4.1`
  - update socket.io-client from `2.3.0` to `2.4.0`

NodeJS version:
  - [10.24.0](https://nodejs.org/en/blog/release/v10.24.0)

NPM Packages:
  - [@cloudant/cloudant v3.0.2](https://www.npmjs.com/package/@cloudant/cloudant) - This is the official Cloudant library for Node.js.
  - [@ibm-functions/iam-token-manager v1.0.5](https://www.npmjs.com/package/@ibm-functions/iam-token-manager) - This is an IAM access token manager library for Node.js.
  - [@sendgrid/mail v6.3.1](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [@wiotp/sdk v0.6.2](https://www.npmjs.com/package/@wiotp/sdk) - IBM Watson IoT Platform Javascript SDK.
  - [amqplib v0.5.6](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v2.6.2](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [bent v1.3.0](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [body-parser v1.18.3](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [cassandra-driver v4.0.0](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [commander v2.19.0](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v0.34.1](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.5](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [elasticsearch v15.4.1](https://www.npmjs.com/package/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.1](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v0.2.13](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [express v4.16.4](https://www.npmjs.com/package/express) - Fast, unopinionated, minimalist web framework for node.
  - [express-session v1.15.6](https://www.npmjs.com/package/express-session) - Managing sessions for express.
  - [formidable v1.2.2](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v7.1.6](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.23.1](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [ibm-cos-sdk v1.10.0](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v2.7.3](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibmiotf v0.2.41](https://www.npmjs.com/package/ibmiotf) - The node.js client is used for simplifying the interaction with the IBM Watson Internet of Things Platform.
  - [ibm-watson v4.2.1](https://www.npmjs.com/package/ibm-watson) - Node.js client library to use the Watson APIs.
  - [iconv-lite v0.4.24](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion
  - [jsdom v13.2.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.9.3](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v8.5.1](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.19](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [log4js v4.0.2](https://www.npmjs.com/package/log4js) - This is a conversion of the log4js framework to work with Node.
  - [marked v0.6.2](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v1.2.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.24.0](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v3.3.4](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mustache v3.0.1](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [mysql v2.16.0](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [nano v8.0.0](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [nodemailer v5.1.1](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.0.2](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.21.2](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v3.0.0](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v7.11.0](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v2.0.4](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v2.8.0](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [request v2.88.0](https://www.npmjs.com/package/request) - Request is designed to be the simplest way possible to make HTTP calls.
  - [request-promise v4.2.5](https://www.npmjs.com/package/request-promise) - The simplified HTTP request client 'request' with Promise support. Powered by Bluebird.
  - [rimraf v2.6.3](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v5.6.0](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [serialize-error v3.0.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v2.4.1](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v2.4.0](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v4.1.0](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [tmp v0.0.33](https://www.npmjs.com/package/tmp) - A simple temporary file and directory creator for node.js.
  - [twilio v3.28.0](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  - [underscore v1.9.1](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [uuid v3.3.0](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v10.11.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.7.1](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [watson-developer-cloud v4.0.0-rc2](https://www.npmjs.com/package/watson-developer-cloud) - Node.js client library to use the Watson Developer Cloud services, a collection of APIs that use cognitive computing to solve complex problems.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.2.1](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v6.1.4](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xlsx v0.14.3](https://www.npmjs.com/package/xlsx) - Parser and writer for various spreadsheet formats.
  - [xml2js v0.4.23](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.
  - [yazl v2.5.1](https://www.npmjs.com/package/yazl) - yet another zip library for node. For unzipping, see yauzl.

# 1.16.4
NodeJS version:
  - [10.24.0](https://nodejs.org/en/blog/release/v10.24.0)

# 1.16.3
NodeJS version:
  - [10.23.2](https://nodejs.org/en/blog/release/v10.23.2)

# 1.16.2
Changes:
 - update openwhisk from `3.21.2` to `3.21.3`

NodeJS version:
  - [10.23.0](https://nodejs.org/en/blog/release/v10.23.0)

# 1.16.1
NodeJS version:
  - [10.22.1](https://nodejs.org/en/blog/release/v10.22.1)

# 1.16.0
Changes:
  - update to a newer base image to catch security fixes
  - update amqplib from `0.5.3` to `0.5.6`
  - update cookie-parser from `1.4.4` to `1.4.5`
  - update etcd3 from `0.2.11` to `0.2.13`
  - update formidable from `1.2.1` to `1.2.2`
  - update glob from `7.1.4` to `7.1.6`
  - update ibm_db from `2.6.3` to `2.7.0`
  - update lodash from `4.17.13` to `4.17.19`
  - update oauth2-server from `3.0.1` to `3.0.2`
  - update openwhisk from `3.19.0` to `3.21.2`
  - update request-promise from `4.2.4` to `4.2.5`
  - update socket.io from `2.2.0` to `2.3.0`
  - update socket.io-client from `2.2.0` to `2.3.0`
  - downgrade uuid from `3.3.2` to `3.3.0` to match version required by the parent image
  - update vcap_services from `0.7.0` to `0.7.1`
  - update xml2js from `0.4.19` to `0.4.23`

NodeJS version:
  - [10.21.0](https://nodejs.org/en/blog/release/v10.21.0)

NPM Packages:
  - [@cloudant/cloudant v3.0.2](https://www.npmjs.com/package/@cloudant/cloudant) - This is the official Cloudant library for Node.js.
  - [@ibm-functions/iam-token-manager v1.0.4](https://www.npmjs.com/package/@ibm-functions/iam-token-manager) - This is an IAM access token manager library for Node.js.
  - [@sendgrid/mail v6.3.1](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [@wiotp/sdk v0.6.2](https://www.npmjs.com/package/@wiotp/sdk) - IBM Watson IoT Platform Javascript SDK.
  - [amqplib v0.5.6](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v2.6.2](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [bent v1.3.0](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [body-parser v1.18.3](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [cassandra-driver v4.0.0](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [commander v2.19.0](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v0.34.1](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.5](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [elasticsearch v15.4.1](https://www.npmjs.com/package/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.1](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v0.2.13](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [express v4.16.4](https://www.npmjs.com/package/express) - Fast, unopinionated, minimalist web framework for node.
  - [express-session v1.15.6](https://www.npmjs.com/package/express-session) - Managing sessions for express.
  - [formidable v1.2.2](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v7.1.6](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.23.1](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [ibm-cos-sdk v1.5.0](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v2.7.0](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibmiotf v0.2.41](https://www.npmjs.com/package/ibmiotf) - The node.js client is used for simplifying the interaction with the IBM Watson Internet of Things Platform.
  - [ibm-watson v4.2.1](https://www.npmjs.com/package/ibm-watson) - Node.js client library to use the Watson APIs.
  - [iconv-lite v0.4.24](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion
  - [jsdom v13.2.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.9.3](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v8.5.1](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.19](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [log4js v4.0.2](https://www.npmjs.com/package/log4js) - This is a conversion of the log4js framework to work with Node.
  - [marked v0.6.2](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v1.2.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.24.0](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v3.3.4](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mustache v3.0.1](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [mysql v2.16.0](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [nano v8.0.0](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [nodemailer v5.1.1](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.0.2](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.21.2](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v3.0.0](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v7.11.0](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v2.0.4](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v2.8.0](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [request v2.88.0](https://www.npmjs.com/package/request) - Request is designed to be the simplest way possible to make HTTP calls.
  - [request-promise v4.2.5](https://www.npmjs.com/package/request-promise) - The simplified HTTP request client 'request' with Promise support. Powered by Bluebird.
  - [rimraf v2.6.3](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v5.6.0](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [serialize-error v3.0.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v2.3.0](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v2.3.0](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v4.1.0](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [tmp v0.0.33](https://www.npmjs.com/package/tmp) - A simple temporary file and directory creator for node.js.
  - [twilio v3.28.0](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  - [underscore v1.9.1](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [uuid v3.3.0](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v10.11.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.7.1](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [watson-developer-cloud v4.0.0-rc2](https://www.npmjs.com/package/watson-developer-cloud) - Node.js client library to use the Watson Developer Cloud services, a collection of APIs that use cognitive computing to solve complex problems.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.2.1](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v6.1.4](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xlsx v0.14.3](https://www.npmjs.com/package/xlsx) - Parser and writer for various spreadsheet formats.
  - [xml2js v0.4.23](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.
  - [yazl v2.5.1](https://www.npmjs.com/package/yazl) - yet another zip library for node. For unzipping, see yauzl.


# 1.15.2
NodeJS version:
  - [10.21.0](https://nodejs.org/en/blog/release/v10.21.0)


# 1.15.1
Changes:
  - Catch latest security fixes with each build.


# 1.15.0
Changes:
  - update to a newer base image to catch security fixes
  - add @wiotp/sdk `0.6.2` (successor of package `ibmiotf`)
  - update ibm_db from `2.5.2` to `2.6.3`
  - update jsforce from `1.9.1` to `1.9.3`
  - update marked from `0.6.2` to `0.8.0` (https://npmjs.com/advisories/812)

NodeJS version:
  - [10.19.0](https://nodejs.org/en/blog/release/v10.19.0)

NPM Packages:
  - [@cloudant/cloudant v3.0.2](https://www.npmjs.com/package/@cloudant/cloudant) - This is the official Cloudant library for Node.js.
  - [@ibm-functions/iam-token-manager v1.0.4](https://www.npmjs.com/package/@ibm-functions/iam-token-manager) - This is an IAM access token manager library for Node.js.
  - [@sendgrid/mail v6.3.1](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [@wiotp/sdk v0.6.2](https://www.npmjs.com/package/@wiotp/sdk) - IBM Watson IoT Platform Javascript SDK.
  - [amqplib v0.5.3](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v2.6.2](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [bent v1.3.0](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [body-parser v1.18.3](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [cassandra-driver v4.0.0](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [commander v2.19.0](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v0.34.1](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.4](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [elasticsearch v15.4.1](https://www.npmjs.com/package/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.1](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v0.2.11](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [express v4.16.4] (https://www.npmjs.com/package/express) - Fast, unopinionated, minimalist web framework for node.
  - [express-session v1.15.6] (https://www.npmjs.com/package/express-session) - Managing sessions for express.
  - [formidable v1.2.1](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v7.1.4](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.23.1](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [ibm-cos-sdk v1.5.0](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v2.6.3](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibmiotf v0.2.41](https://www.npmjs.com/package/ibmiotf) - The node.js client is used for simplifying the interaction with the IBM Watson Internet of Things Platform.
  - [ibm-watson v4.2.1](https://www.npmjs.com/package/ibm-watson) - Node.js client library to use the Watson APIs.
  - [iconv-lite v0.4.24](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion
  - [jsdom v13.2.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.9.3](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v8.5.1](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.13](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [log4js v4.0.2](https://www.npmjs.com/package/log4js) - This is a conversion of the log4js framework to work with Node.
  - [marked v0.6.2](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v1.2.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.24.0](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v3.3.4](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mustache v3.0.1](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [mysql v2.16.0](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [nano v8.0.0](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [nodemailer v5.1.1](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.0.1](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.19.0](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v3.0.0](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v7.11.0](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v2.0.4](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v2.8.0](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [request v2.88.0](https://www.npmjs.com/package/request) - Request is designed to be the simplest way possible to make HTTP calls.
  - [request-promise v4.2.4](https://www.npmjs.com/package/request-promise) - The simplified HTTP request client 'request' with Promise support. Powered by Bluebird.
  - [rimraf v2.6.3](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v5.6.0](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [serialize-error v3.0.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v2.2.0](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v2.2.0](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v4.1.0](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [tmp v0.0.33](https://www.npmjs.com/package/tmp) - A simple temporary file and directory creator for node.js.
  - [twilio v3.28.0](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  - [underscore v1.9.1](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [uuid v3.3.2](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v10.11.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.7.0](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [watson-developer-cloud v4.0.0-rc2](https://www.npmjs.com/package/watson-developer-cloud) - Node.js client library to use the Watson Developer Cloud services, a collection of APIs that use cognitive computing to solve complex problems.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.2.1](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v6.1.4](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xlsx v0.14.3](https://www.npmjs.com/package/xlsx) - Parser and writer for various spreadsheet formats.
  - [xml2js v0.4.19](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.
  - [yazl v2.5.1](https://www.npmjs.com/package/yazl) - yet another zip library for node. For unzipping, see yauzl.


# 1.14.1
Changes:
  - update to a newer base image to catch fixes


# 1.14.0
Changes:
  - update to a newer base image to catch fixes
  - update mongodb from `3.1.13` to `3.3.4`

NodeJS version:
  - [10.16.3](https://nodejs.org/en/blog/release/v10.16.3)

NPM Packages:
  - [@cloudant/cloudant v3.0.2](https://www.npmjs.com/package/@cloudant/cloudant) - This is the official Cloudant library for Node.js.
  - [@sendgrid/mail v6.3.1](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [amqplib v0.5.3](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v2.6.2](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [bent v1.3.0](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [body-parser v1.18.3](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [cassandra-driver v4.0.0](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [commander v2.19.0](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v0.34.1](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.4](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [elasticsearch v15.4.1](https://www.npmjs.com/package/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.1](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v0.2.11](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [express v4.16.4] (https://www.npmjs.com/package/express) - Fast, unopinionated, minimalist web framework for node.
  - [express-session v1.15.6] (https://www.npmjs.com/package/express-session) - Managing sessions for express.
  - [formidable v1.2.1](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v7.1.4](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.23.1](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [ibm-cos-sdk v1.5.0](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v2.5.2](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibmiotf v0.2.41](https://www.npmjs.com/package/ibmiotf) - The node.js client is used for simplifying the interaction with the IBM Watson Internet of Things Platform.
  - [ibm-watson v4.2.1](https://www.npmjs.com/package/ibm-watson) - Node.js client library to use the Watson APIs.
  - [iconv-lite v0.4.24](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion
  - [jsdom v13.2.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.9.1](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v8.5.1](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.13](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [log4js v4.0.2](https://www.npmjs.com/package/log4js) - This is a conversion of the log4js framework to work with Node.
  - [marked v0.6.2](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v1.2.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.24.0](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v3.3.4](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mustache v3.0.1](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [mysql v2.16.0](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [nano v8.0.0](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [nodemailer v5.1.1](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.0.1](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.19.0](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v3.0.0](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v7.11.0](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v2.0.4](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v2.8.0](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [request v2.88.0](https://www.npmjs.com/package/request) - Request is designed to be the simplest way possible to make HTTP calls.
  - [request-promise v4.2.4](https://www.npmjs.com/package/request-promise) - The simplified HTTP request client 'request' with Promise support. Powered by Bluebird.
  - [rimraf v2.6.3](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v5.6.0](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [serialize-error v3.0.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v2.2.0](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v2.2.0](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v4.1.0](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [tmp v0.0.33](https://www.npmjs.com/package/tmp) - A simple temporary file and directory creator for node.js.
  - [twilio v3.28.0](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  - [underscore v1.9.1](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [uuid v3.3.2](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v10.11.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.7.0](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [watson-developer-cloud v4.0.0-rc2](https://www.npmjs.com/package/watson-developer-cloud) - Node.js client library to use the Watson Developer Cloud services, a collection of APIs that use cognitive computing to solve complex problems.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.2.1](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v6.1.4](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xlsx v0.14.3](https://www.npmjs.com/package/xlsx) - Parser and writer for various spreadsheet formats.
  - [xml2js v0.4.19](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.
  - [yazl v2.5.1](https://www.npmjs.com/package/yazl) - yet another zip library for node. For unzipping, see yauzl.


# 1.13.0
Changes:
  - update to a newer nodejs version to catch fixes

NodeJS version:
  - [10.16.3](https://nodejs.org/en/blog/release/v10.16.3)

# 1.12.0
Changes:
  - update to a newer base image to catch fixes

NodeJS version:
  - [10.15.3](https://nodejs.org/en/blog/release/v10.15.3/)

NPM Packages:
  - [@cloudant/cloudant v3.0.2](https://www.npmjs.com/package/@cloudant/cloudant) - This is the official Cloudant library for Node.js.
  - [@sendgrid/mail v6.3.1](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [amqplib v0.5.3](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v2.6.2](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [bent v1.3.0](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [bodyparser v1.18.3](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [cassandra-driver v4.0.0](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [commander v2.19.0](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v0.34.1](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.4](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [elasticsearch v15.4.1](https://www.npmjs.com/package/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.1](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v0.2.11](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [formidable v1.2.1](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v7.1.4](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.23.1](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [ibm-cos-sdk v1.5.0](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v2.5.2](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibmiotf v0.2.41](https://www.npmjs.com/package/ibmiotf) - The node.js client is used for simplifying the interaction with the IBM Watson Internet of Things Platform.
  - [ibm-watson v4.2.1](https://www.npmjs.com/package/ibm-watson) - Node.js client library to use the Watson APIs.
  - [iconv-lite v0.4.24](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion
  - [jsdom v13.2.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.9.1](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v8.5.1](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.13](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [log4js v4.0.2](https://www.npmjs.com/package/log4js) - This is a conversion of the log4js framework to work with Node.
  - [marked v0.6.2](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v1.2.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.24.0](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v3.1.13](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mustache v3.0.1](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [mysql v2.16.0](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [nano v8.0.0](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [nodemailer v5.1.1](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.0.1](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.19.0](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v3.0.0](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v7.11.0](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v2.0.4](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v2.8.0](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [request v2.88.0](https://www.npmjs.com/package/request) - Request is designed to be the simplest way possible to make HTTP calls.
  - [request-promise v4.2.4](https://www.npmjs.com/package/request-promise) - The simplified HTTP request client 'request' with Promise support. Powered by Bluebird.
  - [rimraf v2.6.3](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v5.6.0](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [serialize-error v3.0.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v2.2.0](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v2.2.0](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v4.1.0](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [tmp v0.0.33](https://www.npmjs.com/package/tmp) - A simple temporary file and directory creator for node.js.
  - [twilio v3.28.0](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  - [underscore v1.9.1](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [uuid v3.3.2](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v10.11.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.7.0](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [watson-developer-cloud v4.0.0-rc2](https://www.npmjs.com/package/watson-developer-cloud) - Node.js client library to use the Watson Developer Cloud services, a collection of APIs that use cognitive computing to solve complex problems.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.2.1](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v6.1.4](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xlsx v0.14.3](https://www.npmjs.com/package/xlsx) - Parser and writer for various spreadsheet formats.
  - [xml2js v0.4.19](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.
  - [yazl v2.5.1](https://www.npmjs.com/package/yazl) - yet another zip library for node. For unzipping, see yauzl.


# 1.11.0
Changes:
  - update errorhandler from `1.5.0` to `1.5.1`
  - update glob from `7.1.3` to `7.1.4`
  - update ibm_db from `2.5.0` to `2.5.2`
  - update ibm-cos-sdk from `1.4.3` to `1.5.0`
  - update ibm-watson from `4.1.2` to `4.2.1`
  - update jsonwebtoken from `8.4.0` to `8.5.1`
  - update lodash from `4.17.11` to `4.17.13`
  - update marked from `0.6.0` to `0.6.2`
  - update openwhisk from `3.18.0` to `3.19.0`
  - update pg from `7.8.0` to `7.11.0`
  - update pug from `2.0.3` to `2.0.4`
  - update vcap_services from `0.6.0` to `0.7.0`
  - update xlsx from `0.14.1` to `0.14.3`

NodeJS version:
  - [10.15.3](https://nodejs.org/en/blog/release/v10.15.3/)

NPM Packages:
  - [@cloudant/cloudant v3.0.2](https://www.npmjs.com/package/@cloudant/cloudant) - This is the official Cloudant library for Node.js.
  - [@sendgrid/mail v6.3.1](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [amqplib v0.5.3](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v2.6.2](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [bent v1.3.0](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [bodyparser v1.18.3](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [cassandra-driver v4.0.0](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [commander v2.19.0](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v0.34.1](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.4](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [elasticsearch v15.4.1](https://www.npmjs.com/package/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.1](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v0.2.11](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [formidable v1.2.1](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v7.1.4](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.23.1](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [ibm-cos-sdk v1.5.0](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v2.5.2](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibmiotf v0.2.41](https://www.npmjs.com/package/ibmiotf) - The node.js client is used for simplifying the interaction with the IBM Watson Internet of Things Platform.
  - [ibm-watson v4.2.1](https://www.npmjs.com/package/ibm-watson) - Node.js client library to use the Watson APIs.
  - [iconv-lite v0.4.24](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion
  - [jsdom v13.2.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.9.1](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v8.5.1](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.13](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [log4js v4.0.2](https://www.npmjs.com/package/log4js) - This is a conversion of the log4js framework to work with Node.
  - [marked v0.6.2](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v1.2.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.24.0](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v3.1.13](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mustache v3.0.1](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [mysql v2.16.0](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [nano v8.0.0](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [nodemailer v5.1.1](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.0.1](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.19.0](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v3.0.0](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v7.11.0](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v2.0.4](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v2.8.0](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [request v2.88.0](https://www.npmjs.com/package/request) - Request is designed to be the simplest way possible to make HTTP calls.
  - [request-promise v4.2.4](https://www.npmjs.com/package/request-promise) - The simplified HTTP request client 'request' with Promise support. Powered by Bluebird.
  - [rimraf v2.6.3](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v5.6.0](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [serialize-error v3.0.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v2.2.0](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v2.2.0](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v4.1.0](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [tmp v0.0.33](https://www.npmjs.com/package/tmp) - A simple temporary file and directory creator for node.js.
  - [twilio v3.28.0](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  - [underscore v1.9.1](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [uuid v3.3.2](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v10.11.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.7.0](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [watson-developer-cloud v4.0.0-rc2](https://www.npmjs.com/package/watson-developer-cloud) - Node.js client library to use the Watson Developer Cloud services, a collection of APIs that use cognitive computing to solve complex problems.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.2.1](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v6.1.4](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xlsx v0.14.3](https://www.npmjs.com/package/xlsx) - Parser and writer for various spreadsheet formats.
  - [xml2js v0.4.19](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.
  - [yazl v2.5.1](https://www.npmjs.com/package/yazl) - yet another zip library for node. For unzipping, see yauzl.


# 1.10.0
Changes:
  - Added package ibm-watson `4.1.2`.
    In case you use package watson-developer-cloud in your actions, migrate them to package ibm-watson as watson-developer-cloud will not receive updates anymore.
  - Added package yazl `v2.5.1`.

NodeJS version:
  - [10.15.3](https://nodejs.org/en/blog/release/v10.15.3/)

NPM Packages:
  - [amqplib v0.5.3](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v2.6.2](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [bent v1.3.0](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [bodyparser v1.18.3](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [cassandra-driver v4.0.0](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [@cloudant/cloudant v3.0.2](https://www.npmjs.com/package/@cloudant/cloudant) - This is the official Cloudant library for Node.js.
  - [commander v2.19.0](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v0.34.1](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.4](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [elasticsearch v15.4.1](https://www.npmjs.com/package/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.0](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v0.2.11](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [formidable v1.2.1](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v7.1.3](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.23.1](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [ibm-cos-sdk v1.4.3](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v2.5.0](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibmiotf v0.2.41](https://www.npmjs.com/package/ibmiotf) - The node.js client is used for simplifying the interaction with the IBM Watson Internet of Things Platform.
  - [ibm-watson v4.1.2](https://www.npmjs.com/package/ibm-watson) - Node.js client library to use the Watson APIs.
  - [iconv-lite v0.4.24](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion
  - [jsdom v13.2.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.9.1](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v8.4.0](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.11](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [log4js v4.0.2](https://www.npmjs.com/package/log4js) - This is a conversion of the log4js framework to work with Node.
  - [marked v0.6.0](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v1.2.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.24.0](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v3.1.13](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mysql v2.16.0](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [mustache v3.0.1](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [nano v8.0.0](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [nodemailer v5.1.1](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.0.1](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.18.0](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v3.0.0](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v7.8.0](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v2.0.3](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v2.8.0](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [request v2.88.0](https://www.npmjs.com/package/request) - Request is designed to be the simplest way possible to make HTTP calls.
  - [request-promise v4.2.4](https://www.npmjs.com/package/request-promise) - The simplified HTTP request client 'request' with Promise support. Powered by Bluebird.
  - [rimraf v2.6.3](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v5.6.0](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [@sendgrid/mail v6.3.1](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [serialize-error v3.0.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v2.2.0](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v2.2.0](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v4.1.0](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [twilio v3.28.0](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  - [underscore v1.9.1](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [uuid v3.3.2](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v10.11.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.6.0](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [watson-developer-cloud v4.0.0-rc2](https://www.npmjs.com/package/watson-developer-cloud) - Node.js client library to use the Watson Developer Cloud services, a collection of APIs that use cognitive computing to solve complex problems.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.2.1](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v6.1.4](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xlsx v0.14.1](https://www.npmjs.com/package/xlsx) - Parser and writer for various spreadsheet formats.
  - [xml2js v0.4.19](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.
  - [yazl v2.5.1](https://www.npmjs.com/package/yazl) - yet another zip library for node. For unzipping, see yauzl.


# 1.9.0
Changes:
  - add rc for watson-developer-cloud `4.0.0-rc2`
  - update request-promise from `4.2.2` to `4.2.4`
  - update ws from `6.1.3` to `6.1.4`

NodeJS version:
  - [10.15.1](https://nodejs.org/en/blog/release/v10.15.1/)

NPM Packages:
  - [amqplib v0.5.3](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v2.6.2](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [bent v1.3.0](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [bodyparser v1.18.3](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [cassandra-driver v4.0.0](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [@cloudant/cloudant v3.0.2](https://www.npmjs.com/package/@cloudant/cloudant) - This is the official Cloudant library for Node.js.
  - [commander v2.19.0](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v0.34.1](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.4](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [elasticsearch v15.4.1](https://www.npmjs.com/package/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.0](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v0.2.11](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [formidable v1.2.1](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v7.1.3](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.23.1](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [ibm-cos-sdk v1.4.3](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v2.5.0](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibmiotf v0.2.41](https://www.npmjs.com/package/ibmiotf) - The node.js client is used for simplifying the interaction with the IBM Watson Internet of Things Platform.
  - [iconv-lite v0.4.24](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion
  - [jsdom v13.2.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.9.1](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v8.4.0](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.11](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [log4js v4.0.2](https://www.npmjs.com/package/log4js) - This is a conversion of the log4js framework to work with Node.
  - [marked v0.6.0](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v1.2.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.24.0](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v3.1.13](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mysql v2.16.0](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [mustache v3.0.1](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [nano v8.0.0](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [nodemailer v5.1.1](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.0.1](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.18.0](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v3.0.0](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v7.8.0](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v2.0.3](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v2.8.0](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [request v2.88.0](https://www.npmjs.com/package/request) - Request is designed to be the simplest way possible to make HTTP calls.
  - [request-promise v4.2.4](https://www.npmjs.com/package/request-promise) - The simplified HTTP request client 'request' with Promise support. Powered by Bluebird.
  - [rimraf v2.6.3](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v5.6.0](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [@sendgrid/mail v6.3.1](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [serialize-error v3.0.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v2.2.0](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v2.2.0](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v4.1.0](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [twilio v3.28.0](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  - [underscore v1.9.1](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [uuid v3.3.2](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v10.11.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.6.0](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [watson-developer-cloud v4.0.0-rc2](https://www.npmjs.com/package/watson-developer-cloud) - Node.js client library to use the Watson Developer Cloud services, a collection of APIs that use cognitive computing to solve complex problems.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.2.1](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v6.1.4](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xlsx v0.14.1](https://www.npmjs.com/package/xlsx) - Parser and writer for various spreadsheet formats.
  - [xml2js v0.4.19](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.


# 1.8.0
Changes:
  - update async from `2.6.1` to `2.6.2`
  - update bent from `1.2.0` to `1.3.0`
  - update cookie-parser from `1.4.3` to `1.4.4`
  - update elasticsearch from `15.3.1` to `15.4.1`
  - update ibm-cos-sdk from `1.4.1` to `1.4.3`
  - update log4js from `4.0.1` to `4.0.2`
  - update twilio from `3.27.1` to `3.28.0`

NodeJS version:
  - [10.15.0](https://nodejs.org/en/blog/release/v10.15.0/)

NPM Packages:
  - [amqplib v0.5.3](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v2.6.2](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [bent v1.3.0](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [bodyparser v1.18.3](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [cassandra-driver v4.0.0](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [@cloudant/cloudant v3.0.2](https://www.npmjs.com/package/@cloudant/cloudant) - This is the official Cloudant library for Node.js.
  - [commander v2.19.0](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v0.34.1](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.4](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [elasticsearch v15.4.1](https://www.npmjs.com/package/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.0](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v0.2.11](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [formidable v1.2.1](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v7.1.3](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.23.1](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [ibm-cos-sdk v1.4.3](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v2.5.0](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibmiotf v0.2.41](https://www.npmjs.com/package/ibmiotf) - The node.js client is used for simplifying the interaction with the IBM Watson Internet of Things Platform.
  - [iconv-lite v0.4.24](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion
  - [jsdom v13.2.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.9.1](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v8.4.0](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.11](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [log4js v4.0.2](https://www.npmjs.com/package/log4js) - This is a conversion of the log4js framework to work with Node.
  - [marked v0.6.0](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v1.2.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.24.0](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v3.1.13](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mysql v2.16.0](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [mustache v3.0.1](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [nano v8.0.0](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [nodemailer v5.1.1](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.0.1](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.18.0](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v3.0.0](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v7.8.0](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v2.0.3](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v2.8.0](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [request v2.88.0](https://www.npmjs.com/package/request) - Request is designed to be the simplest way possible to make HTTP calls.
  - [request-promise v4.2.2](https://www.npmjs.com/package/request-promise) - The simplified HTTP request client 'request' with Promise support. Powered by Bluebird.
  - [rimraf v2.6.3](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v5.6.0](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [@sendgrid/mail v6.3.1](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [serialize-error v3.0.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v2.2.0](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v2.2.0](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v4.1.0](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [twilio v3.28.0](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  - [underscore v1.9.1](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [uuid v3.3.2](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v10.11.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.6.0](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.2.1](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v6.1.3](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xlsx v0.14.1](https://www.npmjs.com/package/xlsx) - Parser and writer for various spreadsheet formats.
  - [xml2js v0.4.19](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.


# 1.7.0
Changes:
  - Add log4js `4.0.1`
  - update elasticsearch from `15.3.0` to `15.3.1`
  - update mongodb from `3.1.10` to `3.2.0`
  - update jsdom from `13.1.0` to `13.2.0`
  - update moment from `2.23.0` to `2.24.0`
  - update mongodb from `3.1.12` to `3.1.13`
  - update nano from `7.1.1` to `8.0.0`
  - update ws from `6.1.2` to `6.1.3`
  - update winston from `3.1.0` to `3.2.1`

NodeJS version:
  - [10.15.0](https://nodejs.org/en/blog/release/v10.15.0/)

NPM Packages:
  - [amqplib v0.5.3](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v2.6.1](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [bent v1.2.0](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [bodyparser v1.18.3](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [cassandra-driver v4.0.0](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [@cloudant/cloudant v3.0.2](https://www.npmjs.com/package/@cloudant/cloudant) - This is the official Cloudant library for Node.js.
  - [commander v2.19.0](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v0.34.1](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.3](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [elasticsearch v15.3.1](https://www.npmjs.com/package/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.0](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v0.2.11](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [formidable v1.2.1](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v7.1.3](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.23.1](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [ibm-cos-sdk v1.4.1](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v2.5.0](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibmiotf v0.2.41](https://www.npmjs.com/package/ibmiotf) - The node.js client is used for simplifying the interaction with the IBM Watson Internet of Things Platform.
  - [iconv-lite v0.4.24](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion
  - [jsdom v13.2.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.9.1](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v8.4.0](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.11](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [log4js v4.0.1](https://www.npmjs.com/package/log4js) - This is a conversion of the log4js framework to work with Node.
  - [marked v0.6.0](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v1.2.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.24.0](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v3.1.13](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mysql v2.16.0](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [mustache v3.0.1](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [nano v8.0.0](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [nodemailer v5.1.1](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.0.1](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.18.0](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v3.0.0](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v7.8.0](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v2.0.3](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v2.8.0](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [request v2.88.0](https://www.npmjs.com/package/request) - Request is designed to be the simplest way possible to make HTTP calls.
  - [request-promise v4.2.2](https://www.npmjs.com/package/request-promise) - The simplified HTTP request client 'request' with Promise support. Powered by Bluebird.
  - [rimraf v2.6.3](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v5.6.0](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [@sendgrid/mail v6.3.1](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [serialize-error v3.0.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v2.2.0](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v2.2.0](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v4.1.0](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [twilio v3.27.1](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  - [underscore v1.9.1](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [uuid v3.3.2](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v10.11.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.6.0](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.2.1](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v6.1.3](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xlsx v0.14.1](https://www.npmjs.com/package/xlsx) - Parser and writer for various spreadsheet formats.
  - [xml2js v0.4.19](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.


# 1.6.0
Changes:
  - update elasticsearch from `15.2.0` to `15.3.0`
  - update mongodb from `3.1.10` to `3.1.12`
  - update nodemailer from `5.0.0` to `5.1.1`
  - update path-to-regexp from `2.4.0` to `3.0.0`
  - update pg from `7.7.1` to `7.8.0`
  - update twilio from `3.26.1` to `3.27.1`
  - update validator from `10.10.0` to `10.11.0`

NodeJS version:
  - [10.15.0](https://nodejs.org/en/blog/release/v10.15.0/)

NPM Packages:
  - [amqplib v0.5.3](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v2.6.1](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [bent v1.2.0](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [bodyparser v1.18.3](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [cassandra-driver v4.0.0](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [@cloudant/cloudant v3.0.2](https://www.npmjs.com/package/@cloudant/cloudant) - This is the official Cloudant library for Node.js.
  - [commander v2.19.0](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v0.34.1](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.3](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [elasticsearch v15.3.0](https://www.npmjs.com/package/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.0](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v0.2.11](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [formidable v1.2.1](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v7.1.3](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.23.1](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [ibm-cos-sdk v1.4.1](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v2.5.0](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibmiotf v0.2.41](https://www.npmjs.com/package/ibmiotf) - The node.js client is used for simplifying the interaction with the IBM Watson Internet of Things Platform.
  - [iconv-lite v0.4.24](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion
  - [jsdom v13.1.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.9.1](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v8.4.0](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.11](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [marked v0.6.0](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v1.2.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.23.0](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v3.1.12](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mysql v2.16.0](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [mustache v3.0.1](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [nano v7.1.1](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [nodemailer v5.1.1](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.0.1](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.18.0](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v3.0.0](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v7.8.0](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v2.0.3](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v2.8.0](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [request v2.88.0](https://www.npmjs.com/package/request) - Request is designed to be the simplest way possible to make HTTP calls.
  - [request-promise v4.2.2](https://www.npmjs.com/package/request-promise) - The simplified HTTP request client 'request' with Promise support. Powered by Bluebird.
  - [rimraf v2.6.3](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v5.6.0](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [@sendgrid/mail v6.3.1](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [serialize-error v3.0.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v2.2.0](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v2.2.0](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v4.1.0](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [twilio v3.27.1](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  - [underscore v1.9.1](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [uuid v3.3.2](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v10.11.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.6.0](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.1.0](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v6.1.2](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xlsx v0.14.1](https://www.npmjs.com/package/xlsx) - Parser and writer for various spreadsheet formats.
  - [xml2js v0.4.19](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.

# 1.5.0
Changes:
  - update @cloudant/cloudant from `3.0.1` to `3.0.2`
  - update bent from `1.1.0` to `1.2.0`
  - update cassandra-driver from `3.6.0` to `4.0.0`
  - update marked from `0.5.2` to `0.6.0`
  - update nodemailer from `4.7.0` to `5.0.0`
  - update rimraf from `2.6.2` to `2.6.3`
  - update superagent from `4.0.0` to `4.1.0`
  - update twilio from `3.25.0` to `3.26.1`
  - update validator from `10.9.0` to `10.10.0`
  - add xlsx `0.14.1`

NodeJS version:
  - [10.15.0](https://nodejs.org/en/blog/release/v10.15.0/)

NPM Packages:
  - [amqplib v0.5.3](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v2.6.1](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [bent v1.2.0](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [bodyparser v1.18.3](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [cassandra-driver v4.0.0](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [@cloudant/cloudant v3.0.2](https://www.npmjs.com/package/@cloudant/cloudant) - This is the official Cloudant library for Node.js.
  - [commander v2.19.0](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v0.34.1](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.3](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [elasticsearch v15.2.0](https://www.npmjs.com/package/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.0](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v0.2.11](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [formidable v1.2.1](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v7.1.3](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.23.1](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [ibm-cos-sdk v1.4.1](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v2.5.0](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibmiotf v0.2.41](https://www.npmjs.com/package/ibmiotf) - The node.js client is used for simplifying the interaction with the IBM Watson Internet of Things Platform.
  - [iconv-lite v0.4.24](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion
  - [jsdom v13.1.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.9.1](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v8.4.0](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.11](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [marked v0.6.0](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v1.2.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.23.0](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v3.1.10](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mysql v2.16.0](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [mustache v3.0.1](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [nano v7.1.1](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [nodemailer v5.0.0](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.0.1](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.18.0](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v2.4.0](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v7.7.1](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v2.0.3](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v2.8.0](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [request v2.88.0](https://www.npmjs.com/package/request) - Request is designed to be the simplest way possible to make HTTP calls.
  - [request-promise v4.2.2](https://www.npmjs.com/package/request-promise) - The simplified HTTP request client 'request' with Promise support. Powered by Bluebird.
  - [rimraf v2.6.3](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v5.6.0](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [@sendgrid/mail v6.3.1](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [serialize-error v3.0.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v2.2.0](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v2.2.0](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v4.1.0](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [twilio v3.26.1](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  - [underscore v1.9.1](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [uuid v3.3.2](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v10.10.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.6.0](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.1.0](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v6.1.2](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xlsx v0.14.1](https://www.npmjs.com/package/xlsx) - Parser and writer for various spreadsheet formats.
  - [xml2js v0.4.19](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.

# 1.4.0
Changes:
  - update Node.js from `10.14.0` to `10.14.2`
  - update amqplib from `0.5.2` to `0.5.3`
  - update cassandra-driver from `3.5.0` to `3.6.0`
  - add ibm_db `2.5.0`
  - update ibm-cos-sdk from `1.3.2` to `1.4.1`
  - update jsdom from `13.0.0` to `13.1.0`
  - update moment from `2.22.2` to `2.23.0`
  - update twilio from `3.24.0` to `3.25.0`

NodeJS version:
  - [10.14.2](https://nodejs.org/en/blog/release/v10.14.2/)

NPM Packages:
  - [amqplib v0.5.3](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v2.6.1](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [bent v1.1.0](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [bodyparser v1.18.3](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [cassandra-driver v3.6.0](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [@cloudant/cloudant v3.0.1](https://www.npmjs.com/package/@cloudant/cloudant) - This is the official Cloudant library for Node.js.
  - [commander v2.19.0](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v0.34.1](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.3](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [elasticsearch v15.2.0](https://www.npmjs.com/package/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.0](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v0.2.11](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [formidable v1.2.1](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v7.1.3](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.23.1](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [ibm-cos-sdk v1.4.1](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v2.5.0](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibmiotf v0.2.41](https://www.npmjs.com/package/ibmiotf) - The node.js client is used for simplifying the interaction with the IBM Watson Internet of Things Platform.
  - [iconv-lite v0.4.24](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion
  - [jsdom v13.1.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.9.1](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v8.4.0](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.11](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [marked v0.5.2](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v1.2.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.23.0](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v3.1.10](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mysql v2.16.0](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [mustache v3.0.1](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [nano v7.1.1](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [nodemailer v4.7.0](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.0.1](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.18.0](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v2.4.0](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v7.7.1](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v2.0.3](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v2.8.0](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [request v2.88.0](https://www.npmjs.com/package/request) - Request is designed to be the simplest way possible to make HTTP calls.
  - [request-promise v4.2.2](https://www.npmjs.com/package/request-promise) - The simplified HTTP request client 'request' with Promise support. Powered by Bluebird.
  - [rimraf v2.6.2](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v5.6.0](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [@sendgrid/mail v6.3.1](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [serialize-error v3.0.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v2.2.0](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v2.2.0](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v4.0.0](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [twilio v3.25.0](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  - [underscore v1.9.1](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [uuid v3.3.2](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v10.9.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.6.0](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.1.0](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v6.1.2](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xml2js v0.4.19](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.

# 1.3.0
Changes:
  - update nodejs from `10.13.0` to `10.14.0`
  - update @cloudant/cloudant  from `3.0.0` to `3.0.1`
  - update pg  from `7.6.1` to `7.7.1`
  - update socket.io from `2.1.1` to `2.2.0`
  - update socket.io-client from `2.1.1` to `2.2.0`

NodeJS version:
  - [10.14.0](https://nodejs.org/en/blog/release/v10.14.0/)

NPM Packages:
  - [amqplib v0.5.2](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v2.6.1](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [bent v1.1.0](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [bodyparser v1.18.3](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [cassandra-driver v3.5.0](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [@cloudant/cloudant v3.0.1](https://www.npmjs.com/package/@cloudant/cloudant) - This is the official Cloudant library for Node.js.
  - [commander v2.19.0](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v0.34.1](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.3](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [elasticsearch v15.2.0](https://www.npmjs.com/package/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.0](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v0.2.11](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [formidable v1.2.1](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v7.1.3](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.23.1](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [ibm-cos-sdk v1.3.2](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v2.4.1](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibmiotf v0.2.41](https://www.npmjs.com/package/ibmiotf) - The node.js client is used for simplifying the interaction with the IBM Watson Internet of Things Platform.
  - [iconv-lite v0.4.24](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion
  - [jsdom v13.0.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.9.1](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v8.4.0](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.11](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [marked v0.5.2](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v1.2.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.22.2](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v3.1.10](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mysql v2.16.0](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [mustache v3.0.1](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [nano v7.1.1](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [nodemailer v4.7.0](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.0.1](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.18.0](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v2.4.0](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v7.7.1](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v2.0.3](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v2.8.0](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [request v2.88.0](https://www.npmjs.com/package/request) - Request is designed to be the simplest way possible to make HTTP calls.
  - [request-promise v4.2.2](https://www.npmjs.com/package/request-promise) - The simplified HTTP request client 'request' with Promise support. Powered by Bluebird.
  - [rimraf v2.6.2](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v5.6.0](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [@sendgrid/mail v6.3.1](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [serialize-error v3.0.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v2.2.0](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v2.2.0](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v4.0.0](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [twilio v3.24.0](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  - [underscore v1.9.1](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [uuid v3.3.2](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v10.9.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.6.0](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.1.0](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v6.1.2](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xml2js v0.4.19](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.

# 1.2.0
Changes:
  - update @cloudant/cloudant  from `2.4.1` to `3.0.0`
  - update marked  from `0.5.1` to `0.5.2`
  - update mongodb from `3.1.9` to `3.1.10`
  - update nodemailer from `4.6.8` to `4.7.0`
  - update superagent from `4.0.0-beta.5` to `4.0.0`
  - update twilio from `3.23.2` to `3.24.0`
  - update ws from `6.1.0` to `6.1.2`

NodeJS version:
  - [10.13.0](https://nodejs.org/en/blog/release/v10.13.0/)

NPM Packages:
  - [amqplib v0.5.2](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v2.6.1](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [bent v1.1.0](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [bodyparser v1.18.3](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [cassandra-driver v3.5.0](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [@cloudant/cloudant v3.0.0](https://www.npmjs.com/package/@cloudant/cloudant) - This is the official Cloudant library for Node.js.
  - [commander v2.19.0](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v0.34.1](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.3](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [elasticsearch v15.2.0](https://www.npmjs.com/package/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.0](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v0.2.11](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [formidable v1.2.1](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v7.1.3](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.23.1](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [ibm-cos-sdk v1.3.2](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v2.4.1](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibmiotf v0.2.41](https://www.npmjs.com/package/ibmiotf) - The node.js client is used for simplifying the interaction with the IBM Watson Internet of Things Platform.
  - [iconv-lite v0.4.24](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion
  - [jsdom v13.0.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.9.1](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v8.4.0](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.11](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [marked v0.5.2](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v1.2.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.22.2](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v3.1.10](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mysql v2.16.0](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [mustache v3.0.1](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [nano v7.1.1](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [nodemailer v4.7.0](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.0.1](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.18.0](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v2.4.0](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v7.6.1](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v2.0.3](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v2.8.0](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [request v2.88.0](https://www.npmjs.com/package/request) - Request is designed to be the simplest way possible to make HTTP calls.
  - [request-promise v4.2.2](https://www.npmjs.com/package/request-promise) - The simplified HTTP request client 'request' with Promise support. Powered by Bluebird.
  - [rimraf v2.6.2](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v5.6.0](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [@sendgrid/mail v6.3.1](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [serialize-error v3.0.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v2.1.1](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v2.1.1](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v4.0.0](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [twilio v3.24.0](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  - [underscore v1.9.1](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [uuid v3.3.2](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v10.9.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.6.0](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.1.0](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v6.1.2](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xml2js v0.4.19](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.

# 1.1.0
Changes:
  - update @cloudant/cloudant from `2.4.0` to `2.4.1`
  - update jsonwebtoken  from `8.3.0` to `8.4.0`
  - update mustache from `3.0.0` to `3.0.1`
  - update nano from `7.1.0` to `7.1.1`

NodeJS version:
  - [10.13.0](https://nodejs.org/en/blog/release/v10.13.0/)

NPM Packages:
  - [amqplib v0.5.2](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v2.6.1](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [bent v1.1.0](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [bodyparser v1.18.3](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [cassandra-driver v3.5.0](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [@cloudant/cloudant v2.4.1](https://www.npmjs.com/package/@cloudant/cloudant) - This is the official Cloudant library for Node.js.
  - [commander v2.19.0](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v0.34.1](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.3](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [elasticsearch v15.2.0](https://www.npmjs.com/package/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.0](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v0.2.11](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [formidable v1.2.1](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v7.1.3](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.23.1](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [ibm-cos-sdk v1.3.2](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v2.4.1](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibmiotf v0.2.41](https://www.npmjs.com/package/ibmiotf) - The node.js client is used for simplifying the interaction with the IBM Watson Internet of Things Platform.
  - [iconv-lite v0.4.24](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion
  - [jsdom v13.0.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.9.1](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v8.4.0](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.11](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [marked v0.5.1](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v1.2.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.22.2](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v3.1.9](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mysql v2.16.0](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [mustache v3.0.1](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [nano v7.1.1](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [nodemailer v4.6.8](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.0.1](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.18.0](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v2.4.0](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v7.6.1](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v2.0.3](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v2.8.0](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [request v2.88.0](https://www.npmjs.com/package/request) - Request is designed to be the simplest way possible to make HTTP calls.
  - [request-promise v4.2.2](https://www.npmjs.com/package/request-promise) - The simplified HTTP request client 'request' with Promise support. Powered by Bluebird.
  - [rimraf v2.6.2](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v5.6.0](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [@sendgrid/mail v6.3.1](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [serialize-error v3.0.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v2.1.1](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v2.1.1](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v4.0.0-beta.5](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [twilio v3.23.2](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  - [underscore v1.9.1](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [uuid v3.3.2](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v10.9.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.6.0](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.1.0](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v6.1.0](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xml2js v0.4.19](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.

# 1.0.0
Initial release.
This release doesn't include package `watson-developer-cloud` because it intends to include new major release `4.x` in the near future.
The `nodejs:8` runtime includes version `3.x` of ``watson-developer-cloud`.

NodeJS version:
  - [10.13.0](https://nodejs.org/en/blog/release/v10.13.0/)

NPM Packages:
  - [amqplib v0.5.2](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v2.6.1](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [bent v1.1.0](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [bodyparser v1.18.3](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [cassandra-driver v3.5.0](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [@cloudant/cloudant v2.4.0](https://www.npmjs.com/package/@cloudant/cloudant) - This is the official Cloudant library for Node.js.
  - [commander v2.19.0](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v0.34.1](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.3](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [elasticsearch v15.2.0](https://www.npmjs.com/package/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.0](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v0.2.11](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [formidable v1.2.1](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v7.1.3](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.23.1](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [ibm-cos-sdk v1.3.2](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v2.4.1](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibmiotf v0.2.41](https://www.npmjs.com/package/ibmiotf) - The node.js client is used for simplifying the interaction with the IBM Watson Internet of Things Platform.
  - [iconv-lite v0.4.24](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion
  - [jsdom v13.0.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.9.1](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v8.3.0](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.11](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [marked v0.5.1](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v1.2.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.22.2](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v3.1.9](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mysql v2.16.0](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [mustache v3.0.0](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [nano v7.0.1](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [nodemailer v4.6.8](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.0.1](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.18.0](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v2.4.0](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v7.6.1](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v2.0.3](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v2.8.0](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [request v2.88.0](https://www.npmjs.com/package/request) - Request is designed to be the simplest way possible to make HTTP calls.
  - [request-promise v4.2.2](https://www.npmjs.com/package/request-promise) - The simplified HTTP request client 'request' with Promise support. Powered by Bluebird.
  - [rimraf v2.6.2](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v5.6.0](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [@sendgrid/mail v6.3.1](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [serialize-error v3.0.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v2.1.1](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v2.1.1](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v4.0.0-beta.5](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [twilio v3.23.2](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  - [underscore v1.9.1](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [uuid v3.3.2](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v10.9.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.6.0](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.1.0](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v6.1.0](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xml2js v0.4.19](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.
