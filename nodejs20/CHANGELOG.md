# IBM Functions NodeJS 16 Runtime Container

## Migrating from `nodejs:12` to `nodejs:16`
  - The `@cloudant/cloudant` package is deprecated and therefore not available in this runtime. Please see the [Migration Guide](https://github.com/cloudant/nodejs-cloudant/blob/HEAD/MIGRATION.md) for advice about migrating to the replacement library [@ibm-cloud/cloudant](https://github.com/IBM/cloudant-node-sdk).  
  - The `request-promise` package is deprecated and therefore not avalable in this runtime. You may use `axios`, `bent`, `got` or `needle` as an alternative.
  - The `elasticsearch` package is no longer maintained and ha been replaced with `@elastic/elasticsearch `and is therefore not available in this runtime. Please see the [Migration Guide](https://www.elastic.co/guide/en/elasticsearch/client/javascript-api/current/breaking-changes.html)
  - Mongodb drivers have been upgraded to version 4 please check the [Upgrade Guide](https://github.com/mongodb/node-mongodb-native/blob/HEAD/docs/CHANGES_4.0.0.md)
  - The `redis` package has been updated to version 4 please check the [Migration Guide](https://github.com/redis/node-redis/blob/HEAD/docs/v3-to-v4.md)

# 1.0.0

NodeJS version:
  - [20.19.0](https://nodejs.org/en/blog/release/v14.19.0/)

NPM version:
  - [6.14.15](https://github.com/npm/cli/releases/tag/v6.14.15)

NPM Packages:
  - [@ibm-cloud/cloudant v0.0.25](https://www.npmjs.com/package/@ibm-cloud/cloudant) - This is the official Cloudant library for Node.js.
  - [@ibm-functions/iam-token-manager v1.0.7](https://www.npmjs.com/package/@ibm-functions/iam-token-manager) - This is an IAM access token manager library for Node.js.
  - [@sendgrid/mail v6.6.1](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [@wiotp/sdk v0.7.8](https://www.npmjs.com/package/@wiotp/sdk) - IBM Watson IoT Platform Javascript SDK.
  - [amqplib v0.8.0](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v3.2.3](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [axios v0.26.0](https://www.npmjs.com/package/axios) - Promise based HTTP client for the browser and node.js.
  - [bent v7.3.12](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [bodyparser v1.19.2](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [bufferutil 4.0.6](https://www.npmjs.com/package/bufferutil) - bufferutil is what makes ws fast.
  - [canvas 2.9.0](https://www.npmjs.com/package/canvas) - A Cairo-backed Canvas implementation for Node.js.
  - [cassandra-driver v4.6.3](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [commander v9.0.0](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v0.40.0](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.6](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [core-js v3.21.1](https://www.npmjs.com/package/core-js) - Modular standard library for JavaScript.
  - [@elastic/elasticsearch v8.0.0](https://www.npmjs.com/package/@elastic/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.1](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v1.1.0](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [express v4.17.3](https://www.npmjs.com/package/express) - A Fast, unopinionated, minimalist web framework for node.
  - [express-session v1.17.2](https://www.npmjs.com/package/express-session) - A server side session data storing module.
  - [formidable v2.0.1](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v7.2.0](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.23.1](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [got v12.0.1](https://www.npmjs.com/package/got) - Human-friendly and powerful HTTP request library for Node.js.
  - [ibm-cos-sdk v1.11.0](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v2.8.1](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibm-watson v6.2.2](https://www.npmjs.com/package/ibm-watson) - A node.js client library to use the Watson APIs.
  - [iconv-lite v0.6.3](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion.
  - [jest v27.5.1](https://www.npmjs.com/package/jest) - Delightful JavaScript Testing.
  - [jsdom v19.0.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.11.0](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v8.5.1](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.21](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [log4js v6.4.1](https://www.npmjs.com/package/log4js) - This is a conversion of the log4js framework to work with node.
  - [marked v4.0.12](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v2.1.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.29.1](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v4.3.1](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mustache v4.2.0](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [mysql v2.18.1](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [nano v9.0.5](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [needle v3.0.0](https://www.npmjs.com/package/needle) - The leanest and most handsome HTTP client in the Nodelands.
  - [nodemailer v6.7.2](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.1.1](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.21.6](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v6.2.0](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v8.7.3](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v3.0.2](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v4.0.3](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [rimraf v3.0.2](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v7.3.5](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [serialize-error v9.1.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v4.4.1](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v4.4.1](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v7.1.1](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [tmp v0.2.1](https://www.npmjs.com/package/tmp) - A simple temporary file and directory creator for node.js.
  - [ts-jest v27.1.3](https://www.npmjs.com/package/ts-jest) - A TypeScript preprocessor with source map support for Jest that lets you use Jest to test projects written in TypeScript.
  - [twilio v3.74.0](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  -[typescript v4.5.5](https://www.npmjs.com/package/typescript) - TypeScript is a language for application scale JavaScript development
  - [underscore v1.13.2](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [utf-8-validate v5.0.8](https://www.npmjs.com/package/utf-8-validate) - Check if a buffer contains valid UTF-8 encoded text.
  - [uuid v8.3.2](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v13.7.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.7.1](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.6.0](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v8.5.0](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xlsx v0.18.2](https://www.npmjs.com/package/xlsx) - Parser and writer for various spreadsheet formats.
  - [xml2js v0.4.23](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.
  - [yazl v2.5.1](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.
