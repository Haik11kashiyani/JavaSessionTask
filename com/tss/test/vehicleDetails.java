package com.tss.test;
import com.tss.entitys.vehicleFour;
import com.tss.entitys.vehicleTwo;

import java.util.Scanner;

import static com.tss.Validation.ValidationForAll.*;
public class vehicleDetails {
    public static void main(String[] args) {
        int choice=0;
        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.println("1. Two vehicle" +
                    "2. Four vehicle" +
                    "3. exit");
            choice=inputInteger();
            if (choice==1)
            {
                System.out.println("enter the vehicle details ");
                System.out.println("enter the  model name :");
                String make=inputString();

                System.out.println("enter the  model year :");
                int year=inputInteger();

                System.out.println("enter the  vehicle color :");
                String color=inputString();
                vehicleTwo bike = new vehicleTwo(make,year,color);

                System.out.println(bike);
            } else if (choice==2) {

                System.out.println("enter the vehicle details ");
                System.out.println("enter the  model name :");
                String make=inputString();

                System.out.println("enter the  model year :");
                int year=inputInteger();

                System.out.println("enter the  vehicle color :");
                String color=inputString();

                System.out.println("enter the  Number of doors :");
                int doors=inputInteger();

                vehicleFour fourvehicle = new vehicleFour(make,year,color,doors);

                System.out.println(fourvehicle);
            } else if (choice==3) {
                break;

            }else {
                System.out.println("invalid input");
            }
        }
    }
}
