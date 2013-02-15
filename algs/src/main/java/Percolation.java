public class Percolation {

    private final int n;

    private final boolean[][] grid;

    private final boolean[] full;

    private final WeightedQuickUnionUF uf;

    private boolean percolates = false;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        n = N;
        if (N <= 0)
            throw new IllegalArgumentException("N must be greater than zero");

        grid = new boolean[N][N];

        full = new boolean[N * N];

        uf = new WeightedQuickUnionUF(N * N);
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

        grid[i - 1][j - 1] = true;

        if (i == 1) {
            full[ufIndex(i, j)] = true;

            if (n == 1)
                percolates = true;
        }

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
            int ufi1 = ufIndex(i1, j1);
            int ufi2 = ufIndex(i2, j2);
            boolean full1 = full[ufi1];
            boolean full2 = full[ufi2];

            if (full1 && !full2) {
                full[ufi2] = true;
                if (i2 == n - 1)
                    percolates = true;
            }
            else if (full2 && !full1) {
                full[ufi1] = true;
                if (i1 == n - 1)
                    percolates = true;
            }

            uf.union(index(i1, j1), index(i2, j2));
        }
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        checkIndexes(i - 1, j - 1);

        return grid[i - 1][j - 1];
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        checkIndexes(i - 1, j - 1);

        return full[ufIndex(i, j)];
    }

    private int ufIndex(int i, int j) {
        return uf.find(index(i, j));
    }


    private void checkIndexes(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= n)
            throw new IndexOutOfBoundsException();
    }

    // does the system percolate?
    public boolean percolates() {
/*
        for (int i = 1; i <= n; i++) {
            boolean hasFull = false;

            for (int j = 1; j <= n; j++)
                if (isOpen(i, j) && isFull(i, j)) {
                    hasFull = true;
                    break;
                }

            if (!hasFull)
                return false;
        }

        return true;
*/
/*
        for (int j = 1; j <= n; j++)
            if (isOpen(n, j) && isFull(n, j))
                return true;

        return false;
*/
        return percolates;
    }

    private int index(int i, int j) {
        return (i - 1) * n + (j - 1);
    }
}
