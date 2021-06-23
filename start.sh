#!/bin/bash

./mvnw clean package -DskipTests
\cp target/demo-0.0.1-SNAPSHOT.jar src/main/docker

cd src/main/docker || exit
docker-compose down
docker rmi demo:latest
docker-compose up
