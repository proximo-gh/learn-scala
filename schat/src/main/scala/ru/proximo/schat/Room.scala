package ru.proximo.schat

import scala.collection.mutable
import collection.JavaConversions._
import java.util.concurrent.ConcurrentHashMap
import math.Ordering
import java.util.Date

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

  def removeUser(name: String) = users remove name

  def getUsers = users.values

  def addMessage(message:Message) = if (users contains message.to) messages += message

  def getMessages = messages

  def getMessagesForUser(name: String): Seq[Message] = {
    if (users contains name)
      messages.filter(_.to == name).sortBy(_.date)
    else
      List()
  }
}
