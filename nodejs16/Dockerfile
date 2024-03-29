
FROM openwhisk/action-nodejs-v16:28ac4c0

COPY ./package.json /

#ENV NODE_ENV=production
ARG NODE_ENV=production

RUN apt-get update  \
    # Upgrade installed packages to get latest security fixes if the base image does not contain them already.
    && apt-get upgrade -y --no-install-recommends \
    # Cleanup apt data, we do not need them later on.
    && rm -rf /var/lib/apt/lists/* \
    # We do not have mysql-server installed but mysql-common contains config files (/etc/mysql/my.cnf) for it.
    # We need to add some dummy entries to /etc/mysql/my.cnf to sattisfy vulnerability checking of it.
    && echo "\n[mysqld]\nssl-ca=/tmp/ca.pem\nssl-cert=/tmp/server-cert.pem\nssl-key=/tmp/server-key.pem\n" >> /etc/mysql/my.cnf \
    # Start adding/updating npm packages.
    && cd / \
    && npm install --omit=dev \
    # Check if the base runtime packages required by /nodejsAction/package.json are still available.
    # In case this step fails, the package versions required by the /nodejsAction/package.json
    # do not match the versions in /package.json. The /package.json versions need to contain the same
    # versions as in /nodejsAction/package.json, otherwise the runtime can fail. Adjust the values in
    # /packages.json to the values in /nodejsAction/package.json.
    # To do the check, we try to install /nodejsAction/package.json with the --dry-run option (only check
    # what would happen, no real install). When the install tries to GET (install) packages, we know,
    # something is missing and that should not be the case!
    && sed -i 's/devDependencies/ignoredDevDependencies/' /nodejsAction/package.json \
    && echo "\nCheck if the packages required by the parent image provided '/nodejsAction/package.json' are installed...\n" \
    && npm install ./nodejsAction/ --dry-run -verbose 2>&1 | ( ! grep "npm http fetch GET") \
    && echo "Done, the packages required by '/nodejsAction/package.json' are installed.\n" \
    # Do some cleanup of not used npm install artifacts.
    && npm cache clean --force \
    && rm -rf /root/.cache/node-gyp \
    # Replace default openwhisk main with an iam enabled version.
    && sed -i.bak 's/lib\/main.js/lib\/iam-openwhisk-main.js/' /node_modules/openwhisk/package.json \
    # Show current nodejs version.
    && echo "node version: $(node --version)" \
    # Show current npm version.
    && echo "npm version: $(npm --version)" \
    # Show full list of installed modules.
    && echo "npm list:" && echo "$(cd / && npm list)"

ENV OW_ENABLE_INIT_INSTALL=false

COPY iam-client/iam-openwhisk-main.js /node_modules/openwhisk/lib/
