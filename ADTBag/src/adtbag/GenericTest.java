
package adtbag;

public class GenericTest<T> {

    private T first;
    private T second;

    public GenericTest(T first, T second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return String.format("first: %s - second: %s", 
                first.toString(), second.toString());
    }

}
