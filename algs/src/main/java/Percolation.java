public class Percolation {

    public static enum State {
        BLOCKED,
        OPEN,
        FULL
    }

    private final int n;

    private final State[][] grid;

    public int getN() {
        return n;
    }

    public State[][] getGrid() {
        return grid;
    }

    private final WeightedQuickUnionUF uf;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        n = N;
        if (N <= 0)
            throw new IllegalArgumentException("N must be greater than zero");

        grid = new State[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                grid[i][j] = State.BLOCKED;

        uf = new WeightedQuickUnionUF(N * N);
    }

    // open site (row i, column j) if it is not already
    public void open(int i, int j) {
        if (isOpen(i, j))
            return;

        grid[i][j] = i == 0 ? State.FULL : State.OPEN;

        if (i > 0)
            checkAndUnion(i, j, i - 1, j);
        if (i < n - 1)
            checkAndUnion(i, j, i + 1, j);
        if (j > 0)
            checkAndUnion(i, j, i, j - 1);
        if (j < n - 1)
            checkAndUnion(i, j, i, j + 1);
    }

    private void checkAndUnion(int i1, int j1, int i2, int j2) {
        if (isOpen(i2, j2)) {
            uf.union(index(i2, j2), index(i1, j1));

            boolean full1 = isFull(i1, j1);
            boolean full2 = isFull(i2, j2);

            if (full1 && !full2)
                grid[i2][j2] = State.FULL;
            else if (full2 && !full1)
                grid[i1][j1] = State.FULL;
        }
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        checkIndexes(i, j);

        return grid[i][j] != State.BLOCKED;
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        checkIndexes(i, j);

        return grid[i][j] == State.FULL;
    }


    private void checkIndexes(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= n)
            throw new IndexOutOfBoundsException();
    }

    // does the system percolate?
    public boolean percolates() {

        for (int i = 0; i < n; i++) {
            boolean hasFull = false;

            for (int j = 0; j < n; j++)
                if (isFull(i, j)) {
                    hasFull = true;
                    break;
                }

            if (!hasFull)
                return false;
        }

        return true;
    }

    private int index(int i, int j) {
        return i * n + j;
    }

    public static void main(String[] args) {
        Percolation percolation = new Percolation(20);

        System.out.println("percolation = " + percolation);
    }
}
