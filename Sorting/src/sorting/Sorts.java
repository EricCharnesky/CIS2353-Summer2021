package sorting;

import java.util.Arrays;

public class Sorts {

    public static <T extends Comparable<? super T>> void SelectionSort(T[] data) {
        for (int index = 0; index < data.length - 1; index++) {
            int smallestIndex = index;
            for (int indexToCheckIfIsSmaller = smallestIndex + 1; indexToCheckIfIsSmaller < data.length; indexToCheckIfIsSmaller++) {
                if (data[indexToCheckIfIsSmaller].compareTo(data[smallestIndex]) < 0) {
                    smallestIndex = indexToCheckIfIsSmaller;
                }
            }
            T temp = data[index];
            data[index] = data[smallestIndex];
            data[smallestIndex] = temp;

            System.out.println(Arrays.toString(data));
        }
    }

    public static <T extends Comparable<? super T>> void InsertionSort(T[] data) {
        for (int index = 1; index < data.length; index++) {
            int indexToCheck = index;
            while (indexToCheck > 0
                    && data[indexToCheck].compareTo(data[indexToCheck - 1]) < 0) {
                T temp = data[indexToCheck];
                data[indexToCheck] = data[indexToCheck - 1];
                data[indexToCheck - 1] = temp;
                indexToCheck--;
            }
            System.out.println(Arrays.toString(data));
        }
    }
}
