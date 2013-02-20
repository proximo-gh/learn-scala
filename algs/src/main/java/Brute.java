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

    public static void draw(Point[] points) {
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
                            p1.drawTo(p2);
                            p2.drawTo(p3);
                            p3.drawTo(p4);
                        }
                    }
                }
            }
        }
    }
}
