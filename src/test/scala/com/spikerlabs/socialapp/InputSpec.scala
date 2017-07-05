package com.spikerlabs.socialapp

import org.scalatest.{FlatSpec, Matchers}

class InputSpec extends FlatSpec with Matchers {

  val consoleInput = new Input.Console

  "console input" should "parse posting" in {
    consoleInput.parse("Alice -> Message") should be(Some(Post(Person("Alice"), "Message")))
  }

  it should "parse reading" in {
    consoleInput.parse("Alice") should be(Some(Read(Person("Alice"))))
  }

  it should "parse following" in {
    consoleInput.parse("Alice follows Bob") should be(Some(Follow(Person("Alice"), Person("Bob"))))
  }

  it should "parse wall" in {
    consoleInput.parse("Alice wall") should be(Some(Wall(Person("Alice"))))
  }

}
