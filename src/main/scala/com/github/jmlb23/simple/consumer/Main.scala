package com.github.jmlb23.simple.consumer

import java.time.Duration
import java.util
import java.util.Properties

import org.apache.kafka.clients.consumer.KafkaConsumer

object Main {
  def main(args: Array[String]): Unit = {

    val props = new Properties()
    props.put("group.id", "test")
    props.put("bootstrap.servers", "localhost:9092")
    props.put("enable.auto.commit", "true")
    props.put("auto.commit.interval.ms", "1000")
    props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer")
    val consumer = new KafkaConsumer[String,String](props)
    consumer.subscribe(util.Arrays.asList("example"))

    consumer.poll(Duration.ofSeconds(1)).forEach{x => println(s"key: ${x.key()}\nvalue: ${x.value()}")}
    consumer.close()
  }
}
