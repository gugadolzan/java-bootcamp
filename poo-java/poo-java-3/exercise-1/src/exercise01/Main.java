package exercise01;

import exercise01.classes.Basic;
import exercise01.classes.Collector;
import exercise01.classes.Executive;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Executive ===");
        Executive executive = new Executive();

        executive.deposit(1000.0);
        executive.successfulTransaction("Deposit");

        executive.transfer(500.0);
        executive.failedTransaction("Transfer");

        System.out.println("\n=== Basic ===");
        Basic basic = new Basic();

        basic.getBalance();
        basic.successfulTransaction("Get Balance");

        basic.payService(100.0);
        basic.failedTransaction("Pay Service");

        System.out.println("\n=== Collector ===");
        Collector collector = new Collector();

        collector.withdraw(2000.0);
        collector.successfulTransaction("Withdraw");

        collector.getBalance();
        collector.failedTransaction("Get Balance");
    }

}
