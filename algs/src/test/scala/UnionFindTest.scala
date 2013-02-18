import org.junit.Test

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 2/17/13
 * Time: 11:35 PM
 */
class UnionFindTest {
  @Test
  def testFirst() {
    val n = 9

    val uf = new QuickFindUF(n + 1)

    //6-0 8-3 6-7 7-5 0-9 4-5
    uf union(6, 0)
    uf union(8, 3)
    uf union(6, 7)
    uf union(7, 5)
    uf union(0, 9)
    uf union(4, 5)

    //9 1 2 3 9 9 9 9 3 9
    for (i <- 0 to n)
      print(" " + uf.find(i))
  }

  @Test
  def testFirst131() {
    val n = 9

    val uf = new QuickFindUF(n + 1)

    //1-9 7-2 1-2 8-9 7-4 0-8
    uf union(1, 9)
    uf union(7, 2)
    uf union(1, 2)
    uf union(8, 9)
    uf union(7, 4)
    uf union(0, 8)

    // 4 4 4 3 4 5 6 4 4 4
    for (i <- 0 to n)
      print(" " + uf.find(i))
  }

  @Test
  def testSecond() {
    val n = 9

    val uf = new WeightedQuickUnionUF(n + 1)

    //4-3 7-4 4-6 9-7 2-0 1-5 0-1 3-0 9-8
    uf union(4, 3)
    uf union(7, 4)
    uf union(4, 6)
    uf union(9, 7)
    uf union(2, 0)
    uf union(1, 5)
    uf union(0, 1)
    uf union(3, 0)
    uf union(9, 8)

    //2 2 4 4 4 1 4 4 4 4
    for (i <- 0 to n)
      print(" " + uf.find(i))
  }

  @Test
  def testSecond131() {
    val n = 9

    val uf = new WeightedQuickUnionUF(n + 1)

    //4-0 3-7 6-8 0-7 9-8 8-5 2-1 5-7 8-1
    uf union(4, 0)
    uf union(3, 7)
    uf union(6, 8)
    uf union(0, 7)
    uf union(9, 8)
    uf union(8, 5)
    uf union(2, 1)
    uf union(5, 7)
    uf union(8, 1)

    //4 2 6 4 6 6 6 3 6 6
    for (i <- 0 to n)
      print(" " + uf.find(i))
  }

  def union(s: String) {

    for (g <- s split (" "); t <- g split ("-")) {

    }
  }
}
