package adtbag;

public class BagLinkedObjects<T> implements BagInterface<T> {

    // internal storage
    private class Node<T> {

        public T item;
        public Node<T> next;

        public Node(T item) {
            this(item, null);
        }

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private int numberOfItems;
    private Node first;

    public BagLinkedObjects() {
        first = null;
        numberOfItems = 0;
    }

    @Override
    public int getCurrentSize() {
        return numberOfItems;
    }

    @Override
    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    @Override
    public boolean add(T item) {
        Node newNode = new Node(item, first);
        first = newNode;
        numberOfItems++;
        return true;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Bag is empty");
        }

        Node<T> toRemove = first;
        first = first.next;
        return toRemove.item;
    }

    @Override
    public boolean remove(T item) {
        if (isEmpty()) {
            throw new IllegalStateException("Bag is empty");
        }

        if (item.equals(first.item)) {
            remove();
            return true;
        }

        Node<T> current = first;
        while (current.next != null) {
            if (current.next.item.equals(item)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public void clear() {
        first = null;
        numberOfItems = 0;
    }

    @Override
    public int getFrequencyOf(T item) {
        int frequency = 0;
        Node<T> current = first;

        while (current != null) {
            if (current.item.equals(item)) {
                frequency++;
            }
            current= current.next;
        }
        
        return frequency;
    }

    @Override
    public boolean contains(T item) {
        Node<T> current = first;

        while (current != null) {
            if (current.item.equals(item)) {
                return true;
            }
            current= current.next;
        }
        
        return false;
    }

    @Override
    public T[] toArray() {
        T[] result = (T[]) new Object[numberOfItems];
        Node<T> current = first;
        for ( int index = 0; index < numberOfItems; index++ )
        {
            result[index] = current.item;
            current = current.next;
        }
        
        return result;
    }

}
