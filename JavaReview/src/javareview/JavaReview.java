package javareview;

import java.util.ArrayList;

public class JavaReview {

    public static void main(String[] args) {
        Vehicle transit = new Vehicle("blue", 5.95, 90.8);

        System.out.println(transit);

        if (transit.addFuel(transit.getFuelTankCapacityInLiters())) {
            System.out.println("You added " + 
                    transit.getFuelTankCapacityInLiters() + " liters!");
        } else {
            System.out.println("You spilled the gas you idiot!");
        }

        System.out.println(transit);

        if (transit.drive(48)) {
            System.out.println("You drove to Ann Arbor!");
        } else {
            System.out.println("You ran out of gas you idiot!");
        }

        System.out.println(transit);

        System.out.println("driving home");
        if (transit.drive(48)) {
            System.out.println("You drove Home!");
        } else {
            System.out.println("You ran out of gas you idiot!");
        }
        
        System.out.println(transit);
        
        
        ArrayList<String> kids;
        kids = new ArrayList<>();
        
        kids.add("Joy");
        kids.add("Jeb");
        kids.add("Jenavieve");
        kids.add("Journey");
        kids.add("Jubilee");
        kids.add("Jackson");
        
        String[] kidsArray = new String[6];
        kidsArray[0] = "Joy";
        kidsArray[1] = "Jeb";
        kidsArray[2] = "Vivi";
        kidsArray[3] = "Journey";
        kidsArray[4] = "Jubilee";
        kidsArray[5] = "Jack";
        
        for ( int index = 0; index < kids.size(); index++ ){
            System.out.println(kids.get(index));
        }
        
        for ( String kid : kids ){
            System.out.println(kid);
        }
        
        for ( int index = 0; index < kidsArray.length; index++ ){
            System.out.println(kidsArray[index]);
        }
        
        for ( String kid : kidsArray ){
            System.out.println(kid);
        }
        

    }

}
