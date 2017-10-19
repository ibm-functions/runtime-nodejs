
var LanguageTranslationV2 = require('watson-developer-cloud/language-translation/v2');

/*
Args in the form of:
  args.url;
  args.username;
  args.password;
*/
function main(args){
  language_translation = new LanguageTranslationV2(args);
  var params = {
    text: 'hello',
    source: 'en',
    target: 'es'
  };

  var promise = new Promise(function (resolve, reject) {
    language_translation.translate(params, function(err, body){
      if(err){
        reject(err);
      }
      resolve(body);
    });

  });
  return promise;

}
