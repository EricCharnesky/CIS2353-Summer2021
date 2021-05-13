package javareview;

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

    }

}
