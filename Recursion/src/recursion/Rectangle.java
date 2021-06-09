package recursion;

public class Rectangle implements Comparable<Rectangle> {

    private int length;
    private int width;


    public Rectangle(int length, int width) {
        setLength(length);
        setWidth(width);
    }


    public void setLength(int length) {
        if ( length <= 0){
            throw new IllegalArgumentException("Length cannot be 0 or less");
        }
        this.length = length;
    }

    public void setWidth(int width) {
        if ( width <= 0){
            throw new IllegalArgumentException("Width cannot be 0 or less");
        }
        this.width = width;
    }
    
       public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getArea() {
        return length * width;
    }

    @Override
    public int compareTo(Rectangle other) {
        return getArea() - other.getArea();
    }

}
