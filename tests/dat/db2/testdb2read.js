var ibmdb = require('ibm_db');
//ibmdb.debug(true);
var connection;

function main({
  __bx_creds: {
    dashDB:{ssldsn}
  }
}) {
  let result, rows;
  try {
    if(!connection){
      connection = ibmdb.openSync(ssldsn);
    }
    rows = connection.querySync(`SELECT HISP_DESC FROM SAMPLES.HISPANIC_ORIGIN WHERE HISP_CODE='03'`);
    return rows[0];
  } catch (err) {
    console.error('problems reading from db',err);
    return { Error: err };
  }
  return result;
};
