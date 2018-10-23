
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

  var promise = new Promise(function (resolve, reject) {
    language_translator.translate(params, function(err, body){
      if(err){
        reject(err);
      }
      resolve(body);
    });

  });
  return promise;

}
