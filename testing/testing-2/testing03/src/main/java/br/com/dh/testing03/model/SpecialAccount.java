package br.com.dh.testing03.model;

import br.com.dh.testing03.exception.InvalidNumberException;

public class SpecialAccount extends Account {

    private final double limit;

    public SpecialAccount(int number, String client, double limit) {
        super(number, client);
        this.limit = limit;
    }

    private boolean hasEnoughBalance(double value) {
        return getBalance() + limit >= value;
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
        return "Special Account: " + super.toString();
    }
}
