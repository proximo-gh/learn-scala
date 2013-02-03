package ru.proximo.algo.inversions

import scala.io.Source


/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 2/3/13
 * Time: 7:22 PM
 */
object Inversions {
  def readFIle():Array[Int] = {
    val lines = Source.fromFile("/home/proximo/Programming/Coursera/Algo/Week1/IntegerArray.txt").getLines()
    lines.map(_.toInt).toArray
  }

  def main(args: Array[String]) {
    val array = readFIle()

    println(array.length)

    println(array(100))
  }
}
