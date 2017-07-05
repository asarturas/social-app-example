package com.spikerlabs.socialapp

import org.scalatest.{FlatSpec, Matchers}

class EventsSpec extends FlatSpec with Matchers {

  it should "use implicit timer to determine the time of message" in {
    implicit val fakeTimer = Timer.Fake(31000)

    val message = AddedMessage(Person("Arturas"), "Something")
    message.time should be(Time(31000, fakeTimer))

    val following = Followed(Person("Arturas"), Person("Alice"))
    following.time should be(Time(31000, fakeTimer))
  }

  it should "use explicit timer when provided" in {
    val fakeTimer = Timer.Fake(53000)

    val message = AddedMessage(Person("Arturas"), "Something")(fakeTimer)
    message.time should be(Time(53000, fakeTimer))

    val following = Followed(Person("Arturas"), Person("Alice"))(fakeTimer)
    following.time should be(Time(53000, fakeTimer))
  }

}
