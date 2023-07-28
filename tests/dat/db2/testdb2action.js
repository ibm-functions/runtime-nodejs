var ibmdb = require('ibm_db');
//util.promisify is SPECIFIC to nodejs8

//ibmdb.debug(true);

function main(args){

  if (process.version.startsWith('v16.') || process.version.startsWith('v20.')) {
    return ibmdb.open(`DATABASE=TEST;HOSTNAME=${args.hostname};UID=db2inst1;PWD=db2inst1-pwd;PORT=50000;PROTOCOL=TCPIP`).then((conn) => {
      connection = conn;
      return connection.query("INSERT INTO TESTTABLE (NAME, AGE, LOCATION) VALUES ('Angela', 27, 'Texas')");
    })
    .then(function(data){
      return connection.query("SELECT * FROM TESTTABLE WHERE name='Angela'");
    })
    .then(function(data){
      if(data[0].NAME != "Angela" || data[0].AGE != 27 || data[0].LOCATION != "Texas"){
        throw "Either NAME, AGE, OR LOCATION failed to match expected values";
      }
      return connection.query("DELETE FROM TESTTABLE WHERE name='Angela'");
    })
    .then(function(data){
      return connection.close();
    })
    .then(function(){
      return {
        message: "Tested db2 create, select, and delete of a table row."
      }
    })
    .catch(function(err){
      return {error: err}
      if(connection){connection.close();}
    });
  } else {
    const promisify = require('util').promisify;
    var p_open = promisify(ibmdb.open);
    return p_open(`DATABASE=TEST;HOSTNAME=${args.hostname};UID=db2inst1;PWD=db2inst1-pwd;PORT=50000;PROTOCOL=TCPIP`)
      .then((conn) => {
        connection = conn;
        return connection.query("INSERT INTO TESTTABLE (NAME, AGE, LOCATION) VALUES ('Angela', 27, 'Texas')");
      })
      .then(function(data){
        return connection.query("SELECT * FROM TESTTABLE WHERE name='Angela'");
      })
      .then(function(data){
        if(data[0].NAME != "Angela" || data[0].AGE != 27 || data[0].LOCATION != "Texas"){
          throw "Either NAME, AGE, OR LOCATION failed to match expected values";
        }
        return connection.query("DELETE FROM TESTTABLE WHERE name='Angela'");
      })
      .then(function(data){
        return connection.close();
      })
      .then(function(){
        return {
          message: "Tested db2 create, select, and delete of a table row."
        }
      })
      .catch(function(err){
        return {error: err}
        if(connection){connection.close();}
      });
  }
};
