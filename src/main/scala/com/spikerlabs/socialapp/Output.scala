package com.spikerlabs.socialapp

trait Output {
  def format(events: List[Event]): Any
  def none: Any
}

object Output {

  class Direct extends Output {
    def format(events: List[Event]): List[Event] = events
    def none = List()
  }

  class Console extends Output {
    def format(events: List[Event]): String = events.flatMap(formatOne).mkString("\n")
    def formatOne(event: Event): Option[String] = event match {
      case AddedMessage(Person(name), message) => Some(s"$name - $message (${event.time.inHuman})")
      case _ => None
    }
    def none = ""
  }

}