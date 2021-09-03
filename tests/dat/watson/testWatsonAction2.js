// get the runtime version we are running in
const runtime_version=process.version;

// For the nodejs12 runtime (and later) we use the ibm-watson package. On the earlier
// runtime versions we use the watson-developer-cloud package.
var LanguageTranslatorV3 = runtime_version.startsWith('v10.') ? require("watson-developer-cloud/language-translator/v3")
                                                              : require("ibm-watson/language-translator/v3")

/*
Args in the form of:
  args.url;
  args.username;
  args.password;
*/
function main(args){

  console.log("LanguageTranslatorV3 Test running on %s",runtime_version);

  // setup options for a language translator service
  var options={};
  if (!runtime_version.startsWith('v10.')) {
     // the watson sdk 5+ in the nodejs12 runtime (and later) requires authenticators
     const { BasicAuthenticator } = require('ibm-watson/auth');
     options= {
       authenticator: new BasicAuthenticator({ username: args.username, password: args.password }),
       url: args.url,
       version: args.version
     };
  } else {
     // for watson sdk below 5.0 we just pass the arguments
     options= args;
  }

  // Create a language translator service
  var language_translator = new LanguageTranslatorV3(options);

  // setup translation parameters
  var params = {
    text: 'hello',
    source: 'en',
    target: 'es'
  };

  // invoke the service to do the tranlation
  var promise = {};
  if(runtime_version.startsWith('v8.')){
    // watson sdk 3.x uses callback functions
    promise = new Promise(function (resolve, reject) {
      language_translator.translate(params, function(err, body){
        if(err){
          reject(err);
        }
        resolve(body);
      });
    });
  } else {
    // nodejs 10+ uses the watson sdk 4.x that supports promises
    promise = language_translator.translate(params)
  }

  // With watson sdk 5+ always the detailed response is returned.
  // In order not to make the test case SDK version dependent, we
  // return res.result from the detailed response when it is available.
  // Otherwise for the earlier versions we return the whole result (res).
  return promise
	.then((res) => {
           return (res.result) ? res.result : res;
         });

}
