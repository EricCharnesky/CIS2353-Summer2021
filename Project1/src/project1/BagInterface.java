
package project1;

// copied from https://github.com/EricCharnesky/CIS2353-Summer2021/blob/main/ADTBag/src/adtbag/BagInterface.java

public interface BagInterface<T> {
    public int getCurrentSize();
    public boolean isEmpty();
    public boolean add(T item);
    public T remove();
    public boolean remove(T item);
    public void clear();
    public int getFrequencyOf(T item);
    public boolean contains(T item);
    public T[] toArray();
}
