package com.github.jmlb23

import com.github.jmlb23.custom.client.MeetupClient
import com.github.jmlb23.custom.domain.MeetupResponse
import com.github.jmlb23.custom.serializers.{MeetupResponseDeserializer, MeetupResponseSerializer}

object HelloSpec{
  def main(args: Array[String]): Unit = {
    new MeetupClient().lines().take(1).foreach{x =>
      println(x)
      val bytes = new MeetupResponseSerializer().serialize("",x)
      val entity = new MeetupResponseDeserializer().deserialize("",bytes)
      println(entity)
    }
  }
}
