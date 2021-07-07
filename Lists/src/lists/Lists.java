
package lists;

public class Lists {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> numbers = new DoublyLinkedList<>();
        
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        numbers.add(60);
        
        numbers.add(1, 15);
        numbers.add(5, 45);
        
        while(!numbers.isEmpty()){
            System.out.println(numbers.remove());
        }
        
    }
    
}
