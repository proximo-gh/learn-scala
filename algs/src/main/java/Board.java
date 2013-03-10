public class Board {


    private final int[][] blocks;
    private final int N;

    // construct a board from an N-by-N array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        if (blocks == null)
            throw new IllegalArgumentException("blocks is null");

        N = blocks.length;
        this.blocks = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                this.blocks[i][j] = blocks[i][j];
    }

    // board dimension N
    public int dimension() {
        return 0;
    }

    // number of blocks out of place
    public int hamming() {
        return 0;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        return 0;
    }

    public boolean isGoal() {
        return false;

    }

    // a board obtained by exchanging two adjacent blocks in the same row
    public Board twin() {
        return null;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        return false;

    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        return null;
    }

    // string representation of the board (in the output format specified below)
    public String toString() {
        return "";
    }
}