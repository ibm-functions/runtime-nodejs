

const nodeRuntime = process.version.startsWith('v8.') ? 'nodejs8' : 'nodejs10'
const isNodeJS8 = nodeRuntime === 'nodejs8' ? true : false

// This will error out if watson not available
var DiscoveryV1 = isNodeJS8 ? require('watson-developer-cloud/discovery/v1') : require('watson-developer-cloud/discovery/v1-generated')

function main(args){
  return {}
}
