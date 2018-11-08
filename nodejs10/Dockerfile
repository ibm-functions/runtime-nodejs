FROM openwhisk/action-nodejs-v10:e892cd8
COPY ./package.json /
RUN cd / && npm install --no-package-lock --production \
    && npm cache clean --force
COPY iam-client/iam-openwhisk-main.js /node_modules/openwhisk/lib/
RUN sed -i.bak 's/lib\/main.js/lib\/iam-openwhisk-main.js/' /node_modules/openwhisk/package.json
