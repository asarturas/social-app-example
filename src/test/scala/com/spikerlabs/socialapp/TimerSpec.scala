package com.spikerlabs.socialapp

import org.scalatest.{FlatSpec, Matchers}

class TimerSpec extends FlatSpec with Matchers {

  "fake timer" should "return time with predefined value" in {
    Timer.Fake(20).getTime().time should be(20)
  }

  "system timer" should "return current system time" in {
    Timer.System().getTime().time should be(System.currentTimeMillis +- 1000)
  }

  "time" should "humanly format current time" in {
    Timer.Fake(0).getTime().inHuman should be("now")
  }

  it should "humanly format time one second ago" in {
    Timer.Fake(0).getTime(Timer.Fake(1000)).inHuman should be("1 second ago")
  }

  it should "humanly format time two seconds ago" in {
    Timer.Fake(0).getTime(Timer.Fake(2000)).inHuman should be("2 seconds ago")
  }

  it should "humanly format time twenty one second ago" in {
    Timer.Fake(0).getTime(Timer.Fake(21000)).inHuman should be("21 second ago")
  }

  it should "humanly format time about 1 minute ago" in {
    Timer.Fake(0).getTime(Timer.Fake(71000)).inHuman should be("1 minute ago")
  }

  it should "humanly format time 5 minutes ago" in {
    Timer.Fake(0).getTime(Timer.Fake(302000)).inHuman should be("5 minutes ago")
  }

}
