package com.spikerlabs.socialapp

object Main extends App {
  val app = new SocialApp(new Storage.InMemory, new Input.Console, new Output.Console)
  println("Submit an empty string to exit")
  var ok = true
  while (ok) {
    print("> ")
    val in = scala.io.StdIn.readLine()
    ok = in.nonEmpty
    if (ok) {
      val out = app.handle(in)
      if (out != "") println(out)
    }
  }
}
