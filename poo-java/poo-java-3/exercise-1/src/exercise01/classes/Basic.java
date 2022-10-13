package exercise01.classes;

import exercise01.interfaces.BalanceInquiry;
import exercise01.interfaces.CashWithdrawal;
import exercise01.interfaces.ServicePayment;

public class Basic implements BalanceInquiry, ServicePayment, CashWithdrawal {

    @Override
    public void getBalance() {
        System.out.println("Balance: 0");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdraw: " + amount);
    }

    @Override
    public void payService(double amount) {
        System.out.println("Pay service: " + amount);
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
