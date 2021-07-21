package project4;

import java.util.PriorityQueue;
import java.util.Random;

public class Project4 {

    public static void main(String[] args) {
        PriorityQueue<Person> queue = new PriorityQueue<>();
        Random random = new Random();

        boolean isSomeonesSandwichBeingMade = false;
        int timeOrderIsCompleted = -1;

        double totalTimeForNurses = 0;
        int numberOfNursesServed = 0;
        double totalTimeForDoctors = 0;
        int numberOfDoctorsServed = 0;
        double totalTimeForOthers = 0;
        int numberOfOthersServed = 0;

        Person beingServed = null;

        for (int minute = 0; minute < 120; minute++) {
            if (random.nextInt(3) == 0) {
                Person person = new Person();
                person.setTimeEnteredLine(minute);
                queue.add(person);
                System.out.println("New FTE entered the line: " + person + " at " + minute);
            }
            if (minute == timeOrderIsCompleted) {
                isSomeonesSandwichBeingMade = false;
                System.out.println("Completed sandwich for " + beingServed + " at " + minute);
            }
            if (!isSomeonesSandwichBeingMade && !queue.isEmpty()) {
                isSomeonesSandwichBeingMade = true;

                beingServed = queue.peek();
                queue.remove(beingServed);

                System.out.println("Started making sandwich for " + beingServed + " at " + minute);

                int numberOfTopping = random.nextInt(6);

                timeOrderIsCompleted = minute + numberOfTopping + 1;

                beingServed.setTimeOrderedWasReceived(timeOrderIsCompleted);

                if (beingServed.getType() == Person.Type.Nurse) {
                    totalTimeForNurses
                            += beingServed.getTimeOrderedWasReceived() - beingServed.getTimeEnteredLine();
                    numberOfNursesServed++;
                } else if (beingServed.getType() == Person.Type.Doctor) {
                    totalTimeForDoctors
                            += beingServed.getTimeOrderedWasReceived() - beingServed.getTimeEnteredLine();
                    numberOfDoctorsServed++;
                } else {
                    totalTimeForOthers
                            += beingServed.getTimeOrderedWasReceived() - beingServed.getTimeEnteredLine();
                    numberOfOthersServed++;
                }
            }
        }

        System.out.println("Cafe closed after 120 minutes");
        System.out.println("Total people served: "
                + (numberOfNursesServed + numberOfDoctorsServed + numberOfOthersServed));

        System.out.println("Total people not served: " + queue.size());

        System.out.println("Number of nurses serverd: " + numberOfNursesServed);
        System.out.println("Average time from entering line to getting sandwich for nurses "
                + totalTimeForNurses / numberOfNursesServed);
        System.out.println("Number of doctors serverd: " + numberOfDoctorsServed);
        System.out.println("Average time from entering line to getting sandwich for doctors "
                + totalTimeForDoctors / numberOfDoctorsServed);
        System.out.println("Number of others serverd: " + numberOfOthersServed);
        System.out.println("Average time from entering line to getting sandwich for others "
                + totalTimeForOthers / numberOfOthersServed);

    }

}
