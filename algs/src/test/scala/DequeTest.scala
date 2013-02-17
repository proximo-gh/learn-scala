import org.junit.{Assert, Test}
import collection.JavaConversions._

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 2/17/13
 * Time: 10:11 PM
 */
class DequeTest {
  @Test
  def testDeque() {
    val d = new Deque[Int]

    Assert assertTrue (d.isEmpty)

    d.addLast(7)

    Assert assertFalse (d.isEmpty)

    Assert assertEquals(1, d size())

    Assert assertEquals(7, d.removeFirst())

    Assert assertTrue (d.isEmpty)

    d addFirst (8)

    d addLast (10)

    d addFirst (23)

    d addLast (35)

    var l: List[Int] = Nil
    for (x <- d) {
      l ::= x
    }

    Assert assertEquals(List(35, 10, 8, 23), l)
  }
}
