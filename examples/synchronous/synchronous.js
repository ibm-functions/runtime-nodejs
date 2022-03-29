// each path results in a synchronous activation
function main(params) {
    if (params.payload == 0) {
        return;
    } else if (params.payload == 1) {
        return {payload: 'Hello, World!'};
    } else if (params.payload == 2) {
        return {error: 'payload must be 0 or 1'};
    }
}