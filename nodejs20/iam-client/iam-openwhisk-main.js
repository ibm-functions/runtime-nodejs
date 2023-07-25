// Licensed to the Apache Software Foundation (ASF) under one or more contributor
// license agreements; and to You under the Apache License, Version 2.0.

const Actions = require('./actions.js')
const Activations = require('./activations.js')
const Namespaces = require('./namespaces.js')
const Packages = require('./packages.js')
const Rules = require('./rules.js')
const Triggers = require('./triggers.js')
const Feeds = require('./feeds.js')
const Routes = require('./routes.js')
const Client = require('./client.js')
const AuthHandler = require('@ibm-functions/iam-token-manager')
const IAM_NAMESPACE_API_KEY = '__OW_IAM_NAMESPACE_API_KEY'
const IAM_NAMESPACE_URL = '__OW_IAM_API_URL'
const NAMESPACE = '__OW_NAMESPACE'
const OpenWhisk = (options) => {
  options = options || {}
  if (process.env[IAM_NAMESPACE_API_KEY] && !options.api_key) {
    if (!options.auth_handler) {
      if(!options.iamApikey){
        options.iamApikey = process.env[IAM_NAMESPACE_API_KEY]
      }
      if(process.env[IAM_NAMESPACE_URL] && !options.iamUrl){
        options.iamUrl = process.env[IAM_NAMESPACE_URL]
      }
      options.auth_handler = new AuthHandler(options)
    }
    if (!options.namespace || options.namespace === '_') {
      options.namespace = process.env[NAMESPACE]
    }
  }
  const client = new Client(options)
  return {
    actions: new Actions(client),
    activations: new Activations(client),
    namespaces: new Namespaces(client),
    packages: new Packages(client),
    rules: new Rules(client),
    triggers: new Triggers(client),
    feeds: new Feeds(client),
    routes: new Routes(client)
  }
}

module.exports = OpenWhisk
