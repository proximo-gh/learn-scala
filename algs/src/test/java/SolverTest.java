import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 3/13/13
 * Time: 12:22 AM
 */
public class SolverTest {

    @Test
    public void testSolve0() throws Exception {
        Board board = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});

        Solver solver = new Solver(board);

        assertTrue(solver.isSolvable());
        assertEquals(0, solver.moves());
        assertEquals(board, solver.solution().iterator().next());
    }

    @Test
    public void testSolve1() throws Exception {
        Board board = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 0, 8}});

        Solver solver = new Solver(board);

        assertTrue(solver.isSolvable());
        assertEquals(1, solver.moves());
    }
}
