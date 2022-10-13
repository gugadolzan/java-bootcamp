package exercise01.classes;

import exercise01.interfaces.BalanceInquiry;
import exercise01.interfaces.CashWithdrawal;

public class Collector implements CashWithdrawal, BalanceInquiry {

    @Override
    public void getBalance() {
        System.out.println("Balance: 0");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdraw: " + amount);
    }

    @Override
    public void successfulTransaction(String transactionType) {
        System.out.println("Successful " + transactionType);
    }

    @Override
    public void failedTransaction(String transactionType) {
        System.out.println("Failed " + transactionType);
    }

}
