package com.tss.test;

import com.tss.entitys.BankAccount;
import com.tss.entitys.BankCurrent;
import com.tss.entitys.BankSavings;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the account details");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        double openingBalance;
        while (true) {
            System.out.print("Enter the account opening balance (minimum 500): ");
            openingBalance = scanner.nextDouble();
            if (openingBalance < 500) {
                System.out.println("You cannot enter less than 500.");
            } else {
                break;
            }
        }

        BankAccount userAccount;
        while (true) {
            System.out.println("Choose account type:");
            System.out.println("1. Savings");
            System.out.println("2. Current");
            int accountType = scanner.nextInt();

            if (accountType == 1) {
                userAccount = new BankSavings(name, openingBalance);
                break;
            } else if (accountType == 2) {
                userAccount = new BankCurrent(name, openingBalance);
                break;
            } else {
                System.out.println("Invalid input. Please choose 1 or 2.");
            }
        }

        int choice;
        do {
            System.out.println("\nChoose operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance");
            System.out.println("4. Print information");
            System.out.println("5. Exit");
            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter the amount to deposit: ");
                double amount = scanner.nextDouble();
                userAccount.deposit(amount);
                System.out.println("Current balance: " + userAccount.getBalance());
            } else if (choice == 2) {
                System.out.print("Enter the amount to withdraw: ");
                double amount = scanner.nextDouble();
                if (userAccount.withdraw(amount)) {
                    System.out.println("Withdraw successful. Current balance: " + userAccount.getBalance());
                }
            } else if (choice == 3) {
                System.out.println("Current balance: " + userAccount.getBalance());
            } else if (choice == 4) {
                userAccount.printAll();
            } else if (choice == 5) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Enter a valid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
