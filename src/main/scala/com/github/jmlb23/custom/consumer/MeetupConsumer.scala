package com.github.jmlb23.custom.consumer

import java.time.Duration
import java.util
import java.util.Properties

import com.github.jmlb23.custom.domain.MeetupResponse
import org.apache.kafka.clients.consumer.KafkaConsumer

import scala.annotation.tailrec

object MeetupConsumer {
  @tailrec
  def loop(closure: () => Unit): Unit ={
    closure()
    loop(closure)
  }

  def main(args: Array[String]): Unit = {
    val props = new Properties()
    props.put("group.id", "test")
    props.put("bootstrap.servers", "localhost:9092")
    props.put("enable.auto.commit", "true")
    props.put("auto.commit.interval.ms", "1000")
    props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer","com.github.jmlb23.custom.serializers.MeetupResponseDeserializer")
    val consumer = new KafkaConsumer[String,MeetupResponse](props)
    consumer.subscribe(util.Arrays.asList("example2"))
    loop({ () =>
      consumer.poll(Duration.ofSeconds(1)).forEach { x => println(s"key: ${x.key()}\nvalue: ${x.value()}") }
    })
    consumer.close()


  }
}
