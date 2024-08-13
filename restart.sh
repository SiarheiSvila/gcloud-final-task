#! /bin/bash

mvn clean install
docker build -t europe-west1-docker.pkg.dev/cloud-x-432119/final-task/final-task:latest .
docker push europe-west1-docker.pkg.dev/cloud-x-432119/final-task/final-task:latest .