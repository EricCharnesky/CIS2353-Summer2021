package stacks;

import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T> {

    private Node<T> top;

    public LinkedStack() {
        top = null;
    }

    // O(1)
    @Override
    public void push(T item) {
        Node<T> node = new Node<T>(item, top);
        top = node;
    }

    // O(1)
    @Override
    public T pop() {
        checkForEmptyAndThrow();
        T item = top.item;
        top = top.next;
        return item;
    }

    // O(1)
    @Override
    public T peek() {
        checkForEmptyAndThrow();
        return top.item;
    }

    // O(1)
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    // O(1)
    @Override
    public void clear() {
        top = null;
    }

    private void checkForEmptyAndThrow() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }

    class Node<T> {

        public T item;
        public Node next;

        public Node(T item) {
            this(item, null);
        }

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

}
