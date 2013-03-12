import java.util.Comparator;

public class Solver {

    private static final Comparator<Node> COMPARATOR = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return compare(val(o1), val(o2));
        }

        private int val(Node node) {
            return node.board.manhattan() + node.moves;
        }

        private int compare(int x, int y) {
            if (x < y)
                return -1;
            if (x == y)
                return 0;

            return 1;
        }
    };

    private Node goalNode;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        MinPQ<Node> pq = new MinPQ<Node>(COMPARATOR);

        pq.insert(new Node(null, initial, 0));

        Node current;

        do {
            current = pq.delMin();

            Node previous = current.previous;

            for (Board neighbor : current.board.neighbors())
                if (previous != null && !neighbor.equals(previous.board))
                    pq.insert(new Node(current, neighbor, current.moves + 1));
        }
        while (!pq.isEmpty() && !current.board.isGoal());

        if (current.board.isGoal())
            goalNode = current;
    }

    // is the initial board solvable?
    public boolean isSolvable() {
        return goalNode != null;
    }

    // min number of moves to solve initial board; -1 if no solution
    public int moves() {
        if (goalNode == null)
            return -1;

        return goalNode.moves;
    }

    // sequence of boards in a shortest solution; null if no solution
    public Iterable<Board> solution() {
        if (goalNode == null)
            return null;

        Stack<Board> result = new Stack<Board>();

        Node node = goalNode;

        while (node != null) {
            result.push(node.board);
            node = node.previous;
        }

        return result;
    }

    private static class Node {
        private final Node previous;
        private final Board board;
        private final int moves;

        private Node(Node previous, Board board, int moves) {
            this.previous = previous;
            this.board = board;
            this.moves = moves;
        }
    }

    // solve a slider puzzle (given below)
    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
