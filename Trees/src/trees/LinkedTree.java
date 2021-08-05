package trees;

import java.util.ArrayList;

public class LinkedTree<T> {

    private Node<T> root;

    public LinkedTree(T object) {
        root = new Node<T>(object);
    }
    
    public T getRoot(){
        return root.getData();
    }

    private class Node<T> {

        private LinkedTree<T> parent;
        private ArrayList<LinkedTree<T>> children;
        private T data;

        public Node(T data) {
            this(data, null, new ArrayList<LinkedTree<T>>());
        }

        public Node(T data, LinkedTree<T> parent) {
            this(data, parent, new ArrayList<LinkedTree<T>>());

        }

        public Node(T data, LinkedTree<T> parent, ArrayList<LinkedTree<T>> children) {
            this.data = data;
            this.parent = parent;
            this.children = children;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
        
        

        public LinkedTree<T> getParent() {
            return parent;
        }

        public ArrayList<LinkedTree<T>> getChildren() {
            return children;
        }

        public void setParent(LinkedTree<T> parent) {
            this.parent = parent;
        }

        public void setChildren(ArrayList<LinkedTree<T>> children) {
            this.children = children;
        }

    }
}
