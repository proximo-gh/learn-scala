import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> head;
    private Node<Item> tail;

    private int size;

    // construct an empty deque
    public Deque() {

    }

    // is the deque empty?
    public boolean isEmpty() {
        return head == null;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // insert the item at the front
    public void addFirst(Item item) {
        checkNull(item);

        Node<Item> node = new Node<>(item);

        if (isEmpty())
            head = tail = node;
        else {
            link(node, head);
            head = node;
        }

        size++;
    }

    // insert the item at the end
    public void addLast(Item item) {
        checkNull(item);

        Node<Item> node = new Node<>(item);

        if (isEmpty())
            head = tail = node;
        else {
            link(tail, node);
            tail = node;
        }

        size++;
    }

    // delete and return the item at the front
    public Item removeFirst() {
        checkEmpty();

        Item item = head.item;

        if (head == tail) //size == 1
            head = tail = null;
        else {
            head = head.next;
            head.prev = null;
        }

        size--;

        return item;
    }

    // delete and return the item at the end
    public Item removeLast() {
        checkEmpty();

        Item item = tail.item;

        if (head == tail) //size == 1
            head = tail = null;
        else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;

        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node<Item> current = head;

            @Override
            public boolean hasNext() {
                return current == null;
            }

            @Override
            public Item next() {
                if (current == null)
                    throw new NoSuchElementException("current is null");

                Item item = current.item;

                current = current.next;

                return item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private void link(Node<Item> first, Node<Item> second) {
        first.next = second;
        second.prev = first;
    }

    private void checkEmpty() {
        if (isEmpty())
            throw new NoSuchElementException("empty deque");
    }

    private void checkNull(Item item) {
        if (item == null)
            throw new NullPointerException("item is null");
    }

    private static final class Node<Item> {
        Item item;

        Node<Item> prev;
        Node<Item> next;

        private Node(Item item) {
            this.item = item;
        }
    }
}
