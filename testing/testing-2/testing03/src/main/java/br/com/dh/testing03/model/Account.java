package br.com.dh.testing03.model;

import br.com.dh.testing03.exception.InvalidNumberException;
import lombok.Getter;

@Getter
public abstract class Account implements Comparable<Account> {

    private final int number;
    private double balance;
    private final String client;

    public Account(int number, String client) {
        this.number = number;
        this.client = client;
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
        return (
            "number=" + number + ", balance=" + balance + ", client=" + client
        );
    }

    @Override
    public int compareTo(Account account) {
        if (this.balance > account.getBalance()) {
            return 1;
        } else if (this.balance < account.getBalance()) {
            return -1;
        }
        return 0;
    }
}
