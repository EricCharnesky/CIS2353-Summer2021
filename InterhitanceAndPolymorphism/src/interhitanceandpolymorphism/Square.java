
package interhitanceandpolymorphism;


public class Square extends Rectangle {
    
    public Square(int length){
        setLength(length);
    }
    
    @Override
    public void setSideLength(int sideIndex, int length){
        setLength(length);
    }
    
    @Override
    public void setWidth(int width){
        setLength(width);
    }
    
    @Override
    public void setLength(int length){
        super.setWidth(length);
        super.setLength(length);
    }
    
    @Override
    public String toString(){
        return String.format("Square with a perimeter of %d and an area of %d", 
                getPerimeter(), getArea());
    }
    
}
