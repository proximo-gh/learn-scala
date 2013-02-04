package ru.proximo.algo.inversions

import scala.io.Source


/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 2/3/13
 * Time: 7:22 PM
 */
object Inversions {
  def readFIle(): Array[Int] = {
    val lines = Source.fromFile("/home/proximo/Programming/Coursera/Algo/Week1/IntegerArray.txt").getLines()
    lines.map(_.toInt).toArray
  }

  def countInversions(input: Array[Int]): Int = {
    var lrc = 0
    var sc = 0

    def countPart(from: Int, to: Int) {
      println("counting parts (" + from + ", " + to + ")")
      (to - from) match {
        case dif if dif <= 0 =>
        case 1 => checkAndSwap(from, to)
        case _ => {
          val mid = from + (to - from) / 2

          print("l ");
          countPart(from, mid)
          print("r ");
          countPart(mid + 1, to)

          merge(from, to)
        }
      }

      print("count: ");
      printArray(input)
    }

    def merge(from: Int, to: Int) {
      var i = from
      val mid = from + (to - from) / 2
      var j = mid + 1

      println("merging from " + from + " to " + to + ", i = " + i + " j = " + j)

      val helper = new Array[Int](to - from)

      for (k <- 0 until helper.length)
        helper(k) = input(from + k)

      print("helpr: ");
      printArray(input)

      for (k <- from until to) {
        if (i < mid && j < to) {
          if (helper(i - from) <= helper(j - from)) {
            input(k) = helper(i - from)
            i += 1
          }
          else {
            input(k) = helper(j - from)
            j += 1
          }
        }
      }

      while (i < mid) {
        input(i) = helper(i - from)
        i += 1
      }

      while (j < to) {
        input(j) = helper(j - from)
        j += 1
      }

      print("merge: ");
      printArray(input)
    }

    def checkAndSwap(from: Int, to: Int) {
      if (input(from) > input(to)) {
        val old = input(from)
        input(from) = input(to)
        input(to) = old

        lrc += 1
      }
    }

    countPart(0, input.length)

    lrc + sc
  }

  def main(args: Array[String]) {
    val array = readFIle()

    println(array.length + " of elements read")

    println(array(100))

    val input = Array(1, 6, 5, 3, 4, 2)
    printArray(input)

    val invCount = countInversions(input)

    printArray(input)

    println("invCount = " + invCount)
  }

  def printArray(input: Array[Int]) {
    println(input.mkString(", "))
  }
}
