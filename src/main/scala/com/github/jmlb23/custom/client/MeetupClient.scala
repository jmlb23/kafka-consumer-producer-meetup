package com.github.jmlb23.custom.client

import java.net.URL

import com.github.jmlb23.custom.domain._

import scala.io.Source
import argonaut._
import Argonaut._
import Codecs._

class MeetupClient {

  private val source: Source = Source.fromURL("http://stream.meetup.com/2/rsvps".toUrl())

  def lines() = {
    source.getLines().toStream.view.map(x => x.decodeOption[MeetupResponse]).filter(x => x.isDefined).map(_.get)
  }

  private implicit class StringToUrl(url: String) {
    def toUrl() = new URL(url)
  }

}
