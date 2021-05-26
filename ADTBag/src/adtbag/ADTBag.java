package adtbag;

import java.util.ArrayList;

public class ADTBag {

    public static void main(String[] args) {

        ArrayList<Item> items = new ArrayList<>();
        
        Item item = new Item();
        
        items.add(item);
        
        // doesn't work - not the right type
        // items.add("new item");
        
        ArrayList<Object> objects = new ArrayList<>();
        
        objects.add(item);
        objects.add("new item");
        objects.add(42);
        

        // with generics, you get compile time checking of the T type
        GenericTest<String> course = new GenericTest<>("CIS", "2353");
        System.out.println(course);

        // with objects, everything is an object 
        ObjectTest otherCourse = new ObjectTest("CIS", "2151");

        System.out.println(otherCourse);

        BagInterface<String> names = new BagArray<>(10);

        names.add("Eric");
        names.add("Jasmine");
        names.add("Joy");
        names.add("Jeb");
        names.add("Jenavieve");
        names.add("Journey");
        names.add("Jubilee");
        names.add("Eric");
        
        // this should work with String[] - not sure why it's not
        Object[] result = names.toArray();
        
        for( Object name : result){
            System.out.println(name);
        }
        
        System.out.println(names.getFrequencyOf("Eric"));
        
        
        BagLinkedObjects<String> linkedNames = new BagLinkedObjects<>();
        linkedNames.add("Eric");
        linkedNames.add("Jasmine");
        linkedNames.add("Joy");
        linkedNames.add("Jeb");
        linkedNames.add("Jenavieve");
        linkedNames.add("Journey");
        linkedNames.add("Jubilee");
        linkedNames.add("Eric");
        
        // this should work with String[] - not sure why it's not
        result = linkedNames.toArray();
        
        for( Object name : result){
            String actuallyThisTypePlease = (String)name;
            System.out.println(actuallyThisTypePlease);
        }
    }

}
