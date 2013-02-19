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
        if (item == null)
            throw new NullPointerException();

        if (items.length == size)
            grow();

        items[size] = item;

        size++;
    }

    private void grow() {
        copyItems(size + growFactor());
    }

    private void shrink() {
        if (items.length - size >= shrinkFactor())
            copyItems(size / 2);
    }

    private int shrinkFactor() {
        return size / 4;
    }

    private void copyItems(int newCapacity) {
        Object[] newItems = new Object[newCapacity];

        for (int i = 0; i < size; i++)
            newItems[i] = items[i];

        items = newItems;
    }

    private int growFactor() {
        return size == 0 ? 1 : size;
    }

    // delete and return a random item
    public Item dequeue() {
        checkEmpty();

        int index = StdRandom.uniform(size);

        Item item = (Item) items[index];

        for (int i = index; i < size - 1; i++)
            items[i] = items[i + 1];

        size--;

        shrink();

        return item;
    }

    private void checkEmpty() {
        if (isEmpty())
            throw new NoSuchElementException();
    }

    // return (but do not delete) a random item
    public Item sample() {
        checkEmpty();

        return (Item) items[StdRandom.uniform(size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ListIterator<Item>();
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Object[] itItems;
        private int index;

        private ListIterator()
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
            return (Item) itItems[index++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
