package com.spikerlabs.socialapp

import org.scalatest.{FlatSpec, Matchers}

class StorageSpec extends FlatSpec with Matchers {

  trait TestStorage {
    val storage = new Storage.InMemory

    val alice = Person("Alice")
    val aliceMessage =AddedMessage(alice, "I love the weather today")

    val bob = Person("Bob")
    val bobMessage1 = AddedMessage(bob, "Damn! We lost!")
    val bobMessage2 = AddedMessage(bob, "Good dame thought.")
  }

  it should "store new message" in new TestStorage {
    storage.add(aliceMessage)
    storage.all should be(List(aliceMessage))
  }

  it should "return personal timeline from storage" in new TestStorage {
    storage.add(aliceMessage)
    storage.add(bobMessage1)
    storage.add(bobMessage2)
    storage.timeline(alice) should be(List(aliceMessage))
    storage.timeline(bob) should be(List(bobMessage2, bobMessage1))
  }

  it should "return timeline in reverse order" in new TestStorage {
    storage.add(bobMessage1)
    storage.add(bobMessage2)
    storage.timeline(bob) should be(List(bobMessage2, bobMessage1))
  }

  it should "return combined timeline from storage" in new TestStorage {
    storage.add(aliceMessage)
    storage.add(bobMessage1)
    storage.timeline(alice, bob) should be(List(bobMessage1, aliceMessage))
  }

  it should "return a wall of person, which is merged timeline of person and people person is following" in new TestStorage {
    storage.add(aliceMessage)
    storage.add(bobMessage1)
    storage.add(Followed(alice, bob))
    storage.wall(alice) should be(List(Followed(alice, bob), bobMessage1, aliceMessage))
    storage.wall(bob) should be(storage.timeline(bob))
  }

}
