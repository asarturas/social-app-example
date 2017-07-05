package com.spikerlabs.socialapp

trait Timer {
  def getTime(timer: Timer): Time
}

object Timer {

  case class Fake(init: Long) extends Timer {
    def getTime(timer: Timer = this): Time = Time(init, timer)
  }

  case class System() extends Timer {
    def getTime(timer: Timer = this): Time = Time(java.lang.System.currentTimeMillis, timer)
  }

  implicit val systemTimer = System()

}