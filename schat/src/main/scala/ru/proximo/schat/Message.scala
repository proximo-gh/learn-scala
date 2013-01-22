package ru.proximo.schat

import java.util.Date

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 1/18/13
 * Time: 12:51 AM
 */
class Message(val text: String, val from: String, val to: String, val date: Date) {
  override def toString: String = "text = '" + text + "' from = '" + from + "' to = '" + to + "' date = " + date
}
