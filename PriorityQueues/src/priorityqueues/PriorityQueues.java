package priorityqueues;

public class PriorityQueues {

    public static void main(String[] args) {
        MaxPriorityQueue<Integer> maxPriorityQueue = new MaxPriorityQueue<Integer>();
        maxPriorityQueue.enqueue(3);
        maxPriorityQueue.enqueue(25);
        maxPriorityQueue.enqueue(7);
        maxPriorityQueue.enqueue(10);
        maxPriorityQueue.enqueue(4);
        maxPriorityQueue.enqueue(30);
        maxPriorityQueue.enqueue(33);
        
        
        while ( !maxPriorityQueue.isEmpty() ){
            System.out.println(maxPriorityQueue.removeFront());
        }
    }

}
