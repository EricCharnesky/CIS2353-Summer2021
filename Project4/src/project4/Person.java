package project4;

import java.util.Random;

public class Person implements Comparable<Person> {

    public enum Type {
        Nurse, Doctor, Other
    };

    private Type type;
    private int timeEnteredLine;
    private int timeOrderedWasReceived;

    public Person() {
        Random random = new Random();
        int value = random.nextInt(3);
        if (value == 0) {
            type = Type.Nurse;
        } else if (value == 1) {
            type = Type.Doctor;
        } else {
            type = Type.Other;
        }
    }

    public Type getType() {
        return type;
    }

    public int getTimeEnteredLine() {
        return timeEnteredLine;
    }

    public int getTimeOrderedWasReceived() {
        return timeOrderedWasReceived;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setTimeEnteredLine(int timeEnteredLine) {
        this.timeEnteredLine = timeEnteredLine;
    }

    public void setTimeOrderedWasReceived(int timeOrderedWasReceived) {
        this.timeOrderedWasReceived = timeOrderedWasReceived;
    }
    
    @Override
    public String toString()
    {
        return type.name();
    }

    @Override
    public int compareTo(Person other) {
        if ( type == other.type ){
            return timeEnteredLine - other.timeEnteredLine;
        }
        return type.ordinal() - other.type.ordinal();
    }

}
