package ru.proximo.schat

import scala.collection.mutable
import collection.JavaConversions._
import java.util.concurrent.ConcurrentHashMap

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 1/18/13
 * Time: 12:50 AM
 */
class Room {

  private val users:mutable.ConcurrentMap[String, User] = new ConcurrentHashMap[String, User]
  private val messages = new mutable.ArrayBuffer[Message]()

  def addUser(user:User) = users += ((user.getName, user))

  def getUsers = users.values

  def addMessage(message:Message) = messages += message

  def getMessages = messages

  def getMessagesForUser(name: String) = messages.filter(_.to == name)
}
