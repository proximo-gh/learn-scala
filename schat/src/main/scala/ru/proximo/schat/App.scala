package ru.proximo.schat

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
  }

}
