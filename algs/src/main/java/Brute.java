/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 2/20/13
 * Time: 10:41 PM
 */
public class Brute {
    public static void main(String[] args) {

    }

    public static void draw(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            Point p1 = points[i];

            for (int j = i; j < points.length; j++) {
                Point p2 = points[j];

                for (int k = j; k < points.length; k++) {
                    Point p3 = points[k];

                    for (int l = k; l < points.length; l++) {
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
