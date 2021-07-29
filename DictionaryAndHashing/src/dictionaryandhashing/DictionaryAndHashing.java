package dictionaryandhashing;

import java.util.HashMap;

public class DictionaryAndHashing {

    public static void main(String[] args) {
        //demo();
        
        HashMap<Integer, String> studentMap = new HashMap<>();
        
        
        ChainedDictionary<Integer, String> students = new ChainedDictionary<>();
        
        students.add(123, "Bob");
        students.add(124, "Jane");
        students.add(235, "Mary");
        students.add(450, "Quinn");
        
        System.out.println(students.getValue(124));
        System.out.println(students.getValue(200));
    }
    
    public static void demo(){
        Integer number = 42;
        String value = "testing";

        System.out.println("hash code for 42 is: " + number.hashCode());
        System.out.println("hash code for 'testing' is : " + value.hashCode());

        Object[] data = new Object[11];

        printData(data);

        addItem(data, number);

        printData(data);

        addItem(data, value);

        printData(data);

        System.out.println(containsItem(data, value));
        System.out.println(containsItem(data, "testing"));
        System.out.println(containsItem(data, 42));
        System.out.println(containsItem(data, 7));
    }

    private static void printData(Object[] data) {
        for (int index = 0; index < data.length; index++) {
            System.out.println(String.format("Index %d - %s", index, data[index]));
        }
    }

    public static boolean containsItem(Object[] data, Object item) {
        int indexPositionToPutItem = getIndexForObjectInData(data, item);
        return item.equals(data[indexPositionToPutItem]);

    }

    public static void addItem(Object[] data, Object item) {
        int indexPositionToPutItem = getIndexForObjectInData(data, item);
        data[indexPositionToPutItem] = item;
    }

    private static int getIndexForObjectInData(Object[] data, Object item) {
        int lengthOfDataStorage = data.length;
        int hashCodeOfItem = item.hashCode();
        if (hashCodeOfItem < 0) {
            hashCodeOfItem *= -1;
        }
        int indexPositionToPutItem = hashCodeOfItem % lengthOfDataStorage;
        return indexPositionToPutItem;
    }

}
