package com.spikerlabs.socialapp

abstract class Event(val explicitTimer: Timer) {
  val time: Time = explicitTimer.getTime(explicitTimer)
  def belongsTo(person: Person): Boolean
}

case class AddedMessage(author: Person, content: String)(implicit val timer: Timer) extends Event(timer) {
  def belongsTo(person: Person): Boolean = author == person
}

case class Followed(follower: Person, following: Person)(implicit val timer: Timer) extends Event(timer) {
  def belongsTo(person: Person): Boolean = follower == person
}