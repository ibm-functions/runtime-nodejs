
var LanguageTranslatorV3 = require('watson-developer-cloud/language-translator/v3');

/*
Args in the form of:
  args.url;
  args.username;
  args.password;
*/
function main(args){
  var language_translator = new LanguageTranslatorV3(args);
  var params = {
    text: 'hello',
    source: 'en',
    target: 'es'
  };

  var promise = {};
  if(process.version.startsWith('v8.')){
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
  return promise;

}

