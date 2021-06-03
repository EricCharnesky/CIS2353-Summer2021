package interhitanceandpolymorphism;

import java.util.ArrayList;
import java.util.Scanner;

public class InterhitanceAndPolymorphism {

    public static void main(String[] args) {


        Rectangle rectangle = new Rectangle();
        rectangle.setSideLength(0, 2);
        rectangle.setWidth(4);

        Square square = new Square(4);
        

        System.out.println(rectangle);
        System.out.println(square);
        
        
        ArrayList<Polygon> shapes = new ArrayList<>();
        shapes.add(rectangle);
        shapes.add(square);
        
        Scanner keyboard = new Scanner(System.in);
        
        for ( Polygon shape : shapes ){
            System.out.println("Enter side length for side 0");
            int length = Integer.parseInt(keyboard.nextLine());
            shape.setSideLength(0, length);
            System.out.println(shape);
            
            
        }
        
        
    }

}
