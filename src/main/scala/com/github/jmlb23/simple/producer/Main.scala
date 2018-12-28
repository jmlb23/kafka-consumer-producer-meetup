package com.github.jmlb23.simple.producer

import java.util.Properties
import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}

object Main {
  def main(args: Array[String]): Unit = {

    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer")
    props.put("acks", "all")
    val producer = new KafkaProducer[String,String](props)

    args.foreach{
      x =>
        producer.send(new ProducerRecord("example",x.hashCode.toString,x), (metadata: RecordMetadata, exception: Exception) => if (exception == null) throw exception)
    }
    producer.close()

  }
}
