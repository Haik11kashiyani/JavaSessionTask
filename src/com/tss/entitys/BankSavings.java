package com.tss.entitys;

public class BankSavings extends BankAccount {

    private static final double MINIMUM_BALANCE = 500.00;

    public BankSavings(String name, double balance) {
        super(name, balance);
        setAccountType("Savings account");
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return false;
        }
        if (getBalance() - amount < MINIMUM_BALANCE) {
            System.out.println("Withdraw declined. Savings account must keep at least " + MINIMUM_BALANCE);
            System.out.println("Current balance: " + getBalance());
            return false;
        }
        return super.withdraw(amount);
    }
}
