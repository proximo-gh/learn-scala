package ru.proximo.schat

import scala.collection.mutable

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 1/18/13
 * Time: 12:50 AM
 */
class Room {

  private val users:mutable.Map[String, User] = new mutable.HashMap[String, User]()
  private val messages = new mutable.ArrayBuffer[Message]()

  def addUser(user:User) = users += ((user.getName, user))

  def getUsers = users.values

  def addMessage(message:Message) = messages += message

  def getMessages = messages

  def getMessagesForUser(name: String) = messages.filter(_.to == name)
}
