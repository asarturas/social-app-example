package com.spikerlabs.socialapp

import org.scalatest.{FlatSpec, Matchers}

class OutputSpec extends FlatSpec with Matchers {

  val consoleOutput = new Output.Console
  implicit val fakeTimer = Timer.Fake(0)

  "console output" should "format single message" in {
    consoleOutput.format(List(AddedMessage(Person("Alice"), "Message"))) should be(
      """Alice - Message (now)"""
    )
  }

  it should "format list of messages" in {
    consoleOutput.format(List(
      AddedMessage(Person("Alice"), "Message"),
      AddedMessage(Person("Bob"), "Another message")
    )) should be(
      """Alice - Message (now)
        |Bob - Another message (now)""".stripMargin
    )
  }

  it should "skip follow commands" in {
    consoleOutput.format(List(
      AddedMessage(Person("Alice"), "Message"),
      Followed(Person("Alice"), Person("Bob")),
      AddedMessage(Person("Bob"), "Another message")
    )) should be(
      """Alice - Message (now)
        |Bob - Another message (now)""".stripMargin
    )
  }

}
