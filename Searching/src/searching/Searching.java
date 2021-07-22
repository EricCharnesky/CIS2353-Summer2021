package searching;

import java.util.Random;

public class Searching {

    public static void main(String[] args) {
        testSearchesOnSizeN(1_000);
        testSearchesOnSizeN(10_000);
        testSearchesOnSizeN(100_000);
        testSearchesOnSizeN(1_000_000);
        testSearchesOnSizeN(10_000_000);
        testSearchesOnSizeN(100_000_000);
    }

    static void testSearchesOnSizeN(int size) {
        Random random = new Random();

        Integer[] values = new Integer[size];

        for (int index = 0; index < size; index++) {
            values[index] = index;
        }

        int randomNumber = random.nextInt(size);
        System.out.println("Searching for " + randomNumber + " out of " + size + " values");
        System.out.println(randomNumber + " is at index: " + sortedSearch(values, randomNumber));
        System.out.println(randomNumber + " is at index: " + unsortedSearch(values, randomNumber));
        
    }

    // average O(n)
    public static <T extends Comparable<? super T>> int unsortedSearch(T[] collection, T item) {
        for (int index = 0; index < collection.length; index++) {
            if (item.compareTo(collection[index]) == 0) {
                return index;
            }
        }
        return -1;
    }

    public static <T extends Comparable<? super T>> int sortedSearch(T[] collection, T item) {
        int startIndex = 0;
        int endIndex = collection.length - 1;

        while (startIndex <= endIndex) {
            int middleIndex = (endIndex + startIndex) / 2;

            int comparisionResult = item.compareTo(collection[middleIndex]);
            if (comparisionResult == 0) {
                return middleIndex;
            } else if (comparisionResult < 0) {
                endIndex = middleIndex - 1;
            } else {
                startIndex = middleIndex + 1;
            }
        }

        return -1;
    }

}
