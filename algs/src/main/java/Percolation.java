public class Percolation {

    private static enum State {
        BLOCKED,
        OPEN,
        FULL
    }

    private int n;

    private final State[][] grid;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        n = N;
        if (N <= 0)
            throw new IllegalArgumentException("N must be greater than zero");

        grid = new State[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                grid[i][j] = State.BLOCKED;
    }

    // open site (row i, column j) if it is not already
    public void open(int i, int j) {
        if(isOpen(i, j))
            return;

        grid[i][j] = State.OPEN;
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        checkIndexes(i, j);

        State state = grid[i][j];
        return state != State.BLOCKED;
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        checkIndexes(i, j);

        State state = grid[i][j];

        return state == State.FULL;
    }


    private void checkIndexes(int i, int j) {
        if(i < 1 || j < 1 || i >= n || j >= n)
            throw new IllegalArgumentException();
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

    public static void main(String[] args) {
        Percolation percolation = new Percolation(20);

        System.out.println("percolation = " + percolation);
    }
}
