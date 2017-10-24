var Cloudant = require("cloudant");

function main(args){
  var cloudant = Cloudant({account: "test", password: "test",plugin:'promises'})
  if(cloudant.config.url == "https://test:test@test.cloudant.com")
    return {message: "cloudant url formed successfully"};
  else
    return {err: "url did not match expected"}



}
