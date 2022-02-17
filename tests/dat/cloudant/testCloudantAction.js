const nodeRuntime = process.version.startsWith('v8.') ? 'nodejs8' : 'nodejs10'
const isNodeJS8 = nodeRuntime === 'nodejs8' ? true : false
//var Cloudant = isNodeJS8 ? require("cloudant") : require("@cloudant/cloudant")

if (process.version.startsWith('v8.')) {
  var Cloudant = require("cloudant")
} else if (process.version.startsWith('v16.')) {
  console.log("------------------------- require @ibm-cloud/cloudant ----------------------");
  var { CloudantV1 } = require('@ibm-cloud/cloudant');
} else {
  var Cloudant = require("@cloudant/cloudant")
}

function main(args){
  var username = args.username;
  var password = args.password;
  var url = args.url;
  var dbName = `test_cloud_functions_nodejs_${nodeRuntime}_ibm_runtime`

  if (process.version.startsWith('v16.')) {
    process.env['CLOUDANT_AUTH_TYPE'] = 'BASIC'
    process.env['CLOUDANT_URL'] = url
    process.env['CLOUDANT_USERNAME'] = username
    process.env['CLOUDANT_PASSWORD'] = password

    // 1. Create a client with `CLOUDANT` default service name
    const client = CloudantV1.newInstance({});
    // Create DB
    const createDb = client.putDatabase({ db: dbName })
      .then((putDatabaseResult) => {
        if (putDatabaseResult.result.ok) {
          console.log(`"${dbName}" database created."`);
        }
      })
      .catch((err) => {
        if (err.code === 412) {
          console.log(
            `Cannot create "${dbName}" database, it already exists.`
          );
        }
      });

    var friendinfo;
    // Writte to DB
    return createDb.then(() => {
      client
        .postDocument({
          db: dbName,
          document: {
            "_id" :  'friend1',
            "firstname": "Suzzy",
            "lastname": "Queue"
          }
        })
        .then((createDocumentResponse) => {
          rev = createDocumentResponse.result.rev;
          console.log('You have created the document:\n');
        });
    }).then(() => {
      // call service with predefined parameters:
      console.log('client.getDocument:\n');
      return client.getDocument({db: dbName, docId: 'friend1'}).then((document) => {
        return document;
      });
    }).then((data) => {
      friendinfo = data
      console.log('client.deleteDatabase friend=',friendinfo);
      return client.deleteDatabase({db: dbName}) //.then((db) => {return db})
    }).then(function(){
      console.log('return the document=', friendinfo);
      //return the document fetched from the db
      return friendinfo;
    }).catch(function(err){
      console.log('error received:', err);
      //If an error occurrs at any part in execution; return error
      return {err: err}
    })

    //fetch from DB


  } else {
      //Configuration to use Cloudant
  var config = {account:username, password:password}
  isNodeJS8 ? config.plugin='promises' : config.plugins=['promises']
  var cloudant = Cloudant(config);

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
}