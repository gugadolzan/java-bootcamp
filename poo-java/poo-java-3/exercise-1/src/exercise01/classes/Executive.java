package exercise01.classes;

import exercise01.interfaces.Deposit;
import exercise01.interfaces.Transfer;

public class Executive implements Deposit, Transfer {

    @Override
    public void deposit(double amount) {
        System.out.println("Deposit: " + amount);
    }

    @Override
    public void successfulTransaction(String transactionType) {
        System.out.println("Successful " + transactionType);
    }

    @Override
    public void failedTransaction(String transactionType) {
        System.out.println("Failed " + transactionType);
    }

    @Override
    public void transfer(double amount) {
        System.out.println("Transfer: " + amount);
    }

}
