# IBM Functions NodeJS 12 Runtime Container

## Migrating from `nodejs:10` to `nodejs:12`
  - The ibm-watson sdk version moved to 5.x. It includes a number of breaking changes. See https://github.com/watson-developer-cloud/node-sdk/blob/HEAD/MIGRATION-V5.md for details.
  - The `ibmiotf` package is renamed to `@wiotp/sdk`. See https://www.npmjs.com/package/@wiotp/sdk for all changes.
  - The `request` package is deprecated and therefore not available in this runtime.

# 1.0.2
NodeJS version:
  - [12.19.1](https://nodejs.org/en/blog/release/v12.19.1/)

# 1.0.1
NodeJS version:
  - [12.18.4](https://nodejs.org/en/blog/release/v12.18.4/)

# 1.0.0
Initial release.

NodeJS version:
  - [12.18.2](https://nodejs.org/en/blog/release/v12.18.2/)

NPM version:
  - [6.14.5](https://github.com/npm/cli/releases/tag/v6.14.5)

NPM Packages:
  - [@cloudant/cloudant v4.2.3](https://www.npmjs.com/package/@cloudant/cloudant) - This is the official Cloudant library for Node.js.
  - [@ibm-functions/iam-token-manager v1.0.4](https://www.npmjs.com/package/@ibm-functions/iam-token-manager) - This is an IAM access token manager library for Node.js.
  - [@sendgrid/mail v6.5.2](https://www.npmjs.com/package/@sendgrid/mail) - Provides email support via the SendGrid API.
  - [@wiotp/sdk v0.6.2](https://www.npmjs.com/package/@wiotp/sdk) - IBM Watson IoT Platform Javascript SDK.
  - [amqplib v0.5.5](https://www.npmjs.com/package/amqplib) - A library for making AMQP 0-9-1 clients for Node.JS.
  - [apn v2.2.0](https://www.npmjs.com/package/apn) - A Node.js module for interfacing with the Apple Push Notification service.
  - [async v3.1.1](https://www.npmjs.com/package/async) - Provides functions for working with asynchronous functions.
  - [axios v0.19.2](https://www.npmjs.com/package/axios) - Promise based HTTP client for the browser and node.js.
  - [bent v7.0.5](https://www.npmjs.com/package/bent) - Functional HTTP client for Node.js w/ async/await.
  - [bodyparser v1.18.3](https://www.npmjs.com/package/body-parser) - Parse incoming request bodies in a middleware before your handlers, available under the req.body property.
  - [btoa v1.2.1](https://www.npmjs.com/package/btoa) - A port of the browser's btoa function.
  - [bufferutil 4.0.1](https://www.npmjs.com/package/bufferutil) - bufferutil is what makes ws fast.
  - [canvas 2.6.1](https://www.npmjs.com/package/canvas) - A Cairo-backed Canvas implementation for Node.js.
  - [cassandra-driver v4.4.0](https://www.npmjs.com/package/cassandra-driver) - DataStax Node.js Driver for Apache Cassandra.
  - [commander v4.1.1](https://www.npmjs.com/package/commander) - The complete solution for node.js command-line interfaces.
  - [composeaddresstranslator v1.0.4](https://www.npmjs.com/package/composeaddresstranslator) - Address translator from Compose UI or API for Scylla databases.
  - [consul v0.37.0](https://www.npmjs.com/package/consul) - A client for Consul, involving service discovery and configuration.
  - [cookie-parser v1.4.4](https://www.npmjs.com/package/cookie-parser) - Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  - [core-js v3.6.4](https://www.npmjs.com/package/core-js) - Modular standard library for JavaScript.
  - [elasticsearch v16.6.0](https://www.npmjs.com/package/elasticsearch) - The official low-level Elasticsearch client for Node.js.
  - [errorhandler v1.5.1](https://www.npmjs.com/package/errorhandler) - Development-only error handler middleware.
  - [etcd3 v0.2.13](https://www.npmjs.com/package/etcd3) - A high-quality, production-ready client for the Protocol Buffer-based etcdv3 API.
  - [express v4.16.4](https://www.npmjs.com/package/express) - A Fast, unopinionated, minimalist web framework for node.
  - [express-session v1.17.0](https://www.npmjs.com/package/express-session) - A server side session data storing module.
  - [formidable v1.2.1](https://www.npmjs.com/package/formidable) - A Node.js module for parsing form data, especially file uploads.
  - [glob v7.1.6](https://www.npmjs.com/package/glob) - Match files using the patterns the shell uses, like stars and stuff.
  - [gm v1.23.1](https://www.npmjs.com/package/gm) - GraphicsMagick and ImageMagick for Node.
  - [got v11.5.1](https://www.npmjs.com/package/got) - Human-friendly and powerful HTTP request library for Node.js.
  - [ibm-cos-sdk v1.6.0](https://www.npmjs.com/package/ibm-cos-sdk) - {{site.data.keyword.cos_full}} SDK for Node.js
  - [ibm_db v2.6.3](https://www.npmjs.com/package/ibm_db) - An asynchronous/synchronous interface for node.js to IBM DB2 and IBM Informix.
  - [ibm-watson v5.3.1](https://www.npmjs.com/package/ibm-watson) - A node.js client library to use the Watson APIs.
  - [iconv-lite v0.5.1](https://www.npmjs.com/package/iconv-lite) - Pure JS character encoding conversion.
  - [jest v25.1.0](https://www.npmjs.com/package/jest) - Delightful JavaScript Testing.
  - [jsdom v16.1.0](https://www.npmjs.com/package/jsdom) - jsdom is a pure-JavaScript implementation of many web standards, notably the WHATWG DOM and HTML Standards.
  - [jsforce v1.9.3](https://www.npmjs.com/package/jsforce)Salesforce API Library for JavaScript applications.
  - [jsonwebtoken v8.5.1](https://www.npmjs.com/package/jsonwebtoken) - An implementation of JSON Web Tokens.
  - [lodash v4.17.19](https://www.npmjs.com/package/lodash) - The Lodash library exported as Node.js modules.
  - [log4js v6.1.2](https://www.npmjs.com/package/log4js) - This is a conversion of the log4js framework to work with node.
  - [marked v0.8.0](https://www.npmjs.com/package/marked) - A full-featured markdown parser and compiler, written in JavaScript. Built for speed.
  - [merge v1.2.1](https://www.npmjs.com/package/merge) - Merge multiple objects into one, optionally creating a new cloned object.
  - [moment v2.24.0](https://www.npmjs.com/package/moment) - A lightweight JavaScript date library for parsing, validating, manipulating, and formatting dates.
  - [mongodb v3.5.2](https://www.npmjs.com/package/mongodb) - The official MongoDB driver for Node.js.
  - [mustache v4.0.0](https://www.npmjs.com/package/mustache) - mustache.js is an implementation of the mustache template system in JavaScript.
  - [mysql v2.18.1](https://www.npmjs.com/package/mysql) - This is a node.js driver for mysql.
  - [nano v8.1.0](https://www.npmjs.com/package/nano) - minimalistic couchdb driver for Node.js.
  - [needle v2.5.0](https://www.npmjs.com/package/needle) - The leanest and most handsome HTTP client in the Nodelands.
  - [nodemailer v6.4.2](https://www.npmjs.com/package/nodemailer) - Send e-mails from Node.js – easy as cake!
  - [oauth2-server v3.0.1](https://www.npmjs.com/package/oauth2-server) - Complete, compliant and well tested module for implementing an OAuth2 Server/Provider with express in Node.js.
  - [openwhisk v3.18.0](https://www.npmjs.com/package/openwhisk) - JavaScript client library for the OpenWhisk platform. Provides a wrapper around the OpenWhisk APIs.
  - [path-to-regex v6.1.0](https://www.npmjs.com/package/path-to-regexp) - Turn a path string such as /user/:name into a regular expression which can then be used to match against URL paths.
  - [pg v7.18.1](https://www.npmjs.com/package/pg) - Non-blocking PostgreSQL client for node.js. Pure JavaScript and optional native libpq bindings.
  - [process v0.11.10](https://www.npmjs.com/package/process) - require('process'); just like any other module.
  - [pug v2.0.4](https://www.npmjs.com/package/pug) - Implements the Pug templating language.
  - [redis v2.8.0](https://www.npmjs.com/package/redis) - This is a complete and feature rich Redis client for Node.js.
  - [request-promise v4.2.5](https://www.npmjs.com/package/request-promise) - The simplified HTTP request client 'request' with Promise support. Powered by Bluebird.
  - [rimraf v3.0.2](https://www.npmjs.com/package/rimraf) - The UNIX command rm -rf for node.
  - [semver v7.1.2](https://www.npmjs.com/package/semver) - Semantic Versioning for Nodejs
  - [serialize-error v3.0.0](https://www.npmjs.com/package/serialize-error) - Serialize an error into a plain object.
  - [serve-favicon v2.5.0](https://www.npmjs.com/package/serve-favicon) - Node.js middleware for serving a favicon.
  - [socket.io v2.3.0](https://www.npmjs.com/package/socket.io) - Socket.IO enables real-time bidirectional event-based communication.
  - [socket.io-client v2.3.0](https://www.npmjs.com/package/socket.io-client) - Realtime application framework for socket.io.
  - [superagent v5.2.1](https://www.npmjs.com/package/superagent) - SuperAgent is a small progressive client-side HTTP request library, and Node.js module with the same API, sporting many high-level HTTP client features.
  - [swagger-tools v0.10.4](https://www.npmjs.com/package/swagger-tools) - Package that provides various tools for integrating and interacting with Swagger.
  - [tmp v0.1.0](https://www.npmjs.com/package/tmp) - A simple temporary file and directory creator for node.js.
  - [ts-jest v25.2.0](https://www.npmjs.com/package/ts-jest) - A TypeScript preprocessor with source map support for Jest that lets you use Jest to test projects written in TypeScript.
  - [twilio v3.39.4](https://www.npmjs.com/package/twilio) - A wrapper for the Twilio API, related to voice, video, and messaging.
  - [underscore v1.9.2](https://www.npmjs.com/package/underscore) - Underscore.js is a utility-belt library for JavaScript that provides support for the usual functional suspects (each, map, reduce, filter...) without extending any core JavaScript objects.
  - [url-pattern v1.0.3](https://www.npmjs.com/package/url-pattern) - Parse URLs for path parameters more easily than from using a regex string matcher.
  - [utf-8-validate v5.0.2](https://www.npmjs.com/package/utf-8-validate) - Check if a buffer contains valid UTF-8 encoded text.
  - [uuid v3.3.0](https://www.npmjs.com/package/uuid) - Simple, fast generation of RFC4122 UUIDS.
  - [validator v12.2.0](https://www.npmjs.com/package/validator) - A library of string validators and sanitizers.
  - [vcap_services v0.7.1](https://www.npmjs.com/package/vcap_services)Parse and return service credentials from VCAP_SERVICES environment variable that IBM Cloud provides.
  - [when v3.7.8](https://www.npmjs.com/package/when) - When.js is a rock solid, battle-tested Promises/A+ and when() implementation, including a complete ES6 Promise shim.
  - [winston v3.2.1](https://www.npmjs.com/package/winston) - A multi-transport async logging library for node.js. "CHILL WINSTON! ... I put it in the logs."
  - [ws v7.2.1](https://www.npmjs.com/package/ws) - ws is a simple to use, blazing fast, and thoroughly tested WebSocket client and server implementation.
  - [xlsx v0.15.5](https://www.npmjs.com/package/xlsx) - Parser and writer for various spreadsheet formats.
  - [xml2js v0.4.23](https://www.npmjs.com/package/xml2js) - Simple XML to JavaScript object converter. It supports bi-directional conversion.
  - [xmlhttprequest v1.8.0](https://www.npmjs.com/package/xmlhttprequest) - node-XMLHttpRequest is a wrapper for the built-in http client to emulate the browser XMLHttpRequest object.
  - [yauzl v2.10.0](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.
  - [yazl v2.5.1](https://www.npmjs.com/package/yauzl) - yet another unzip library for node. For zipping.
