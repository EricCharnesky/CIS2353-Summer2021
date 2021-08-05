package trees;

public class BinarySearchTree<T extends Comparable<? super T>> {

    private T data;
    private BinarySearchTree<T> parent;
    private BinarySearchTree<T> leftChild;
    private BinarySearchTree<T> rightChild;

    public BinarySearchTree(T data) {
        this(data, null);
    }

    public BinarySearchTree(T data, BinarySearchTree<T> parent) {
        this(data, parent, null, null);
    }

    public BinarySearchTree(T data, BinarySearchTree<T> parent, BinarySearchTree<T> leftChild, BinarySearchTree<T> rightChild) {
        this.data = data;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void inOrderTravesal() {
        if (leftChild != null) {
            leftChild.inOrderTravesal();
        }
        System.out.println(data);
        if (rightChild != null) {
            rightChild.inOrderTravesal();
        }
    }

    public boolean contains(T data) {
        if (data.compareTo(this.data) == 0) {
            return true;
        } else if (data.compareTo(this.data) < 0) {
            if (leftChild == null) {
                return false;
            }
            return leftChild.contains(data);
        } else {
            if (rightChild == null) {
                return false;
            }
            return rightChild.contains(data);
        }
    }

    public boolean add(T data) {
        if (data.compareTo(this.data) == 0) {
            return false;
        } else if (data.compareTo(this.data) < 0) {
            if (leftChild == null) {
                leftChild = new BinarySearchTree<T>(data, this);
                return true;
            }
            return leftChild.add(data);
        } else {
            if (rightChild == null) {
                rightChild = new BinarySearchTree<T>(data, this);
                return true;
            }
            return rightChild.add(data);
        }
    }

    public int height() {
        int maxChildHeight = 0;
        if (leftChild != null) {
            maxChildHeight = leftChild.height() + 1;
        }
        if (rightChild != null) {
            maxChildHeight = Math.max(maxChildHeight, rightChild.height() + 1);
        }

        return maxChildHeight;
    }

    public int level() {
        int height = 0;
        BinarySearchTree<T> current = this;
        while (current.parent != null) {
            height++;
            current = current.parent;
        }
        return height;
    }
}
