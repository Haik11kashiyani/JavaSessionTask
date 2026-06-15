package com.tss.Validation;

import java.util.Scanner;

public class ValidationForAll {
    public static <t> boolean stringValid(t data) {
        boolean result = false;
        String datatype = data.getClass().getSimpleName();
        if (datatype.equals("String")) {
            result = true;
        }

        return result;
    }

    public static <t> boolean intValid(t data) {
        boolean result = false;
        String datatype = data.getClass().getSimpleName();
        if (datatype.equals("Integer") || datatype.equals("Double") || datatype.equals("Float")) {
            result = true;
        }

        return result;
    }

    public static String inputString() {

        String fristInput;
        Scanner scanner = new Scanner(System.in);
        while (true)
            try {
                fristInput = scanner.nextLine();
                return fristInput;

        } catch (Exception e) {
            System.out.println("Enter valid strings");
        }

    }
    public static int inputInteger() {

        int fristInput;
        Scanner scanner = new Scanner(System.in);
        while (true)
            try {
                fristInput = scanner.nextInt();
                scanner.nextLine();
                return fristInput;


                } catch (Exception e) {
                    System.out.println("Enter valid numbers only :");
                scanner.nextLine();
            }
    }

}