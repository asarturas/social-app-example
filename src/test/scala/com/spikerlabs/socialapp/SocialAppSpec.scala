package com.spikerlabs.socialapp

import org.scalatest.{FlatSpec, Matchers}

class SocialAppSpec extends FlatSpec with Matchers {

  trait TestApp {
    val storage = new Storage.InMemory
    val input = new Input.Direct
    val output = new Output.Direct
    val app = new SocialApp(storage, input, output)

    val alice = Person("Alice")
    val bob = Person("Bob")
  }

  it should "post message" in new TestApp {
    app.handle(Post(alice, "Message"))
  }

  it should "read timeline" in new TestApp {
    app.handle(Post(alice, "Message"))
    app.handle(Read(alice)) should be(storage.timeline(alice))
  }

  it should "record a follower" in new TestApp {
    app.handle(Follow(alice, bob))
    app.handle(Read(alice)) should be(storage.timeline(alice))
  }

  it should "read a wall" in new TestApp {
    app.handle(Post(alice, "Message"))
    app.handle(Post(bob, "Other Message"))
    app.handle(Follow(bob, alice))
    app.handle(Wall(bob)) should be(storage.wall(bob))
  }

}
