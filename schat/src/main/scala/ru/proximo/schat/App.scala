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

    room.getUsers.foreach((user) => println(user.getName))

    room.addMessage(new Message("Hello", "Test1", "Test2", new Date()))
    room.addMessage(new Message("Hi", "Test2", "Test1", new Date()))

    room.getMessages.foreach(println _)


  }

}
