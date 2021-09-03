// This will error out if watson not available.
// For the nodejs12 runtime (and later) we use the ibm-watson package. On the previous
// runtime versions we use the watson-developer-cloud package.
var DiscoveryV1 = process.version.startsWith('v10.') ? require("watson-developer-cloud/discovery/v1")
                                                     : require("ibm-watson/discovery/v1")


function main(args){
  return {}
}
