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
            for (int j = 0; j < N; j++) {
                int current = this.tiles[i][j];

                if (current != 0 && current != positionToNum(i, j))
                    result++;
            }

        return result;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        int result = 0;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                int current = tiles[i][j];
                if (current != 0) {
                    int[] pos = numToPosition(current);
                    int d = Math.abs(i - pos[0]) + Math.abs(j - pos[1]);
                    result += d;
                }
            }

        return result;
    }

    int[] numToPosition(int num) {
        if (num == 0)
            num = N * N;
        return new int[]{(num - 1) / N, (num - 1) % N};
    }

    int positionToNum(int i, int j) {
        if (i == N - 1 && j == N - 1)
            return 0;

        return i * N + j + 1;
    }

    public boolean isGoal() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (this.tiles[i][j] != positionToNum(i, j))
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