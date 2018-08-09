const openwhisk = require('openwhisk')
function main(params){
    let ow = openwhisk({
        ignore_certs:params.ignore_certs
    })
    return ow.rules.create({
        name: params.ruleName,
        action: params.actionName,
        trigger: params.triggerName
    })
}