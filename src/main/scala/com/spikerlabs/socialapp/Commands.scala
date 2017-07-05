package com.spikerlabs.socialapp

sealed trait Command

case class Post(author: Person, content: String) extends Command
case class Read(author: Person) extends Command
case class Follow(follower: Person, follows: Person) extends Command
case class Wall(author: Person) extends Command