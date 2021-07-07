
package midtermreview;

import java.util.*;


public class MidtermReview {


    public static void main(String[] args) {
        numberChecker(10);
        
        
        PriorityQueue<LongString> strings = new PriorityQueue<>();
        Scanner keyboard = new Scanner(System.in);
        for ( int sentenceCount = 0; sentenceCount< 5; sentenceCount++){
            System.out.println("Enter a setence");
            strings.add(new LongString(keyboard.nextLine()));
        }
        
        
        while ( !strings.isEmpty()){
            System.out.println(strings.remove());
        }
        
    }
    
    public static void numberChecker(int number){
        System.out.println(number);
        if ( number % 2 == 0 ){
            numberChecker(number+1);
        } else if ( number % 5 == 0 ){
            return;
        } else {
            numberChecker(number*2);
        }
    }
    
    
    public Queue<Stack<Integer>> quickTrickStackQueue(int number){
        
        Queue<Stack<Integer>> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for ( int n = 2; n < number; n++){
            if ( isPrime(n) ){
                queue.add(stack);
                stack = new Stack<>();
            }
            stack.push(n);
        }
        
        return queue;
    }
    
    // https://www.geeksforgeeks.org/java-program-to-check-if-a-number-is-prime-or-not/
    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;
  
        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
  
        return true;
    }
    
}
