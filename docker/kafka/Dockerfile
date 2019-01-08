FROM java:8
RUN curl http://apache.rediris.es/kafka/2.1.0/kafka_2.12-2.1.0.tgz | tar xz && mv kafka_2.12-2.1.0 /opt && sed -i -e 's/localhost/zoo/g' /opt/kafka_2.12-2.1.0/config/server.properties
EXPOSE 9092
ENTRYPOINT [ "/opt/kafka_2.12-2.1.0/bin/kafka-server-start.sh", "/opt/kafka_2.12-2.1.0/config/server.properties"]
