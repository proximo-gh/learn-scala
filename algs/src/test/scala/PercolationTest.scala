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

  def printPercolation(p: Percolation, n: Int) {
    for (i <- 1 to n) {
      for (j <- 1 to n) {
        if (p.isFull(i, j))
          print("F ")
        else if (p.isOpen(i, j))
          print("O ")
        else
          print("B ")
      }

      println()
    }
  }

  def af(b: Boolean) {
    Assert assertFalse (b)
  }

  def at(b: Boolean) {
    Assert assertTrue (b)
  }

  @Test
  def testOpen() {
    val p = new Percolation(5)

    open(p, 1, 2)
    open(p, 2, 3)
    open(p, 2, 4)
    open(p, 2, 2)
    open(p, 2, 5)
    open(p, 3, 5)
    open(p, 4, 5)
    open(p, 4, 4)

    Assert.assertFalse(p.percolates)

    open(p, 3, 1)
    open(p, 4, 1)
    open(p, 5, 1)

    Assert.assertFalse(p.percolates)

    open(p, 5, 4)
    open(p, 5, 3)

    Assert.assertTrue(p.percolates)

    af(p.isOpen(1, 3))

    printPercolation(p, 5)
  }

  def open(p: Percolation, i: Int, j: Int) {
    p.open(i, j)
    at(p.isOpen(i, j))
  }
}
