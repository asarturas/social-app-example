package com.spikerlabs.socialapp

trait Storage {
  def add(event: Event): Unit
  def all: List[Event]
  def timeline(person: Person*): List[Event]
  def wall(person: Person*): List[Event]
}

object Storage {

  class InMemory extends Storage {

    private var storage: List[Event] = List.empty[Event]

    def add(event: Event): Unit = storage = event :: storage
    def all: List[Event] = storage
    def timeline(people: Person*): List[Event] = storage.filter(record => people.exists(record.belongsTo))
    def wall(people: Person*): List[Event] = {
      val follows: List[Person] = storage.collect {
        case Followed(follower, following) if people.contains(follower) => following
      }
      timeline(people ++ follows :_*)
    }
  }

}