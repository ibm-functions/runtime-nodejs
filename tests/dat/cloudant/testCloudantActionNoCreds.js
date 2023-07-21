if (process.version.startsWith('v8.')) {
  var Cloudant = require("cloudant")
} else if (process.version.startsWith('v18.')) {
  var { CloudantV1 } = require('@ibm-cloud/cloudant');
} else {
  var Cloudant = require("@cloudant/cloudant")
}


function main(args){
  if (process.version.startsWith('v18.')) {
    try {
      var { CloudantV1 } = require('@ibm-cloud/cloudant');
      var version = require('@ibm-cloud/cloudant').version
    } catch (er) {
      return {err: "url did not match expected"}
    }
    console.log(version)
    return {message: "cloudant url formed successfully"};
  } else {
    var cloudant = Cloudant({account: "test", password: "test",plugin:'promises'})
    if(cloudant.config.url == "https://test:test@test.cloudant.com")
      return {message: "cloudant url formed successfully"};
    else
      return {err: "url did not match expected"}
  }
 



}
