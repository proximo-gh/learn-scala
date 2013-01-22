package ru.proximo.schat

import java.util.Date

/**
 * @author ${user.name}
 */
object App {
  
  def foo(x : Array[String]) = x.foldLeft("")((a,b) => a + b)
  
  def main(args : Array[String]) {
    val room = new Room

    room addUser(new User("Test1"))
    room.addUser(new User("Test2"))

    println("Users")
    room.getUsers.foreach((user) => println(user.getName))

    println

    println("All messages")
    room.addMessage(new Message("Hello", "Test1", "Test2", new Date()))
    room.addMessage(new Message("Hi", "Test2", "Test1", new Date()))
    room.addMessage(new Message("Hi again", "Test3", "Test2", new Date()))

    val printMessage = (message: Message) => println(message)

    room.getMessages.foreach(printMessage )

    println()

    val userTo = "Test2"
    println("Messages for " + userTo)
    room.getMessagesForUser(userTo).foreach(printMessage )
  }

}
