package trees;

public class Trees {

    public static void main(String[] args) {
        BinaryLinkedTree<Integer> numbers = new BinaryLinkedTree<>(10);
        numbers.addLeft(20);
        numbers.addRight(30);

        BinaryLinkedTree<Integer> leftChild = numbers.getLeftChild();

        leftChild.addLeft(40);

        BinaryLinkedTree<Integer> rightChild = numbers.getRightChild();
        rightChild.addRight(50);

        BinaryLinkedTree<Integer> rightRightChild = rightChild.getRightChild();

        rightRightChild.addLeft(60);

        System.out.println(numbers.height());

        BinarySearchTree bst = new BinarySearchTree(40);
        bst.add(20);
        bst.add(10);
        bst.add(15);
        bst.add(30);
        bst.add(60);
        bst.add(50);
        bst.add(55);
        bst.inOrderTravesal();
    }

}
