#!/bin/bash
set -eu

dockerhub_image_prefix="$1"
dockerhub_image_name="$2"
dockerhub_image_tag="$3"
docker_build_path="$4"
dockerhub_image="${dockerhub_image_prefix}/${dockerhub_image_name}:${dockerhub_image_tag}"

docker login -u "${DOCKER_USER}" -p "${DOCKER_PASSWORD}"

echo docker build $docker_build_path --tag ${dockerhub_image}
docker build $docker_build_path --tag ${dockerhub_image}

echo docker push ${dockerhub_image}
docker push ${dockerhub_image}
