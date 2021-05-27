package adtbag;

public class BagArray<T> implements BagInterface<T> {

    private static final int DEFAULT_CAPACITY = 25;

    private int numberOfItems;
    private T[] items;

    public BagArray() {
        this(DEFAULT_CAPACITY);
    }

    public BagArray(int size) {
        // you can't create a new array of type T, you have to cast an Object array
        items = (T[]) new Object[size];
        numberOfItems = 0;
    }

    @Override
    // O(1) - constant
    public int getCurrentSize() {
        return numberOfItems;
    }

    @Override
    // O(1) - constant
    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    @Override
    // O(1) - constant - average time
    public boolean add(T item) {
        if (numberOfItems == items.length) {
            increaseCapacity();
        }
        items[numberOfItems] = item;
        numberOfItems++;
        return true;
    }

    @Override
    // O(1) - constant
    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Bag is empty");
        }

        numberOfItems--;
        T item = items[numberOfItems];
        items[numberOfItems] = null;
        return item;
    }

    @Override
    // O(n) - linear
    public boolean remove(T item) {
        for (int index = 0; index < numberOfItems; index++) {
            if (item.equals(items[index])) {
                numberOfItems--;
                items[index] = items[numberOfItems];
                items[numberOfItems] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    // O(n) - linear
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    @Override
    // O(n) - linear
    public int getFrequencyOf(T item) {
        int frequency = 0;
        for (int index = 0; index < numberOfItems; index++) {
            if (items[index].equals(item)) {
                frequency++;
            }
        }
        return frequency;
    }

    @Override
    // O(n) - linear
    public boolean contains(T item) {
        for (int index = 0; index < numberOfItems; index++) {
            if (items[index].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    // O(n) - linear
    public T[] toArray() {
        // REALLY BAD! - don't give access to your private data member
        //return items;
        
        T[] result = (T[]) new Object[numberOfItems];
        for ( int index = 0; index < numberOfItems; index++)
        {
            result[index] = items[index];
        }
        
        return result;
    }

    // O(n) - linear
    private void increaseCapacity() {
        T[] newItems = (T[]) new Object[numberOfItems*2];
        for ( int index = 0; index < numberOfItems; index++){
            newItems[index] = items[index];
        }
        
        items = newItems;
    }

}
