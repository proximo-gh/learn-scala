import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 3/11/13
 * Time: 9:51 PM
 */
public class BoardTest {
    @Test
    public void testNumToPosition() throws Exception {
        Board board = new Board(new int[3][3]);

        assertArrayEquals(new int[]{0, 0}, board.numToPosition(1));
        assertArrayEquals(new int[]{0, 1}, board.numToPosition(2));
        assertArrayEquals(new int[]{0, 2}, board.numToPosition(3));
        assertArrayEquals(new int[]{1, 0}, board.numToPosition(4));
        assertArrayEquals(new int[]{1, 1}, board.numToPosition(5));
        assertArrayEquals(new int[]{1, 2}, board.numToPosition(6));
        assertArrayEquals(new int[]{2, 0}, board.numToPosition(7));
        assertArrayEquals(new int[]{2, 1}, board.numToPosition(8));
        assertArrayEquals(new int[]{2, 2}, board.numToPosition(0));
    }

    @Test
    public void testPositionToNum() throws Exception {
        Board board = new Board(new int[3][3]);

        assertEquals(1, board.positionToNum(0, 0));
        assertEquals(2, board.positionToNum(0, 1));
        assertEquals(3, board.positionToNum(0, 2));
        assertEquals(4, board.positionToNum(1, 0));
        assertEquals(5, board.positionToNum(1, 1));
        assertEquals(6, board.positionToNum(1, 2));
        assertEquals(7, board.positionToNum(2, 0));
        assertEquals(8, board.positionToNum(2, 1));
        assertEquals(0, board.positionToNum(2, 2));
    }

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
}
