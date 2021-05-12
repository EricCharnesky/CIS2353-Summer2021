package javareview;

public class Vehicle {

    private String color;
    private double maxMilesPerHour;
    private double fuelTankCapacityInLiters;
    private double currentFuelInTankInLiters;

    public Vehicle(String color, double maxMilesPerHour, double fuelTankCapacityInLiters) {
        this.color = color;
        this.maxMilesPerHour = maxMilesPerHour;
        this.fuelTankCapacityInLiters = fuelTankCapacityInLiters;
        currentFuelInTankInLiters = 0;
    }
    
    //public boolean 

    public String getColor() {
        return color;
    }

    public double getMaxMilesPerHour() {
        return maxMilesPerHour;
    }

    public double getFuelTankCapacityInLiters() {
        return fuelTankCapacityInLiters;
    }

    public double getCurrentFuelInTankInLiters() {
        return currentFuelInTankInLiters;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
