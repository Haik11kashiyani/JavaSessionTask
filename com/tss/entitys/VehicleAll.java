package com.tss.entitys;

public class VehicleAll {

    private String model;
    private int year;
    private String color;


    public VehicleAll( String model, int year, String color) {

        this.model = model;
        this.year = year;
        this.color = color;
    }




    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

}
