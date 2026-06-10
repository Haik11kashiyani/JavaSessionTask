package com.tss.entitys;

public class BankCurrent extends BankAccount {

    private static final double OVERDRAFT_LIMIT = 5000.00;

    public BankCurrent(String name, double balance) {
        super(name, balance);
        setAccountType("Current account");
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return false;
        }
        double available = getBalance() + OVERDRAFT_LIMIT;
        if (amount > available) {
            System.out.println("Withdraw declined. Current account overdraft limit is " + OVERDRAFT_LIMIT);
            System.out.println("Available amount including overdraft: " + available);
            return false;
        }
        setBalance(getBalance() - amount);
        if (getBalance() < 0) {
            System.out.println("Overdraft used: " + (-getBalance()));
        }
        return true;
    }

    public double getOverdraftLimit() {
        return OVERDRAFT_LIMIT;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }

        if (getBalance() < 0) {
            // Account is in overdraft
            double overdraftUsed = -getBalance();
            double towardsClearingOverdraft = Math.min(amount, overdraftUsed);
            System.out.println("Clearing overdraft: " + towardsClearingOverdraft);
            setBalance(getBalance() + towardsClearingOverdraft);

            double remaining = amount - towardsClearingOverdraft;
            if (remaining > 0) {
                System.out.println("Adding to account: " + remaining);
                setBalance(getBalance() + remaining);
            }
        } else {
            // Normal deposit
            System.out.println("Adding to account: " + amount);
            setBalance(getBalance() + amount);
        }
    }
}
