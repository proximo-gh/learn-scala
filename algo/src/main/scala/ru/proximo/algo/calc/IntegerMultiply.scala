package ru.proximo.algo.calc

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 1/28/13
 * Time: 11:41 PM
 */
object IntegerMultiply {

  def iterative(xArray: Array[Int], yArray : Array[Int]) : Array[Int] = {

    val result = Array.fill(xArray.length + yArray.length)(0)

    var i = result.length - 1

    xArray.foreach((x: Int) => {
      var j = i

      yArray.foreach((y: Int) => {
        val p = x * y

        if (p >= 10) {
          result(j) += p % 10
          result(j - 1) += p / 10
        }
        else
          result(j) += p

        result.foreach(print(_))
        println()

        j -= 1
      })

      i -= 1
    })

    result
  }

  def main(args: Array[String]) {
    val result = iterative(Array.apply(1, 1), Array.apply(1, 1))

    result.foreach(print(_))
  }
}
