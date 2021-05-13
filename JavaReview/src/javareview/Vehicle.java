package javareview;

public class Vehicle {

    private String color;
    private double kilometersPerLiter;
    private double fuelTankCapacityInLiters;
    private double currentFuelInTankInLiters;

    public Vehicle(String color, double kilometersPerLiter, double fuelTankCapacityInLiters) {
        this.color = color;
        this.kilometersPerLiter = kilometersPerLiter;
        this.fuelTankCapacityInLiters = fuelTankCapacityInLiters;
        currentFuelInTankInLiters = 0;
    }

    public boolean drive(double kilometersToDrive) {
        if (kilometersToDrive < 0) {
            return false;
        }

        double litersUsed = kilometersToDrive / kilometersPerLiter;

        currentFuelInTankInLiters -= litersUsed;

        if (currentFuelInTankInLiters < 0) {
            currentFuelInTankInLiters = 0;
            return false;
        }

        return true;
    }

    public boolean addFuel(double fuelToAddInLiters) {
        if (fuelToAddInLiters < 0) {
            return false;
        }

        currentFuelInTankInLiters += fuelToAddInLiters;

        if (currentFuelInTankInLiters > fuelTankCapacityInLiters) {
            currentFuelInTankInLiters = fuelTankCapacityInLiters;
            return false;
        }

        return true;
    }

    public String getColor() {
        return color;
    }

    public double getKilometersPerLiter() {
        return kilometersPerLiter;
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

    @Override
    public String toString() {
        return String.format("%s color vehicle with %.1f liters of fuel left",
                color, currentFuelInTankInLiters);
    }

}
