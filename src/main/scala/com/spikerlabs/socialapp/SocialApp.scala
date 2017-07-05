package com.spikerlabs.socialapp

class SocialApp(storage: Storage, input: Input, output: Output) {

  def handle(in: Any): Any = {
    val command = input.parse(in)
    if (command.nonEmpty) handleCommand(command.get)
  }

  private def handleCommand(command: Command) = {
    import Timer.systemTimer
    val out = command match {
      case Post(person, message) => storage.add(AddedMessage(person, message))
      case Read(person) => storage.timeline(person)
      case Follow(follower, follow) => storage.add(Followed(follower, follow))
      case Wall(person) => storage.wall(person)
    }
    out match {
      case list: List[Event] => output.format(list)
      case _ => output.none
    }
  }

}
