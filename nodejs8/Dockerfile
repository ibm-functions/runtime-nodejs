FROM openwhisk/action-nodejs-v8:3e843c0
COPY ./package.json /
RUN apt-get update \
    # Upgrade installed packages to get latest security fixes if the base image does not contain them already.
    && apt-get upgrade -y --no-install-recommends \
    # Cleanup apt data, we do not need them later on.
    && rm -rf /var/lib/apt/lists/* \
    # Start adding/updating npm packages.
    && cd / \
    && npm install --production \
    && npm cache clean --force

COPY iam-client/iam-openwhisk-main.js /node_modules/openwhisk/lib/
RUN sed -i.bak 's/lib\/main.js/lib\/iam-openwhisk-main.js/' /node_modules/openwhisk/package.json
