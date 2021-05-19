
package adtbag;


public class ObjectTest {
    private Object first;
    private Object second;

    public ObjectTest(Object first, Object second) {
        this.first = first;
        this.second = second;
    }
    
    @Override
    public String toString() {
        return String.format("first: %s - second: %s", 
                first.toString(), second.toString());
    }
}
