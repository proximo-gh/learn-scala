package ru.proximo.algo.sort

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 2/6/13
 * Time: 11:34 PM
 */
object BubbleSort {

  def bubble(a: Array[Int]): Array[Int] = {
    val n = a.length

    for (i <- 0 until n - 1; j <- i + 1 until n)
      if (a(i) > a(j)) {
        val tmp = a(j)
        a(j) = a(i)
        a(i) = tmp
      }
    a
  }

  def main(args: Array[String]) {
    val sorted = bubble(Array(4, 5, 6,1, 2,9,3, 7,8))

    println(sorted.mkString(", "))
  }
}
