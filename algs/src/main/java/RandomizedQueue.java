import java.util.Iterator;
import java.util.NoSuchElementException;

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
        if (items.length == size)
            grow();

        items[size] = item;

        size++;
    }

    private void grow() {
        Object[] newItems = new Object[size + growFactor()];

        for (int i = 0; i < items.length; i++)
            newItems[i] = items[i];

        items = newItems;
    }

    private int growFactor() {
        return 1;
    }

    // delete and return a random item
    public Item dequeue() {
        int index = StdRandom.uniform(size);

        Item item = (Item) items[index];

        for (int i = index; i < size - 1; i++)
            items[i] = items[i + 1];

        size--;

        return item;
    }

    // return (but do not delete) a random item
    public Item sample() {
        return (Item) items[StdRandom.uniform(size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            Object[] itItems;
            int index;

            {
                itItems = new Object[size];

                for (int i = 0; i < itItems.length; i++)
                    itItems[i] = items[i];
            }

            @Override
            public boolean hasNext() {
                return index < itItems.length;
            }

            @Override
            public Item next() {
                if (index >= itItems.length)
                    throw new NoSuchElementException();

                return (Item) itItems[++index];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
