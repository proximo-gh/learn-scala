public class PercolationStats {

    private final int n;
    private final int t;

    private final double[] x;

    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        n = N;
        t = T;
        if (N <= 0 || T <= 0)
            throw new IllegalArgumentException();

        x = new double[t];

        for (int k = 0; k < t; k++) {
            int c = 0;

            Percolation p = new Percolation(n);

            do {
                int i = (int) (StdRandom.random() * n);
                int j = (int) (StdRandom.random() * n);
                if (!p.isOpen(i, j)) {

                    p.open(i, j);
                    c++;
                }

            } while (!p.percolates());

            x[k] = ((double) c) / (double) (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(x);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(x);
    }

    // returns lower bound of the 95% confidence interval
    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(t));
    }

    // returns upper bound of the 95% confidence interval
    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(t));
    }

    // test client, described below
    public static void main(String[] args) {
        if (args.length != 2)
            throw new IllegalArgumentException("args length must be 2");

        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        PercolationStats ps = new PercolationStats(n, t);

        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = " + ps.confidenceLo() + ", " + ps.confidenceHi());
    }
}