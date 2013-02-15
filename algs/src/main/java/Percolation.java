public class Percolation {

    private final int n;

    private final boolean[][] grid;

    private final WeightedQuickUnionUF uf;

    private final int virtualTop;
    private final int virtualBottom;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        if (N <= 0)
            throw new IllegalArgumentException("N must be greater than zero");

        n = N;

        int n1 = n + 1;

        grid = new boolean[n1][n1];

        int p = n1 * n1;

        uf = new WeightedQuickUnionUF(p + 2);

        virtualTop = p;
        virtualBottom = p + 1;
    }
/*

    public int getN() {
        return n;
    }
*/

    // open site (row i, column j) if it is not already
    public void open(int i, int j) {
        if (isOpen(i, j))
            return;

        grid[i][j] = true;

        int index = index(i, j);

        if (i == 1)
            uf.union(virtualTop, index);
        if (i == n)
            uf.union(virtualBottom, index);

        if (i > 1)
            checkAndUnion(i, j, i - 1, j);
        if (i < n)
            checkAndUnion(i, j, i + 1, j);
        if (j > 1)
            checkAndUnion(i, j, i, j - 1);
        if (j < n)
            checkAndUnion(i, j, i, j + 1);
    }

    private void checkAndUnion(int i1, int j1, int i2, int j2) {
        if (isOpen(i2, j2)) {
            int index1 = index(i1, j1);
            int index2 = index(i2, j2);

            uf.union(index1, index2);
        }
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        checkIndexes(i, j);

        return grid[i][j];
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        checkIndexes(i, j);

        return uf.connected(index(i, j), virtualTop);
    }

    private void checkIndexes(int i, int j) {
        if (i < 1 || j < 1 || i > n || j > n)
            throw new IndexOutOfBoundsException();
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.connected(virtualTop, virtualBottom);
    }

    private int index(int i, int j) {
        return i * n + j;
    }
}
