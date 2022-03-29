function main(args) {
    return new Promise(function(resolve, reject) {
        setTimeout(function() {
            reject({ done: true });
        }, 2000);
        })
}