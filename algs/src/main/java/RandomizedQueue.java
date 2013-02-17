import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Object[] items = new Object[0];

    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {

    }

    // is the queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (items.length == size) {
            Object[] newItems = new Object[size + 1];

            for (int i = 0; i < items.length; i++)
                newItems[i] = items[i];

            items = newItems;
        }

        items[size] = item;

        size++;
    }

    // delete and return a random item
    public Item dequeue() {
        int index = StdRandom.uniform(size);

        Item item = (Item) items[index];


        return item;
    }

    // return (but do not delete) a random item
    public Item sample() {
        return (Item) items[StdRandom.uniform(size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Item next() {
                return null;
            }

            @Override
            public void remove() {

            }
        };
    }
}
