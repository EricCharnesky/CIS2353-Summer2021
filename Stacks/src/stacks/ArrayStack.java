package stacks;

import java.util.EmptyStackException;

public class ArrayStack<T> implements StackInterface<T> {

    private static final int DEFAULT_CAPACITY = 25;

    private int numberOfItems;
    private T[] items;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int size) {
        // you can't create a new array of type T, you have to cast an Object array
        items = (T[]) new Object[size];
        numberOfItems = 0;
    }

    // O(1) - average
    // O(n) -  worst case, because of resizing
    @Override
    public void push(T item) {
        if (numberOfItems == items.length) {
            increaseCapacity();
        }
        items[numberOfItems] = item;
        numberOfItems++;
    }

    // O(1)
    @Override
    public T pop() {
        checkForEmptyAndThrow();

        numberOfItems--;
        T item = items[numberOfItems];
        items[numberOfItems] = null;
        return item;
    }

    // O(1)
    @Override
    public T peek() {
        checkForEmptyAndThrow();

        return items[numberOfItems - 1];
    }

    // O(1)
    @Override
    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    // O(n)
    @Override
    public void clear() {
        while (!isEmpty()){
            pop();
        }
    }

    // O(n) - linear
    private void increaseCapacity() {
        T[] newItems = (T[]) new Object[numberOfItems * 2];
        for (int index = 0; index < numberOfItems; index++) {
            newItems[index] = items[index];
        }

        items = newItems;
    }

    private void checkForEmptyAndThrow() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }

}
