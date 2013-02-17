/**
 * Created with IntelliJ IDEA.
 * User: proximo
 * Date: 2/18/13
 * Time: 12:41 AM
 */
public class Subset {
    public static void main(String[] args) {
        int k = Integer.valueOf(args[0]);

        RandomizedQueue<String> queue = new RandomizedQueue<>();

        while (StdIn.hasNextLine())
            queue.enqueue(StdIn.readString());

        for (int i = 0; i < k; i++)
            StdOut.println(queue.dequeue());
    }
}
