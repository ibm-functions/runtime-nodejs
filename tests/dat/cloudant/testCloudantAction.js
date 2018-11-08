var Cloudant = process.version.startsWith('v8.') ? require("cloudant") : require("@cloudant/cloudant")

function main(args){
  var username = args.username;
  var password = args.password;
  var dbName = `test_cloud_functions_nodejs_${process.version}_ibm_runtime`

  //Configuration to use Cloudant
  var cloudant = Cloudant({account:username, password:password, plugin:'promises'});

  var beforeAction = new Promise(function(resolve ,reject){
    cloudant.db.destroy(dbName)
    .then(function(){
      console.log("Previous database with name: "+dbName+"existed; it was cleaned up so that tests can run");
      return resolve();
    })
    .catch(function(){
      return resolve();
    })
  });

  //Create the cloudant database
  return beforeAction.then(function(){
    return cloudant.db.create(dbName)
  })
  .then(function(data){
    //Switch to use that newly created database.
    return cloudant.db.use(dbName);
  })
  .then(function(db){
    var friendinfo;
    //Inject a json document named friend1 into the database.
    return db.insert({firstname: "Suzzy", lastname: "Queue"}, 'friend1')
    .then(function(){
      //fetch the newly injected document from the database
      return db.get('friend1');
    })
    .then(function(data){
      friendinfo = data;
      //destroy the database
      return cloudant.db.destroy(dbName);
    })
    .then(function(){
      //return the document fetched from the db
      return friendinfo;
    })
  })
  .catch(function(err){
    //If an error occurrs at any part in execution; return error
    return {err: err}
  })
}
