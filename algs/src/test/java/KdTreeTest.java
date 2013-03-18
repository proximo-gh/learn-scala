import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 3/14/13
 * Time: 1:02 AM
 */
public class KdTreeTest {
    @Test
    public void testRange() throws Exception {
        KdTree tree = new KdTree();

        tree.insert(new Point2D(0.1, 0.8));
        tree.insert(new Point2D(0.7, 0.8));
        tree.insert(new Point2D(0.3, 0.6));
        tree.insert(new Point2D(0.5, 0.6));

        Iterable<Point2D> range = tree.range(new RectHV(0.2, 0.5, 0.5, 0.9));

        for (Point2D point2D : range) {
            System.out.println(point2D);
        }
    }

    @Test
    public void testRangeSET() throws Exception {
        PointSET tree = new PointSET();

        tree.insert(new Point2D(0.1, 0.8));
        tree.insert(new Point2D(0.7, 0.8));
        tree.insert(new Point2D(0.3, 0.6));
        tree.insert(new Point2D(0.5, 0.6));

        Iterable<Point2D> range = tree.range(new RectHV(0.2, 0.5, 0.5, 0.9));

        for (Point2D point2D : range) {
            System.out.println(point2D);
        }
    }

    @Test
    public void testNearest() throws Exception {
        KdTree tree = new KdTree();

        tree.insert(new Point2D(0.1, 0.8));
        tree.insert(new Point2D(0.7, 0.8));
        tree.insert(new Point2D(0.3, 0.6));
        tree.insert(new Point2D(0.5, 0.6));

        Point2D nearest = tree.nearest(new Point2D(0.2, 0.7));

        System.out.println("nearestTree = " + nearest);
    }

    @Test
    public void testNearestSET() throws Exception {
        PointSET tree = new PointSET();

        tree.insert(new Point2D(0.1, 0.8));
        tree.insert(new Point2D(0.7, 0.8));
        tree.insert(new Point2D(0.3, 0.6));
        tree.insert(new Point2D(0.5, 0.6));

        Point2D nearest = tree.nearest(new Point2D(0.2, 0.7));

        System.out.println("nearestSET = " + nearest);
    }
}
