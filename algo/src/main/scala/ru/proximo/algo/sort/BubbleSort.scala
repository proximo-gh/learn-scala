package ru.proximo.algo.sort

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 2/6/13
 * Time: 11:34 PM
 */
object BubbleSort extends Sort with ArrayGen {

  def someOtherSort(a: Array[Int]): Array[Int] = {
    val n = a.length

    for (i <- 0 until n - 1; j <- i + 1 until n)
      if (a(i) > a(j)) {
        val tmp = a(j)
        a(j) = a(i)
        a(i) = tmp
      }
    a
  }


  override def sort(a: Array[Int]): Array[Int] = {
    val n = a.length

    for (i <- (n - 1) to 2 by -1; j <- 0 until i)
      if (a(j) > a(j + 1)) {
        val tmp = a(j)
        a(j) = a(j + 1)
        a(j + 1) = tmp
      }
    a
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

    val s = sort(a)
    print("sortd = ")
    printA(s)
  }

  def printA(a: Array[Int]) {
    println(a.mkString(", "))
  }
}
