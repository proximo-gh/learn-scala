package ru.proximo.algo.sort

import scala.math
import util.Random

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 2/6/13
 * Time: 11:34 PM
 */
object BubbleSort {

  def bubble(a: Array[Int]): Array[Int] = {
    val n = a.length

    for (i <- (n - 1) to 2 by -1; j <- 0 until i)
      if (a(j) > a(j + 1)) {
        val tmp = a(j)
        a(j) = a(j + 1)
        a(j + 1) = tmp
      }
    a
  }

  def generate(n: Int) = {
    Seq.fill(n) {Random.nextInt(n)}.toArray
  }

  def main(args: Array[String]) {
    generateSortPrint(10)
    generateSortPrint(20)
    generateSortPrint(25)
    generateSortPrint(25)
    generateSortPrint(35)
    generateSortPrint(50)
  }

  def generateSortPrint(n: Int) {
    val a = generate(n)
    print("array = ")
    printA(a)

    val s = bubble(a)
    print("sortd = ")
    printA(s)
  }

  def printA(a: Array[Int]) {
    println(a.mkString(", "))
  }
}
