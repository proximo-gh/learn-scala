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

        j -= 1
      })

      i -= 1
    })

    result
  }

  def main(args: Array[String]) {
    val result = iterative(Array.apply(1, 1), Array.apply(1, 1))

    result.foreach(print(_))
    println()

    val intResult: Int = pack(result)

    println("intResult = " + intResult)

    unpack(123)

    unpack(3625654)
  }

  def pack(arr: Array[Int]): Int = {
    var n = 0

    (arr :\ 0)((i: Int, sum: Int) => {
      val ret = sum + (i * math.pow(10, n).toInt)

      n += 1
      ret
    })
  }

  def unpack(num : Int): Array[Int] = {
    var n = num

    var s = List[Int]()

    while (n > 0) {
      s ::= (n % 10)
      n /= 10
    }

    println(s)

    s.toArray
  }
}
