
package sorting;

import java.util.*;

public class Sorting {

    public static void main(String[] args) {
        Random random = new Random();
        
        Integer[] numbers = getRandomArrayOfInts(10, 100);
        
        System.out.println(Arrays.toString(numbers)); // thanks iron0maiden
        
        Sorts.SelectionSort(numbers);
        
        System.out.println(Arrays.toString(numbers));
        
        numbers = getRandomArrayOfInts(10, 100);
        
        System.out.println("");
        
        System.out.println(Arrays.toString(numbers)); // thanks iron0maiden
        
        Sorts.InsertionSort(numbers);
        
        System.out.println(Arrays.toString(numbers));
        
        System.out.println("");
        numbers = getRandomArrayOfInts(10, 999);
        System.out.println(Arrays.toString(numbers));
        
    }
    
    public static Integer[] getRandomArrayOfInts(int size, int maxNumber){
        Random random = new Random();
        
        Integer[] numbers = new Integer[size];
        
        for ( int index = 0; index < numbers.length; index++ ){
            int number = random.nextInt(maxNumber)+1;
            numbers[index]= number;
            
        }
        
        return numbers;
    }
    

}
