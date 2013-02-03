package ru.proximo.algo.inversions

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 2/3/13
 * Time: 7:22 PM
 */
object Inversions {
  def readFIle(){
    import scala.io.Source
    for(line <- Source.fromFile("myfile.txt").getLines())
      println(line)
  }
}
