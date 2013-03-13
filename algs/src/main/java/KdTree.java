import java.util.Comparator;

public class KdTree {
    private static final Comparator<Point2D> BY_X = new Comparator<Point2D>() {
        @Override
        public int compare(Point2D o1, Point2D o2) {
            return Double.compare(o1.x(), o2.x());
        }
    };

    private static final Comparator<Point2D> BY_Y = new Comparator<Point2D>() {
        @Override
        public int compare(Point2D o1, Point2D o2) {
            return Double.compare(o1.y(), o2.y());
        }
    };

    // construct an empty set of points
    public KdTree() {
    }

    // is the set empty?
    public boolean isEmpty() {
        return true;
    }

    // number of points in the set
    public int size() {
        return 0;
    }

    // add the point p to the set (if it is not already in the set)
    public void insert(Point2D p) {
    }

    // does the set contain the point p?
    public boolean contains(Point2D p) {
        return false;
    }

    // draw all of the points to standard draw
    public void draw() {
    }

    // all points in the set that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        return null;
    }

    // a nearest neighbor in the set to p; null if set is empty
    public Point2D nearest(Point2D p) {
        return null;
    }

    private static class Node {
        private Point2D value;
        private Comparator<Point2D> comparator;
        private Node left;
        private Node right;

        private Node(Point2D value, Comparator<Point2D> comparator) {
            this.value = value;
            this.comparator = comparator;
        }
    }
}