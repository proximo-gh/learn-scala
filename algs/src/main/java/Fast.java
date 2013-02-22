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
            Point[] clone = new Point[points.length];
            System.arraycopy(points, 0, clone, 0, points.length);
            Arrays.sort(clone, point.SLOPE_ORDER);
            System.out.println("point = " + point);
            System.out.println(Arrays.toString(clone));
            int i;

            for (i = 0; i < clone.length; i++) {
                Point p = clone[i];

                if (p.compareTo(point) == 0)
                    break;
            }

            if (clone.length - i >= 4) {
                Point p1 = clone[i];
                Point p2 = clone[i + 1];
                Point p3 = clone[i + 2];
                Point p4 = clone[i + 3];

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
