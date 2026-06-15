package com.tss.entitys;

public class vehicleTwo extends VehicleAll{
    private boolean hasKickStart;


    public vehicleTwo( String model, int year, String color) {
        super( model, year, color);

    }


    public String toString() {

        return  " Model: " + getModel() +
                ", Year: " + getYear() + ", Color: " + getColor();
    }

    public static class boxMain  extends Box {
        public void initiation()
        {
            width=20;
            depth=30;
            height=50;
        }
    }
}
