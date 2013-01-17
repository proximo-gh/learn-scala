import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import ru.proximo.schat.Room

@RunWith(classOf[JUnitRunner])
class RoomTest extends FunSuite with ShouldMatchers {

  test("Add one user") {
    val room = new Room
  }
}
