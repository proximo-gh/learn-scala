/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 2/20/13
 * Time: 10:41 PM
 */
public class Brute {
    public static void main(String[] args) {
        Point[] points = readPoints(args[0]);

        draw(points);

        // display to screen all at once
        StdDraw.show();
    }

    private static Point[] readPoints(String filename) {
        // rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show();

        // read in the input
        In in = new In(filename);
        int N = in.readInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();

            Point p = new Point(x, y);
            p.draw();

            points[i] = p;
        }

        // display to screen all at once
        StdDraw.show();

        return points;
    }

    private static void draw(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            Point p1 = points[i];

            for (int j = i + 1; j < points.length; j++) {
                Point p2 = points[j];

                for (int k = j + 1; k < points.length; k++) {
                    Point p3 = points[k];

                    for (int l = k + 1; l < points.length; l++) {
                        Point p4 = points[l];

                        double s12 = p1.slopeTo(p2);
                        double s13 = p1.slopeTo(p3);
                        double s14 = p1.slopeTo(p4);

                        if (s12 == s13 && s13 == s14) {
                            StdOut.print(p2);

                            p1.drawTo(p2);
                            StdOut.print(" -> " + p1);

                            p2.drawTo(p3);
                            StdOut.print(" -> " + p4);

                            p3.drawTo(p4);
                            StdOut.print(" -> " + p3);

                            StdOut.println();
                        }
                    }
                }
            }
        }
    }

    private static boolean stolen(String[] args) {
        int nPoints, i, j, k, l, m, x, y, indexes[];
        double[] slopes;
        double s;
        Point[] points;
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        In in = new In(args[0]);
        nPoints = Integer.parseInt(in.readLine());
        points = new Point[nPoints];
        slopes = new double[nPoints];
        for (i = 0; i < nPoints; i++) {
            x = Integer.parseInt(in.readString());
            y = Integer.parseInt(in.readString());
            points[i] = new Point(x, y);
            points[i].draw();
        }

        indexes = new int[4];
        for (i = 0; i < nPoints; i++) {
            for (j = i + 1; j < nPoints; j++)
                slopes[j] = points[i].slopeTo(points[j]);

            indexes[0] = i;
            for (j = i + 1; j < nPoints - 2; j++) {
                s = slopes[j];
                indexes[1] = j;
                for (k = j + 1; k < nPoints - 1; k++) {
                    if (s == slopes[k]) {
                        indexes[2] = k;
                        for (l = k + 1; l < nPoints; l++)
                            if (s == slopes[l]) {
                                indexes[3] = l;
                                StdOut.println(points[indexes[0]].toString() + " -> " + points[indexes[1]].toString() + " -> " + points[indexes[2]].toString() + " -> " + points[indexes[3]].toString());
                                for (m = 1; m < 4; m++) points[indexes[0]].drawTo(points[indexes[m]]);
                            }
                    }
                }
            }

        }
        return true;
    }
}
