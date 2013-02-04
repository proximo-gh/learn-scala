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
      pln("counting parts (" + from + ", " + to + ")")
      (to - from) match {
        case dif if dif <= 0 =>
        case 1 => checkAndSwap(from, to)
        case _ => {
          val mid = from + (to - from) / 2

          pl("l ");
          countPart(from, mid)
          pl("r ");
          countPart(mid + 1, to)

          merge(from, to)
        }
      }

      pln("count: ");
      printArray(input)
    }

    def merge(from: Int, to: Int) {
      var i:Int = from
      val mid:Int = from + (to - from) / 2
      var j:Int = mid + 1

      pln("merging from " + from + " to " + to + ", i = " + i + " j = " + j)

      val helper = new Array[Int](to - from + 1)

      for (k <- (0 until helper.length))
        helper(k) = input(from + k)

      pl("helpr: ");
      printArray(input)

      var k:Int = from

      while (i <= mid && j <= to) {
        val left = helper(i - from)
        val right = helper(j - from)

        if (left <= right) {
          input(k) = left
          i += 1
        }
        else {
          input(k) = right
          j += 1
          sc += mid - i + 1

/*
          printf("moving %d, sc by %d", right, mid - i + 1)
          println()
*/
        }

        k += 1
      }

      while (i <= mid) {
        input(k) = helper(i - from)
        i += 1
        k += 1
      }

      while (j <= to) {
        input(j) = helper(j - from)
        j += 1
        k += 1
      }

      pl("merge: ");
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

    countPart(0, input.length - 1)

    lrc + sc
  }

  def main(args: Array[String]) {
    val array = readFIle()

    println(array.length + " of elements read")

    pln(array(100))

    val input = Array(1, 6, 5, 3, 4, 2, 7, 8)
    printArray(input)

    val invCount = countInversions(input)

    printArray(input)

    println("invCount = " + invCount)
  }

  val log = false

  def nop(a : Any){}

  def pln: (Any) => Unit = {
    if (log)
      println
    else
      nop
  }

  def pl: (Any) => Unit = {
    if (log)
      print
    else
      nop
  }

  def printArray(input: Array[Int]) {
    if (log)
      pln(input.mkString(", "))
  }
}
