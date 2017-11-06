var AWS = require('ibm-cos-sdk');
const endpoint = 's3-api.us-geo.objectstorage.softlayer.net';
const ibmAuthEndpoint = 'https://iam.ng.bluemix.net/oidc/token';
var params = {
  Bucket: 'ibm-functions-devops-testing',
  Key: 'testdata.txt'
}
var cos;
function main({
  __bx_creds: {
    "cloud-object-storage": { apikey },
    "cloud-object-storage": { resource_instance_id }
  }
}) {
  cos = cos || new AWS.S3({
    endpoint: endpoint,
    ibmAuthEndpoint: ibmAuthEndpoint,
    apiKeyId: apikey,
    serviceInstanceId: resource_instance_id
  });
  return new Promise((resolve, reject) => {
    cos.getObject(params, (err, data) => {
      if (err) {
        console.error("something bad happened", err);
        reject({ Error: err })
      } else {
        resolve({ data: data.Body.toString('utf-8') })
      }
    });
  });
}
