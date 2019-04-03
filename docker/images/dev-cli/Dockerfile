FROM maven:latest

RUN apt-get update && apt-get --assume-yes install openjdk-8-jdk-headless && apt-get install --assume-yes openjdk-8-jdk
WORKDIR /usr/src/skyapi
COPY ./lib/skyapi .
RUN mvn clean install 
