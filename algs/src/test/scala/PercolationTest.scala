import Percolation.State
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.{Assert, Test}

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

  def af(b: Boolean) {
    Assert assertFalse (b)
  }
  
  def at(b: Boolean) {
    Assert assertTrue (b)
  }
  
  @Test
  def testOpen(){
    val p = new Percolation(5)

    open(p, 0, 1)
    open(p, 1, 2)
    open(p, 1, 3)
    open(p, 1, 1)
    open(p, 1, 4)
    open(p, 2, 4)
    open(p, 3, 4)
    open(p, 3, 3)

    Assert.assertFalse(p.percolates)

    open(p, 2, 0)
    open(p, 3, 0)
    open(p, 4, 0)

    Assert.assertFalse(p.percolates)

    open(p, 4, 3)
    open(p, 4, 2)

    Assert.assertTrue(p.percolates)

    af(p.isOpen(0, 2))

    printPercolation(p)
  }

  def open(p: Percolation, i: Int, j: Int) {
    p.open(i, j)
    at(p.isOpen(i, j))
  }
}
