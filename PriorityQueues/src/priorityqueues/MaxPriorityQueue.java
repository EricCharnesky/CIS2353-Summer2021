package priorityqueues;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxPriorityQueue<T extends Comparable<? super T>> {

    private ArrayList<T> data;
    private int numberOfItems;

    public MaxPriorityQueue() {
        data = new ArrayList<>();
        numberOfItems = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(data.toArray());
    }

    public void enqueue(T item) {

        data.add(item);

        upheap(numberOfItems);

        numberOfItems++;
    }

    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalAccessError();
        }

        return data.get(0);
    }

    public T removeFront() {
        T item = data.get(0);

        numberOfItems--;

        data.set(0, data.get(numberOfItems));
        data.remove(numberOfItems);

        downheap(0);

        return item;
    }

    private void downheap(int index) {
        int leftChildIndex = leftChild(index);
        if (leftChildIndex < numberOfItems) {
            int largestChildIndex = leftChildIndex;
            int rightChildIndex = rightChild(index);
            if (rightChildIndex < numberOfItems) {
                if (data.get(rightChildIndex).compareTo(data.get(leftChildIndex)) > 0) {
                    largestChildIndex = rightChildIndex;
                }
            }
            if (data.get(largestChildIndex).compareTo(data.get(index)) > 0) {
                swap(index, largestChildIndex);
                downheap(largestChildIndex);
            }
        }
    }

    private void upheap(int index) {
        int parentIndex = parent(index);
        if (data.get(index).compareTo(data.get(parentIndex)) > 0) {
            swap(index, parentIndex);
            upheap(parentIndex);
        }
    }

    private void swap(int index, int indexToSwapWith) {
        T temp = data.get(index);
        data.set(index, data.get(indexToSwapWith));
        data.set(indexToSwapWith, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }
}
