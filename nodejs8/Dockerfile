FROM openwhisk/action-nodejs-v8:47ec84e
COPY ./package.json /
RUN cd / && npm install --production \
    && npm cache clean --force
COPY iam-client/iam-openwhisk-main.js /node_modules/openwhisk/lib/
RUN sed -i.bak 's/lib\/main.js/lib\/iam-openwhisk-main.js/' /node_modules/openwhisk/package.json
