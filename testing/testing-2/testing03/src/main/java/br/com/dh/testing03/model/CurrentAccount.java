package br.com.dh.testing03.model;

import br.com.dh.testing03.exception.InvalidNumberException;

public class CurrentAccount extends Account {

    public CurrentAccount(int number, String client) {
        super(number, client);
    }

    private boolean hasEnoughBalance(double value) {
        return getBalance() >= value;
    }

    @Override
    public boolean withdraw(double value) throws InvalidNumberException {
        if (!hasEnoughBalance(value)) {
            return false;
        }
        return super.withdraw(value);
    }

    @Override
    public String toString() {
        return "Current Account: " + super.toString();
    }
}
