package com.spikerlabs.socialapp

trait Input {
  def parse(input: Any): Option[Command]
}

object Input {

  class Direct extends Input {
    def parse(input: Any): Option[Command] = input match {
      case in: Command => Some(in)
      case _ => None
    }
  }

  class Console extends Input {
    private val PostCommand = "(.*) -> (.*)".r
    private val FollowCommand = "(.*) follows (.*)".r
    private val WallCommand = "(.*) wall".r
    private val ReadCommand = "(.*)".r
    def parse(input: Any): Option[Command] = {
      input.asInstanceOf[String] match {
        case PostCommand(name, message) => Some(Post(Person(name), message))
        case FollowCommand(follower, follows) => Some(Follow(Person(follower), Person(follows)))
        case WallCommand(name) => Some(Wall(Person(name)))
        case ReadCommand(name) => Some(Read(Person(name)))
        case _ => None
      }
    }
  }

}