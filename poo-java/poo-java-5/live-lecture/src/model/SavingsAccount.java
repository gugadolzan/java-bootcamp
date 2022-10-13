package model;

import exception.InvalidNumberException;

public class SavingsAccount extends Account {

    private static double fee = 0.1;

    public SavingsAccount(int number, Client client) {
        super(number, client);
    }

    public static double getFee() {
        return fee;
    }

    public static void setFee(double fee) {
        SavingsAccount.fee = fee;
    }

    private boolean hasEnoughBalance(double value) {
        return getBalance() >= value + fee;
    }

    @Override
    public boolean withdraw(double value) throws InvalidNumberException {
        if (!hasEnoughBalance(value)) {
            return false;
        }
        return super.withdraw(value + fee);
    }

    @Override
    public String toString() {
        return "Savings Account: " + super.toString();
    }

}
