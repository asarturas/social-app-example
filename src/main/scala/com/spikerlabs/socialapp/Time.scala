package com.spikerlabs.socialapp

case class Time(time: Long, timer: Timer) {

  def inHuman: String = {
    val now = timer.getTime(timer).time
    val seconds = (now - time) / 1000
    if (seconds == 0) "now"
    else if (seconds < 60) {
      s"${seconds} ${pluralise(seconds, "second")} ago"
    } else {
      val minutes = seconds / 60
      s"${minutes} ${pluralise(minutes, "minute")} ago"
    }
  }

  private def pluralise(number: Long, unit: String): String =
    if (number % 10 == 1) unit
    else unit + 's'

}
