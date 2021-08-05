
package trees;


public class BinaryLinkedTree<T> {
    
    private T data;
    private BinaryLinkedTree<T> parent;
    private BinaryLinkedTree<T> leftChild;
    private BinaryLinkedTree<T> rightChild;

    public BinaryLinkedTree(T data) {
        this(data, null);
    }

    public BinaryLinkedTree(T data, BinaryLinkedTree<T> parent) {
        this(data, parent, null, null);
    }

    public BinaryLinkedTree(T data, BinaryLinkedTree<T> parent, BinaryLinkedTree<T> leftChild, BinaryLinkedTree<T> rightChild) {
        this.data = data;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    
    public int height(){
        int maxChildHeight = 0;
        if ( leftChild != null ){
            maxChildHeight = leftChild.height() + 1;
        }
        if ( rightChild != null ){
            maxChildHeight = Math.max(maxChildHeight, rightChild.height() + 1);
        }
        
        return maxChildHeight;
        
    }
    
    public int level(){
        int height = 0;
        BinaryLinkedTree<T> current = this;
        while ( current.getParent() != null ){
            height++;
            current = current.getParent();
        }
        return height;
    }
    
    public boolean addLeft(T data){
        if ( leftChild != null ){
            return false;
        }
        leftChild = new BinaryLinkedTree<>(data, this);
        return true;
    }
    
    public boolean addRight(T data){
        if ( rightChild != null ){
            return false;
        }
        rightChild = new BinaryLinkedTree<>(data, this);
        return true;
    }

    
    
    public T getData() {
        return data;
    }

    public BinaryLinkedTree<T> getParent() {
        return parent;
    }

    public BinaryLinkedTree<T> getLeftChild() {
        return leftChild;
    }

    public BinaryLinkedTree<T> getRightChild() {
        return rightChild;
    }
    
    
    
    
    
    
}
