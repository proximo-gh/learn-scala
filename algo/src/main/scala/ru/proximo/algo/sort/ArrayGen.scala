package ru.proximo.algo.sort

import util.Random

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 2/7/13
 * Time: 10:36 PM
 */
trait ArrayGen {
  def generate(n: Int): Array[Int] = {
    Seq.fill(n) {Random.nextInt(n)}.toArray
  }

}
