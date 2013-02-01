package ru.proximo.algo.sort

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 1/31/13
 * Time: 11:50 PM
 */
object MergeSort {
  def sort(input: Array[Int]) : Array[Int] = {

    def checkAndSwap(from: Int, to: Int) {
      if (input(from) > input(to)) {
        val old = input(from)
        input(from) = input(to)
        input(to) = old
      }
    }

    def merge(from : Int, to : Int) {
      var i = from
      var j = to / 2 + 1

      for (k <- from until to) {

      }
    }

    def sortPart(from : Int, to : Int) {
      (to - from) match {
        case 1 => checkAndSwap(from, to)
        case 0 =>
        case _ => {
          sortPart(from, to / 2)
          sortPart(to / 2 + 1, to)

          merge(from, to)
        }
      }
    }

    input
  }
}
