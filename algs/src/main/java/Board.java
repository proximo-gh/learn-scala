public class Board {


    private final int[][] tiles;
    private final int N;

    // construct a board from an N-by-N array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        if (blocks == null)
            throw new IllegalArgumentException("blocks is null");

        N = blocks.length;
        this.tiles = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                this.tiles[i][j] = blocks[i][j];
    }

    // board dimension N
    public int dimension() {
        return N;
    }

    // number of blocks out of place
    public int hamming() {
        int result = 0;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (this.tiles[i][j] != i / N + j)
                    result++;

        return result;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        int result = 0;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (this.tiles[i][j] != i / N + j)
                    result++;

        return result;
    }

    public boolean isGoal() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (this.tiles[i][j] != i / N + j)
                    return false;

        return true;
    }

    // a board obtained by exchanging two adjacent blocks in the same row
    public Board twin() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        if (N != board.N) return false;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (this.tiles[i][j] != board.tiles[i][j])
                    return false;

        return true;
    }

    @Override
    public int hashCode() {
        return N;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        return null;
    }

    // string representation of the board (in the output format specified below)
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tiles[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }
}