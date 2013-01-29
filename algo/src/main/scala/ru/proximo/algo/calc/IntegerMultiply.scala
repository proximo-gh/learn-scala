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

      yArray.foreach((y: Int) => {
        val p = x * y

        if (p >= 10) {
          result(i) = p % 10
          result(i - 1) += 1
        }
      })

      i -= 1
    })

    result
  }
}
