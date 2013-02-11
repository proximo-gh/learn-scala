import Percolation.State
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Test

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 2/11/13
 * Time: 10:58 PM
 */
@RunWith(classOf[JUnit4])
class PercolationTest {

  def printPercolation(p: Percolation) {
    p.getGrid.foreach((row: Array[State]) => {
      row.foreach({
        case State.OPEN => print("O ")
        case State.BLOCKED => print("B ")
        case State.FULL => print("F ")
      })

      println()
    })
  }

  @Test
  def testOpen(){
    val p = new Percolation(5)

    p.open(0, 1)
    p.open(1, 2)
    p.open(1, 3)
    p.open(1, 1)

    printPercolation(p)
  }
}
