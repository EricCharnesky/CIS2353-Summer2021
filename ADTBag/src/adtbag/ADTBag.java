
package adtbag;

import java.util.ArrayList;

public class ADTBag {

    public static void main(String[] args) {
        
        // with generics, you get compile time checking of the T type
        GenericTest<String> course = new GenericTest<>("CIS", "2353");
        System.out.println(course);
        
        // with objects, everything is an object 
        ObjectTest otherCourse = new ObjectTest("CIS", "2151");
        
        System.out.println(otherCourse);
        
        BagInterface<String> names = new BagArray<>(10);
        
        
        
    }
    
}
