package exercise01.interfaces;

public interface Transaction {
    void successfulTransaction(String transactionType);
    void failedTransaction(String transactionType);
}
