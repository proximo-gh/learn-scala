public class PointSET {
    private final SET<Point2D> set = new SET<Point2D>();

    // construct an empty set of points
    public PointSET() {
    }

    // is the set empty?
    public boolean isEmpty() {
        return set.isEmpty();
    }

    // number of points in the set
    public int size() {
        return set.size();
    }

    // add the point p to the set (if it is not already in the set)
    public void insert(Point2D p) {
        set.add(p);
    }

    // does the set contain the point p?
    public boolean contains(Point2D p) {
        return set.contains(p);
    }

    // draw all of the points to standard draw
    public void draw() {
        for (Point2D point2D : set) {
            StdDraw.point(point2D.x(), point2D.y());
        }
    }

    // all points in the set that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        Queue<Point2D> result = new Queue<Point2D>();

        for (Point2D point2D : set) {
            if (rect.contains(point2D))
                result.enqueue(point2D);
        }

        return result;
    }

    // a nearest neighbor in the set to p; null if set is empty
    public Point2D nearest(Point2D p) {

        double min = Double.POSITIVE_INFINITY;
        Point2D nearest = null;

        for (Point2D point2D : set) {
            double distance = point2D.distanceSquaredTo(p);
            if (distance < min) {
                min = distance;
                nearest = point2D;
            }
        }

        return nearest;
    }
}