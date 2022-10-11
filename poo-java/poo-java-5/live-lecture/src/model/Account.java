package model;

import exception.InvalidNumberException;

public abstract class Account {
    private final int number;
    private double balance;
    private final Client client;

    public Account(int number, Client client) {
        this.number = number;
        this.client = client;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double value) throws InvalidNumberException {
        if (value <= 0) {
            throw new InvalidNumberException("Invalid value");
        }
        this.balance += value;
    }

    public boolean withdraw(double value) throws InvalidNumberException {
        if (value <= 0) {
            throw new InvalidNumberException("Invalid value");
        }
        this.balance -= value;
        return true;
    }

    @Override
    public String toString() {
        return "number=" + number +
                ", balance=" + balance +
                ", client=" + client;
    }
}
