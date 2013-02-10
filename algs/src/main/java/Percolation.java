public class Percolation {

    private static enum State {
        BLOCKED,
        OPEN,
        FULL
    }

    private final State[][] grid;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        if (N <= 0)
            throw new IllegalArgumentException("N must be greater than zero");

        grid = new State[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                grid[i][j] = State.BLOCKED;
    }

    // open site (row i, column j) if it is not already
    public void open(int i, int j) {

    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        return false;
    }


    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        return false;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }

    public static void main(String[] args) {
        Percolation percolation = new Percolation(20);

        System.out.println("percolation = " + percolation);
    }
}
