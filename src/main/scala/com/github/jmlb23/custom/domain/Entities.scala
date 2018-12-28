package com.github.jmlb23.custom.domain

import argonaut.{Argonaut, CodecJson}

case class Event (
                   event_name: String,
                   event_id: String,
                   time: Int,
                   event_url: String
                 )

case class Group (
                   group_topics: List[GroupTopics],
                   group_city: String,
                   group_country: String,
                   group_id: Int,
                   group_name: String,
                   group_lon: Double,
                   group_urlname: String,
                   group_state: String,
                   group_lat: Double
                 )

case class GroupTopics (
                         urlkey: String,
                         topic_name: String
                       )

case class Member (
                    member_id: Int,
                    photo: String,
                    member_name: String
                  )

case class MeetupResponse (
                           venue: Venue,
                           visibility: String,
                           response: String,
                           guests: Int,
                           member: Member,
                           rsvp_id: Int,
                           mtime: Int,
                           event: Event,
                           group: Group
                         )

case class Venue (
                   venue_name: String,
                   lon: Double,
                   lat: Double,
                   venue_id: Int
                 )

object Codecs{
  implicit val codecVenue: CodecJson[Venue] = Argonaut.casecodec4(Venue.apply, Venue.unapply)("venue_name", "lon", "lat", "venue_id")
  implicit val codecMember: CodecJson[Member] = Argonaut.casecodec3(Member.apply, Member.unapply)("member_id", "photo", "member_name")
  implicit val codefGroupTopics: CodecJson[GroupTopics] = Argonaut.casecodec2(GroupTopics.apply, GroupTopics.unapply)("urlkey", "topic_name")
  implicit val codefGroup: CodecJson[Group] = Argonaut.casecodec9(Group.apply, Group.unapply)("group_topics", "group_city", "group_country", "group_id", "group_name", "group_lon", "group_urlname", "group_state", "group_lat")
  implicit val codefEvent: CodecJson[Event] = Argonaut.casecodec4(Event.apply, Event.unapply)("event_name", "event_id", "time", "event_url")
  implicit val codec: CodecJson[MeetupResponse] = Argonaut.casecodec9(MeetupResponse.apply, MeetupResponse.unapply)("venue", "visibility", "response", "guests", "member", "rsvp_id", "mtime", "event", "group")

}
