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

    private int[] numToPosition(int n) {
        int num = n;
        if (num == 0)
            num = N * N;
        return new int[]{(num - 1) / N, (num - 1) % N};
    }

    private int positionToNum(int i, int j) {
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
        Board board = new Board(this.tiles);

        int[] pos = findZero();

        int i0 = pos[0];

        int i = i0 == 0 ? 1 : 0;

        int tmp = board.tiles[i][0];
        board.tiles[i][0] = board.tiles[i][1];
        board.tiles[i][1] = tmp;

        return board;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Queue<Board> result = new Queue<Board>();

        int[] pos = findZero();

        int i0 = pos[0];
        int j0 = pos[1];

        addNeighbor(result, i0, j0, 1, 0);
        addNeighbor(result, i0, j0, -1, 0);
        addNeighbor(result, i0, j0, 0, 1);
        addNeighbor(result, i0, j0, 0, -1);

        return result;
    }

    private void addNeighbor(Queue<Board> result, int i0, int j0, int di, int dj) {
        int i1 = i0 + di;
        int j1 = j0 + dj;
        if (i1 < N && j1 < N && i1 >= 0 && j1 >= 0) {
            Board board = new Board(this.tiles);

            int tmp = board.tiles[i1][j1];
            board.tiles[i1][j1] = board.tiles[i0][j0];
            board.tiles[i0][j0] = tmp;

            result.enqueue(board);
        }
    }

    private int[] findZero() {
        int[] pos = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (this.tiles[i][j] == 0) {
                    pos[0] = i;
                    pos[1] = j;

                    break;
                }
        return pos;
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