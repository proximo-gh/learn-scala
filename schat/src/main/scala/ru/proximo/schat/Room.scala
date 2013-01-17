package ru.proximo.schat

import collection.immutable.HashSet

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 1/18/13
 * Time: 12:50 AM
 */
class Room {

  val users:Set[User] = new HashSet[User]

  def addUser(user:User) {
    users + user
  }
}
