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

            while (true) {
                if (node.value.equals(p))
                    return;
                int cmp = node.comparator.compare(p, node.value);

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
            int cmp = node.comparator.compare(p, node.value);

            if (cmp <= 0)
                node = node.left;
            else
                node = node.right;
        }

        return null;
    }

    // does the set contain the point p?
    public boolean contains(Point2D p) {
        return find(p) != null;
    }

    // draw all of the points to standard draw
    public void draw() {
    }

    // all points in the set that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        Queue<Point2D> result = new Queue<Point2D>();

        find(rect, root, result);

        return result;
    }

    private void find(RectHV rect, Node node, Queue<Point2D> result) {
        if (node == null)
            return;

        Point2D value = node.value;

        if (rect.contains(value)) {
            result.enqueue(value);
        }

        if (node.comparator == Point2D.Y_ORDER) {
            if (rect.ymin() <= value.y())
                find(rect, node.left, result);
            if (rect.ymax() >= value.y())
                find(rect, node.right, result);
        } else if (node.comparator == Point2D.X_ORDER) {
            if (rect.xmin() <= value.x())
                find(rect, node.left, result);
            if (rect.xmax() >= value.x())
                find(rect, node.right, result);
        }
    }

    // a nearest neighbor in the set to p; null if set is empty
    public Point2D nearest(Point2D p) {
        return nearest(root, p, null, Double.POSITIVE_INFINITY);
    }

    private Point2D nearest(Node node, Point2D p, Point2D min, double minDistance) {
        if (node == null)
            return min;

        Point2D best = min;
        double bestDistance = minDistance;

        double d = node.value.distanceSquaredTo(p);
        if (best == null || d < bestDistance) {
            bestDistance = d;
            best = node.value;

            if (bestDistance == 0)
                return best;
        }

        double dx;

        if (node.comparator == Point2D.X_ORDER)
            dx = node.value.x() - p.x();
        else
            dx = node.value.y() - p.y();

        double dx2 = dx * dx;

        Point2D bestChild = nearest(dx > 0 ? node.left : node.right, p, best, bestDistance);

        if (best != bestChild) {
            bestDistance = bestChild.distanceSquaredTo(p);
            best = bestChild;
        }

        if (dx2 < bestDistance)
            bestChild = nearest(dx > 0 ? node.right : node.left, p, best, bestDistance);

        if (best != bestChild)
            return bestChild;

        return best;
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

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}