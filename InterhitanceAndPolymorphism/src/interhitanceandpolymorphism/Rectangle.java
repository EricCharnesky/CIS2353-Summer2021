package interhitanceandpolymorphism;

public class Rectangle extends Polygon {
    
    public Rectangle() {
        super(4);
    }
    
    public int getArea(){
        return getSideLength(0) * getSideLength(1);
    }
    
    @Override
    public void setSideLength(int sideIndex, int length) {
        if (sideIndex == 0 || sideIndex == 2) {
            setLength(length);
        }
        if (sideIndex == 1 || sideIndex == 3) {
            setWidth(length);
        }
    }
    
    public void setLength(int length) {
        super.setSideLength(0, length);
        super.setSideLength(2, length);
    }
    
    public void setWidth(int width) {
        super.setSideLength(1, width);
        super.setSideLength(3, width);
    }
    
    @Override
    public String toString(){
        return String.format("Rectangle with a perimeter of %d and an area of %d", 
                getPerimeter(), getArea());
    }
    
}
