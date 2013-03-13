import java.util.Comparator;

public class KdTree {
    private Node root;
    private int size;

    // construct an empty set of points
    public KdTree() {
    }

    // is the set empty?
    public boolean isEmpty() {
        return root == null;
    }

    // number of points in the set
    public int size() {
        return size;
    }

    private static Comparator<Point2D> next(Comparator<Point2D> comparator) {
        if (comparator == Point2D.X_ORDER)
            return Point2D.Y_ORDER;
        else if (comparator == Point2D.Y_ORDER)
            return Point2D.X_ORDER;

        throw new IllegalStateException("Unknown comparator = " + comparator);
    }

    // add the point p to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (root == null)
            root = new Node(p, Point2D.X_ORDER);
        else {
            Node node = root;

            while (node != null) {
                if (node.value.equals(p))
                    break;
                int cmp = node.comparator.compare(node.value, p);

                if (cmp <= 0) {
                    if (node.left == null) {
                        node.left = new Node(p, next(node.comparator));
                        break;
                    } else
                        node = node.left;
                } else {
                    if (node.right == null) {
                        node.right = new Node(p, next(node.comparator));
                        break;
                    } else
                        node = node.right;
                }
            }
        }

        size++;
    }

    private Node find(Point2D p) {
        Node node = root;

        while (node != null) {
            if (node.value.equals(p))
                return node;
            int cmp = node.comparator.compare(node.value, p);

            if (cmp <= 0)
                node = node.left;
            else
                node = node.right;
        }

        return null;
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