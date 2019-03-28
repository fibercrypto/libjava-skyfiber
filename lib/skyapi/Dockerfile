FROM maven:3-jdk-8

#RUN apt-get update && apt-get --assume-yes install openjdk-8-jdk-headless 
#RUN apt-get install --assume-yes openjdk-8-jdk
COPY . /usr/src/skyapi
WORKDIR /usr/src/skyapi

RUN mvn clean install -X 
CMD []
