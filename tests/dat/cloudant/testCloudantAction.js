// get the actual node version
var nodeRuntime="unsupported";
switch (true) {
  case process.version.startsWith("v10."): nodeRuntime = "nodejs10"; break;
  case process.version.startsWith("v12."): nodeRuntime = "nodejs12"; break;
  case process.version.startsWith("v16."): nodeRuntime = "nodejs16"; break;
  case process.version.startsWith("v20."): nodeRuntime = "nodejs20"; break;
}

// load the cloudant package
if (process.version.startsWith('v16.') || process.version.startsWith('v20.')) {
  console.log("------------------------- require @ibm-cloud/cloudant ----------------------");
  var { CloudantV1 } = require('@ibm-cloud/cloudant');
} else {
  var Cloudant = require("@cloudant/cloudant")
}

// delete database
async function deleteDatabase(client,databaseName) {
  try {
    console.log("Deleting possible existing database: "+databaseName);
    const response= await client.deleteDatabase({db: databaseName});
    console.log("Returned from deleteDatabase response: %j",response);
  } catch (err) {
    if (err.status = 404) {
        // Database not found, we tolerate this for the delete.
        console.log("Database not found, ignored during deleteDatabase.");
    } else {
        // Other errors, progagte this to caller.
        throw new Error('Delete database failed!', { cause: err });
    };
  }
  return true;
}

// create database
async function createDatabase(client,databaseName) {
  try {
    console.log("Creating database: "+databaseName);
    const response= await client.putDatabase({ db: databaseName });
    console.log("Returned from putDatabase")
    if (response.result.ok) {
      console.log(`"${databaseName}" database created."`);
    } else {
      throw new Error('Error for client.putDatabase, response.result.ok=true expected!', {cause: response });
    }
  } catch (err) {
    console.log("Error for client.putDatabase: %j",err);
    throw new Error('Error for client.putDatabase!', { cause: err });
  }
  return true;
}

// post a document into the database
async function postDocument(client,databaseName,doc) {
  try {
    console.log("writing document to database: "+databaseName);
    const response= await client.postDocument({db: databaseName, document: doc})
    console.log("Returned from postDocument")
    if (response.result.ok) {
      console.log(`"${databaseName}" document written."`);
    } else {
      throw new Error('Error for client.postDocument, response.result.ok=true expected!', {cause: response });
    }
  } catch (err) {
    console.log("Error for client.postDocument: %j",err);
    throw new Error('Error for client.putDatabase!', { cause: err });
  }
  return true;
}

// get a document from database
async function getDocument(client,databaseName,id) {
  var document={};
  try {
    console.log("Get document from database: "+databaseName);
    const response= await client.getDocument({db: databaseName, docId: id})
    console.log("Returned from getDocument, response: %j",response)
    if (response.statusText='OK') {
      console.log(`"${databaseName}" document "${id}" successfully read."`);
      document=response.result;
    } else {
      throw new Error('Error for client.getDocument, response.statusText=OK expected!', {cause: response });
    }
  } catch (err) {
    console.log("Error for client.getDocument: %j",err);
    throw new Error('Error for client.getDocument!', { cause: err });
  }
  return document;
}

// main action
async function main(args) {
  var username = args.username;
  var password = args.password;
  var url = args.url;
  var dbName = `test_cloud_functions_nodejs_${nodeRuntime}_ibm_runtime`

  console.log("runtime: "+nodeRuntime)
  console.log("database name: "+dbName)
  console.log("username: "+username)

  if (process.version.startsWith('v16.') || process.version.startsWith('v20.')) {
    process.env['CLOUDANT_AUTH_TYPE'] = 'BASIC'
    process.env['CLOUDANT_URL'] = url
    process.env['CLOUDANT_USERNAME'] = username
    process.env['CLOUDANT_PASSWORD'] = password

    // Create a client with `CLOUDANT` default service name
    const client = CloudantV1.newInstance({});

    // Delete a possible existing database from a previous run.
    const delDB= await deleteDatabase(client,dbName);

    // Create a database.
    const createDB= await createDatabase(client,dbName);
    console.log("createDatabase returned:"+createDB);

    // Post a document into the new database.
    const doc={
      "_id" :  'friend1',
      "firstname": "Suzzy",
      "lastname": "Queue"
    }
    const postDoc= await postDocument(client,dbName,doc);
    console.log("postDocument returned:"+postDoc)

    // Read the document from the database.
    const getDoc= await getDocument(client,dbName,'friend1');
    console.log("getDocument returned: %j",getDoc)

    // const delDB2= await deleteDatabase(client,dbName);

    // Return the document read from the database.
    return getDoc;

  } else {

    //Configuration to use Cloudant
    var config = {account:username, password:password, plugins:['promises']}
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
