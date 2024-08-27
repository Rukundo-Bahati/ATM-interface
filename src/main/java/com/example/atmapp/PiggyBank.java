package com.example.atmapp.model;

public class PiggyBank {

    private double balance = 1000.00; // Starting balance

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}
