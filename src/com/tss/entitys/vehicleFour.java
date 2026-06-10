package com.tss.entitys;

public class vehicleFour extends VehicleAll{
    private int numberOfDoors;


    public vehicleFour( String model, int year, String color, int numberOfDoors) {
        super( model, year, color);
        this.numberOfDoors = numberOfDoors;
    }


    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    public String toString() {

        return  " Model: " + getModel() +
                ", Year: " + getYear() + ", Color: " + getColor() +
                ", Number of Doors: " + numberOfDoors;
    }
}
