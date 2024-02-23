# IBM Functions NodeJS 20 Runtime Container

## Migrating from `nodejs:16` to `nodejs:20`
  Some of the packages have been updated to the latest version and might contain breaking changes please check that the packages you use are still working as expected all supported packages are refrenced in the [package.json](nodejs20/package.json).

  - The `@ibm-cloud/cloudant` package has been updated from 0.3.x to 0.5.x and contains breaking changes check the Repository for changes [cloudant-node-sdk](https://github.com/IBM/cloudant-node-sdk)

# 1.4.0
  Changes:
  - Update parent image to latest Openwhisk Tag 110a0f4
  - Update package openwhisk from 3.21.7 to 3.21.8

  NodeJS version:
  - v20.11.1

  NPM version:
  - v10.2.4

  NodeJS packages:
  - The file [package.json](package.json) lists the packages we guarantee to be included in this runtime.
    Ensure that you only use packages mentioned there. Other nodejs packages might be part of this runtime, but only due to indirect dependencies of the above listed packages. These indirectly included packages are candidates to be removed at any time in case they are not required by the referring package anymore.

# 1.3.0
  Changes:
  - Update base image to latest Openwhisk Tag 08763c2
  
  NodeJS version:
  - v20.7.0

  NPM version:
  - v10.1.0

  NodeJS packages:
  - The file [package.json](package.json) lists the packages we guarantee to be included in this runtime.
    Ensure that you only use packages mentioned there. Other nodejs packages might be part of this runtime, but only due to indirect dependencies of the above listed packages. These indirectly included packages are candidates to be removed at any time in case they are not required by the referring package anymore.

# 1.2.0
  Changes:
  - Update Axios to 1.6.1 in order to fix vulnerability
  
  NodeJS version:
  - v20.7.0

  NPM version:
  - v10.1.0

  NodeJS packages:
  - The file [package.json](package.json) lists the packages we guarantee to be included in this runtime.
    Ensure that you only use packages mentioned there. Other nodejs packages might be part of this runtime, but only due to indirect dependencies of the above listed packages. These indirectly included packages are candidates to be removed at any time in case they are not required by the referring package anymore.

# 1.1.0
  Changes:
  - Update base image to latest Openwhisk Tag c60a667
  
  NodeJS version:
  - v20.7.0

  NPM version:
  - v10.1.0

  NodeJS packages:
  - The file [package.json](package.json) lists the packages we guarantee to be included in this runtime.
    Ensure that you only use packages mentioned there. Other nodejs packages might be part of this runtime, but only due to indirect dependencies of the above listed packages. These indirectly included packages are candidates to be removed at any time in case they are not required by the referring package anymore.

# 1.0.0

NodeJS version:
  - [20.19.0](https://nodejs.org/en/blog/release/v20.19.0/)

NPM version:
  - [9.8.0](https://github.com/npm/cli/releases/tag/v9.8.0)

NPM Packages:
  - [@ibm-cloud/cloudant v0.5.55](https://www.npmjs.com/package/@ibm-cloud/cloudant) - This is the official Cloudant library for Node.js.
  - [@ibm-functions/iam-token-manager v1.0.11](https://www.npmjs.com/package/@ibm-functions/iam-token-manager) - This is an IAM access token manager library for Node.js.
  - [@sendgrid/mail v7.7.0](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [@wiotp/sdk v0.7.8](https://www.npmjs.com/package/@wiotp/sdk) - IBM Watson IoT Platform Javascript SDK.
  - [amqplib v0.10.3](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v3.2.4](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [axios v1.4.0](https://www.npmjs.com/package/axios) - Promise based HTTP client for the browser and node.js.
  - [bent v7.3.12](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [bodyparser v1.20.2](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [bufferutil 4.0.7](https://www.npmjs.com/package/bufferutil) - bufferutil is what makes ws fast.
  - [canvas v2.11.2](https://www.npmjs.com/package/canvas) - A Cairo-backed Canvas implementation for Node.js.
  - [cassandra-driver v4.6.4](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [commander v11.0.0](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v1.2.0](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.6](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [core-js v3.21.1](https://www.npmjs.com/package/core-js) - Modular standard library for JavaScript.
  - [@elastic/elasticsearch v8.8.1](https://www.npmjs.com/package/@elastic/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.1](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v1.1.0](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [express v4.17.3](https://www.npmjs.com/package/express) - A Fast, unopinionated, minimalist web framework for node.
  - [express-session v1.17.3](https://www.npmjs.com/package/express-session) - A server side session data storing module.
  - [formidable v3.5.0](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v10.3.3](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.25.0](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [got v13.0.0](https://www.npmjs.com/package/got) - Human-friendly and powerful HTTP request library for Node.js.
  - [ibm-cos-sdk v1.13.1](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v3.2.1](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibm-watson v8.0.0](https://www.npmjs.com/package/ibm-watson) - A node.js client library to use the Watson APIs.
  - [iconv-lite v0.6.3](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion.
  - [jest v29.6.1](https://www.npmjs.com/package/jest) - Delightful JavaScript Testing.
  - [jsdom v22.1.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.11.1](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v9.0.1](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.21](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [log4js v6.9.1](https://www.npmjs.com/package/log4js) - This is a conversion of the log4js framework to work with node.
  - [marked v5.1.1](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v2.1.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.29.1](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v5.7.0](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mustache v4.2.0](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [mysql v2.18.1](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [nano v10.1.2](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [needle v3.2.0](https://www.npmjs.com/package/needle) - The leanest and most handsome HTTP client in the Nodelands.
  - [nodemailer v6.9.4](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.1.1](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.21.7](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v6.2.1](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v8.11.1](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v3.0.2](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v4.0.4](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [rimraf v5.0.1](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v7.5.4](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [serialize-error v9.1.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v4.7.1](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v4.7.1](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v8.0.9](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [tmp v0.2.1](https://www.npmjs.com/package/tmp) - A simple temporary file and directory creator for node.js.
  - [ts-jest v29.1.1](https://www.npmjs.com/package/ts-jest) - A TypeScript preprocessor with source map support for Jest that lets you use Jest to test projects written in TypeScript.
  - [twilio v4.13.0](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  - [underscore v1.13.6](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [utf-8-validate v6.0.3](https://www.npmjs.com/package/utf-8-validate) - Check if a buffer contains valid UTF-8 encoded text.
  - [uuid v8.3.2](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v13.9.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.7.1](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.10.0](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v8.13.0](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xlsx v0.18.5](https://www.npmjs.com/package/xlsx) - Parser and writer for various spreadsheet formats.
  - [xml2js v0.6.0](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.
  - [yazl v2.5.1](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.
