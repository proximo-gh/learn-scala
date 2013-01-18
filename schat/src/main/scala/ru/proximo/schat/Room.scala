package ru.proximo.schat

import scala.collection.mutable

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 1/18/13
 * Time: 12:50 AM
 */
class Room {

  private val users:mutable.Set[User] = new mutable.HashSet[User]()

  def addUser(user:User) {
    users += user
  }

  def getUsers = users
}
