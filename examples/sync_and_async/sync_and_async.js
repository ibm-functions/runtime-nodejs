function main(params) {
    if (params.payload) {
        // asynchronous activation
        return new Promise(function(resolve, reject) {
          setTimeout(function() {
            resolve({ done: true });
          }, 2000);
        })
        }  else {
        // synchronous activation
        return {done: true};
        }
}