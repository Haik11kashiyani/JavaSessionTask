package com.tss.entitys;

import java.util.Random;

public class BankAccount {

    private static int count = 1;
    private static final Random rand = new Random();

    private int id;
    private String name;
    private double balance;
    private long accountNumber;
    private String accountType;

    public BankAccount() {
        this.name = "Unknown";
        this.id = count++;
        this.accountNumber = rand.nextInt(99999999 - 10000000 + 1) + 10000000;
        this.balance = 500.00;
        this.accountType = "General";
    }

    public BankAccount(String name, double balance) {
        this.name = name;
        this.id = count++;
        this.balance = balance;
        this.accountNumber = rand.nextInt(99999999 - 10000000 + 1) + 10000000;
        this.accountType = "General";
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    protected void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        }
        balance -= amount;
        return true;
    }

    public void printAll() {
        System.out.println("Id           : " + id);
        System.out.println("Name         : " + name);
        System.out.println("Account type : " + accountType);
        System.out.println("Balance      : " + balance);
        System.out.println("Account no.  : " + accountNumber);
    }
}
