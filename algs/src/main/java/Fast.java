import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 2/20/13
 * Time: 10:42 PM
 */
public class Fast {
    public static void main(String[] args) {
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
}
