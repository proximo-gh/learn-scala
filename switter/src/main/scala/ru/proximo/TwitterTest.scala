package ru.proximo

import twitter4j.{Twitter, TwitterFactory}
import twitter4j.conf.{ConfigurationBuilder, PropertyConfiguration}

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 1/17/13
 * Time: 1:19 AM
 */
object TwitterTest extends App {

  val cb = new ConfigurationBuilder

  cb setUser "vnlobanovs"
  cb setPassword "twitter.com"

  val twitter: Twitter = new TwitterFactory(cb.build).getInstance

  println (twitter getScreenName)

  val timeLine = twitter.getUserTimeline

  val text = timeLine.get(0).getText

  println(text)
}
