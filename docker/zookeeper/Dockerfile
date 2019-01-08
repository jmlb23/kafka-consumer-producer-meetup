FROM java:8
#RUN curl http://apache.rediris.es/kafka/2.1.0/kafka_2.12-2.1.0.tgz | tar xz && mv kafka_2.12-2.1.0 /opt
RUN curl http://apache.rediris.es/zookeeper/zookeeper-3.4.13/zookeeper-3.4.13.tar.gz | tar xz && mv zookeeper-3.4.13 /opt
EXPOSE 2181
ENTRYPOINT [ "/opt/zookeeper-3.4.13/bin/zkServer.sh", "start-foreground", "/opt/zookeeper-3.4.13/conf/zoo_sample.cfg"]

