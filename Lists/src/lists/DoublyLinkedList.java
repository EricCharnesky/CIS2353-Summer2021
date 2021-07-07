package lists;

public class DoublyLinkedList<T> {

    private Node<T> dummyNode;
    private int numberOfItems;

    public DoublyLinkedList() {
        dummyNode = new Node<>(null, null, null);
        dummyNode.next = dummyNode;
        dummyNode.previous = dummyNode;
        numberOfItems = 0;
    }

    public void add(T data) {
        addBetween(data, dummyNode.previous, dummyNode);
    }

    public void add(int index, T data) {
        Node<T> currentNode = walkToIndex(index);

        addBetween(data, currentNode.previous, currentNode);
    }
    
    public T remove(){
        if ( isEmpty() ){
            throw new IndexOutOfBoundsException();
        }
        
        Node<T> currentNode = dummyNode.previous;
        
        return removeNode(currentNode);
    }

    public T remove(int index) {
        Node<T> currentNode = walkToIndex(index);

        T data = removeNode(currentNode);

        return data;
    }

    private T removeNode(Node<T> currentNode){
        T data = currentNode.data;
        currentNode.next.previous = currentNode.previous;
        currentNode.previous.next = currentNode.next;
        currentNode.data = null;

        numberOfItems--;
        
        return data;
    }
    
    private Node<T> walkToIndex(int index) {
        checkForValidIndex(index);
        Node<T> currentNode = dummyNode;

        // TODO - future optimization, count from back if index > 1/2 of size
        for (int currentIndex = 0; currentIndex <= index; currentIndex++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    private void checkForValidIndex(int index) {
        if (index >= numberOfItems) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void addBetween(T data, Node previous, Node next) {
        
        Node<T> newNode = new Node(data, previous, next);
        newNode.previous.next = newNode;
        newNode.next.previous = newNode;
        numberOfItems++;
    }

    public int size() {
        return numberOfItems;
    }

    public boolean isEmpty() {
        return numberOfItems == 0;

    }

    class Node<T> {

        public Node previous;
        public Node next;
        public T data;

        public Node(T data, Node previous, Node next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }
}
