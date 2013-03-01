import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 2/20/13
 * Time: 10:42 PM
 */
public class Fast {
    public static void main(String[] args) {

        if (stolen(args))
            return;

        Point[] points = Brute.readPoints(args[0]);

        draw(points);
    }

    private static void draw(Point[] points) {
        for (Point point : points) {
            Point[] clone = Arrays.copyOf(points, points.length);
            Arrays.sort(clone, point.SLOPE_ORDER);

            System.out.println("point = " + point);
            System.out.println(Arrays.toString(clone));
            for (Point p : clone) {
                System.out.print(point.slopeTo(p) + " ");
            }

            System.out.println();

            int i = 0;
            int c = 1;
            double s = Double.NaN;

            for (Point p : clone) {
                double slope = point.slopeTo(p);
                if (slope == s) {
                    c++;
                } else {
                    if (c >= 4)
                        break;

                    c = 1;
                    s = slope;
                }

                i++;
            }

            System.out.println("c = " + c);
            System.out.println();

            if (c >= 4) {
                while (c > 0) {
                    clone[i - c].drawTo(clone[i - c - 1]);
                    c--;
                }
            }
        }
    }

    private static void printLine(Point p1, Point p2, Point p3, Point p4) {
        System.out.println();
        System.out.println("" + p1 + " to " + p2 + " to " + p3 + " to " + p4);
        System.out.println();
    }

    private static boolean stolen(String[] args) {
        int nPoints, x, y, i, j, k, l, cont, m, n = 0;
        double value;
        Point[] points;
        Point[] orderedPoints;

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        try {
            In in = new In(args[0]);
            nPoints = Integer.parseInt(in.readLine());
            points = new Point[nPoints];
            for (i = 0; i < nPoints; i++) {
                x = Integer.parseInt(in.readString());
                y = Integer.parseInt(in.readString());
                points[i] = new Point(x, y);
                points[i].draw();
            }

            for (i = 1; i <= nPoints - 3; i++) {
                k = nPoints - i;
                orderedPoints = new Point[k];
                System.arraycopy(points, 0, orderedPoints, 0, k);
                Arrays.sort(orderedPoints, 0, k, points[k].SLOPE_ORDER);
                j = 0;
                do {
                    cont = 1;
                    m = j;
                    value = points[k].slopeTo(orderedPoints[j++]);
                    while (j < k && points[k].slopeTo(orderedPoints[j]) == value) {
                        cont++;
                        n = j;
                        j++;
                    }
                    if (cont >= 3) {
                        StdOut.print(points[k].toString());
                        for (l = m; l <= n; l++) {
                            StdOut.print(" -> " + orderedPoints[l].toString());
                            points[k].drawTo(orderedPoints[l]);
                        }
                        StdOut.println();
                    }
                } while (j < k);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return true;
    }
}
