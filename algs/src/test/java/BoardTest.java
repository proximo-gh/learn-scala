import com.google.common.collect.Iterables;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 3/11/13
 * Time: 9:51 PM
 */
public class BoardTest {
    @Test
    public void testGoal() throws Exception {
        Board goalBoard = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        assertTrue(goalBoard.isGoal());

        Board failBoard1 = new Board(new int[][]{{1, 3, 2}, {4, 5, 6}, {7, 8, 0}});
        assertFalse(failBoard1.isGoal());

        Board failBoard2 = new Board(new int[][]{{1, 2, 3}, {6, 5, 4}, {7, 8, 0}});
        assertFalse(failBoard2.isGoal());

        Board failBoard3 = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {0, 7, 8}});
        assertFalse(failBoard3.isGoal());
    }

    @Test
    public void testHamming() throws Exception {
        Board board = new Board(new int[][]{{1, 4, 6}, {3, 5, 0}, {7, 8, 2}});
        assertEquals(4, board.hamming());

        board = new Board(new int[][]{{8, 1, 3}, {4, 0, 2}, {7, 6, 5}});
        assertEquals(5, board.hamming());
    }

    @Test
    public void testManhattan() throws Exception {
        Board board = new Board(new int[][]{{1, 4, 6}, {3, 5, 0}, {7, 8, 2}});
        assertEquals(9, board.manhattan());

        board = new Board(new int[][]{{8, 1, 3}, {4, 0, 2}, {7, 6, 5}});
        assertEquals(10, board.manhattan());
    }

    @Test
    public void testEquals() throws Exception {
        assertEquals(
                new Board(new int[][]{{1, 4, 6}, {3, 5, 0}, {7, 8, 2}}),
                new Board(new int[][]{{1, 4, 6}, {3, 5, 0}, {7, 8, 2}}));
        assertFalse(
                new Board(new int[][]{{1, 4, 6}, {3, 5, 0}, {7, 8, 2}}).equals(
                        new Board(new int[][]{{1, 4, 6}, {7, 5, 0}, {3, 8, 2}})));

    }

    @Test
    public void testDimension() throws Exception {
        assertEquals(3, new Board(new int[3][3]).dimension());
    }

    @Test
    public void testNeighbors() throws Exception {
        Board board = new Board(new int[][]{{8, 1, 3}, {4, 2, 0}, {7, 6, 5}});
        Collection<Board> expected = Arrays.asList(
                new Board(new int[][]{{8, 1, 0}, {4, 2, 3}, {7, 6, 5}}),
                new Board(new int[][]{{8, 1, 3}, {4, 2, 5}, {7, 6, 0}}),
                new Board(new int[][]{{8, 1, 3}, {4, 0, 2}, {7, 6, 5}})
        );

        assertNeighbors(expected, board.neighbors());
    }

    @Test
    public void testTwin() throws Exception {
        Board board = new Board(new int[][]{{8, 1, 3}, {4, 2, 0}, {7, 6, 5}});
        Board expected = new Board(new int[][]{{1, 8, 3}, {4, 2, 0}, {7, 6, 5}});

        assertEquals(expected, board.twin());
    }

    private static void assertNeighbors(Collection<Board> expected, Iterable<Board> actual) {
        expected = new LinkedList<Board>(expected);
        assertEquals(expected.size(), Iterables.size(actual));

        for (Board board : actual) {
            if (!expected.contains(board))
                throw new AssertionError("board not found in expected: " + board);
            else
                expected.remove(actual);
        }
    }
}
