package interhitanceandpolymorphism;

public abstract class Polygon {

    private int numberOfSides;
    protected int[] sideLengths; // protected gives access to child classes

    public Polygon(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        sideLengths = new int[numberOfSides];
    }
    
    public abstract int getArea();

    public int getNumberOfSides() {
        return numberOfSides;
    }

    public void setSideLength(int sideIndex, int sideLength) {
        sideLengths[sideIndex] = sideLength;
    }

    public int getSideLength(int sideIndex) {
        return sideLengths[sideIndex];
    }
    
    public int getPerimeter(){
        int perimeter = 0;
        for ( int sideLength : sideLengths){
            perimeter += sideLength;
        }
        return perimeter;
    }
    
    @Override
    public String toString(){
        return String.format("Polygon with %d sides with a perimeter of %d", 
                numberOfSides, getPerimeter());
    }

}
