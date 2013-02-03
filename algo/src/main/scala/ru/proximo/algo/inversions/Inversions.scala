package ru.proximo.algo.inversions


/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 2/3/13
 * Time: 7:22 PM
 */
object Inversions {
  def readFIle():Array[Int] = {
    import scala.io.Source

    val lines = Source.fromFile("/home/proximo/Programming/Coursera/Algo/Week1/IntegerArray.txt").getLines()

    val result = lines.map(_.toInt).toArray

    result
  }

  def main(args: Array[String]) {
    val array = readFIle()

    println(array.length)

    println(array(100))
  }
}
