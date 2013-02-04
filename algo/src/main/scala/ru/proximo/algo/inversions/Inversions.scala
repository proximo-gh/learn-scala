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

  def countInversions(input: Array[Int]):Int = {
    var lrc = 0
    var sc = 0

    def countPart(from : Int, to : Int) {
      println("counting parts (" + from + ", " + to + ")")
      (to - from) match {
        case dif if dif <= 0 =>
        case 1 => checkAndSwap(from, to)
        case _ => {
          val mid = from + (to - from) / 2

          print("l "); countPart(from, mid)
          print("r "); countPart(mid + 1, to)

          merge(from, to)
        }
      }
    }

    def merge(from : Int, to : Int) {
      var i = from
      var j = to / 2 + 1

      for (k <- from until to) {

      }
    }

    def checkAndSwap(from: Int, to: Int) {
      if (input(from) > input(to)) {
        val old = input(from)
        input(from) = input(to)
        input(to) = old

        lrc += 1
      }
    }

    var helper = input.clone()

    countPart(0, input.length)

    lrc + sc
  }

  def main(args: Array[String]) {
    val array = readFIle()

    println(array.length + " of elements read")

    println(array(100))

    val invCount = countInversions(Array(1, 3, 5, 6, 4, 2))

    println("invCount = " + invCount)
  }
}
