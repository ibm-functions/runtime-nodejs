
var DiscoveryV1 = require('watson-developer-cloud/discovery/v1');

function main(args){
  var discovery = new DiscoveryV1({
    use_unauthenticated: true,
    version_date: DiscoveryV1.VERSION_DATE_2017_09_01
  });

  var valueOfDiscoveryObjectVersion = discovery._options.qs.version;

  return {message: valueOfDiscoveryObjectVersion}
}
