package ru.proximo.algo.sort

import collection.mutable.ListBuffer

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 1/31/13
 * Time: 11:50 PM
 */
object MergeSort {


  def sort(input: List[Int]) : List[Int] = {

    def merge(left: List[Int], right: List[Int]): List[Int] = {
      var l = left
      var r = right
      var result: List[Int] = Nil

      while(!l.isEmpty && !r.isEmpty) {
        if (l.head <= r.head) {
          result ::= l.head
          l = l.tail
        }
        else {
          result ::= r.head
          r = r.tail
        }
      }

      l.foreach(result ::= _)
      r.foreach(result ::= _)

      result.reverse
    }

    def sortPart(input: List[Int]): List[Int] = {
        input.size match {
          case 0 | 1 => input
          case _ => {
            val (left, right) = input.splitAt(input.size / 2)

            merge(sortPart(left), sortPart(right))
          }
        }
    }

    sortPart(input)
  }

  def main(args: Array[String]) {
    val r = sort(List(4, 2, 5, 1, 6, 7, 9, 8))

    println(r)
  }

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
