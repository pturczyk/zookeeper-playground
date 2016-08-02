FROM java:openjdk-8-jre
RUN mkdir /opt/zk-playground
COPY ./target/zookeeper-playground-0.0.1-SNAPSHOT.jar /opt/zk-playground
WORKDIR /opt/zk-playground
EXPOSE 8181
CMD ["java", "-jar", "zookeeper-playground-0.0.1-SNAPSHOT.jar"]
