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
                int i;
                int j;

                do {
                    i = 1 + (int) (StdRandom.random() * n);
                    j = 1 + (int) (StdRandom.random() * n);

                    printPercolation(p, n);
                    System.out.println("i = " + i + " j = " + j);
                } while (p.isOpen(i, j));

                p.open(i, j);
                c++;
            } while (!p.percolates());

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("!!!!!!percolates!!!!!!!");

            printPercolation(p, n);
            System.out.println();

            x[k] = ((double) c) / (double) (n * n);
        }
    }

    private static void printPercolation(Percolation p, int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if (p.isFull(i, j))
                    System.out.print("F ");
                else if (p.isOpen(i, j))
                    System.out.print("O ");
                else
                    System.out.print("B ");
            }

            System.out.println();
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

        double cLo = ps.confidenceLo();
        double cHi = ps.confidenceHi();
        StdOut.println("95% confidence interval = " + cLo + ", " + cHi);
    }
}