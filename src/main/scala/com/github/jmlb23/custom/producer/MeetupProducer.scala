package com.github.jmlb23.custom.producer

import java.util.Properties

import com.github.jmlb23.custom.client.MeetupClient
import com.github.jmlb23.custom.domain.MeetupResponse
import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}

object MeetupProducer {
  def main(args: Array[String]): Unit = {

    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "com.github.jmlb23.custom.serializers.MeetupResponseSerializer")
    props.put("acks", "all")
    val producer = new KafkaProducer[String, MeetupResponse](props)

    val w = new Thread(() => {
      val x = readLine("end to finish")
      if (x == "end") {
        producer.close()
        System.exit(0)
      }
    })
    w.start()

    new MeetupClient().lines().foreach(x => producer.send(new ProducerRecord[String, MeetupResponse]("example2", 0, System.currentTimeMillis(), x.hashCode().toString, x),new Callback {
      override def onCompletion(metadata: RecordMetadata, exception: Exception): Unit = println(metadata.toString)
    }))
  }
}
