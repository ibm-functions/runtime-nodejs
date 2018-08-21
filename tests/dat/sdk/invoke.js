const openwhisk = require('openwhisk')
function main(params){
    let ow = openwhisk({
        ignore_certs:params.ignore_certs
    })
    return ow.actions.invoke({
        name: '/whisk.system/utils/date',
        blocking: true
    })
}