package com.github.jmlb23.custom.serializers

import java.nio.charset.Charset
import java.util

import com.github.jmlb23.custom.domain.MeetupResponse
import org.apache.kafka.common.serialization.{Deserializer, Serializer}
import argonaut._
import Argonaut._
import com.github.jmlb23.custom.domain.Codecs._

class MeetupResponseSerializer extends Serializer[MeetupResponse]{
  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {}

  override def serialize(topic: String, data: MeetupResponse): Array[Byte] = data.asJson.toString().getBytes(Charset.defaultCharset())

  override def close(): Unit = {}
}

class MeetupResponseDeserializer extends Deserializer[MeetupResponse]{

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {}

  override def close(): Unit = {}

  override def deserialize(topic: String, data: Array[Byte]): MeetupResponse = new String(data).decodeOption[MeetupResponse].get
}
