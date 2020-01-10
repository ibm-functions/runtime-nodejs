var ibmdb = require('ibm_db');
//ibmdb.debug(true);
var connection;

function main({
  __bx_creds: {
    dashDB:{ssldsn}
  }
}) {
  let result, rows;

  // For the free db2 database plan, the schema name
  // needs to be the same as the uid of the ssldsn.
  // Therefore we split the ssldsn at the ';' and read the
  // individual key value pairs into a map.
  // From the map we then can easily access the UID.
  var ssldsnMap = {};
  ssldsn.split(';').forEach(function(x){
    var arr = x.split('=');
    arr[1] && (ssldsnMap[arr[0]] = arr[1]);
  });

  console.log("UID="+ssldsnMap["UID"]);

  try {
    if(!connection){
      connection = ibmdb.openSync(ssldsn);
    }
    rows = connection.querySync(`SELECT HISP_DESC FROM ${ssldsnMap["UID"]}.HISPANIC_ORIGIN WHERE HISP_CODE='03'`);
    return rows[0];
  } catch (err) {
    console.error('problems reading from db',err);
    return { Error: err };
  }
  return result;
};
