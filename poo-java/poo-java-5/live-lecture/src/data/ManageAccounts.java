package data;

import exception.InvalidNumberException;
import exception.NonExistentAccountException;
import model.*;
import util.NumberGenerator;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ManageAccounts {
    private final Map<Integer, Account> accounts;
    private final NumberGenerator numberGenerator;

    public ManageAccounts() {
        accounts = new HashMap<>();
        numberGenerator = NumberGenerator.getInstance();
    }

    public void addCurrentAccount(Client client) {
        int accountNumber = numberGenerator.getNextNumber();
        accounts.put(accountNumber, new CurrentAccount(accountNumber, client));
    }

    public void addSpecialAccount(Client client, double limit) {
        int accountNumber = numberGenerator.getNextNumber();
        accounts.put(accountNumber, new SpecialAccount(accountNumber, client, limit));
    }

    public void addSavingsAccount(Client client) {
        int accountNumber = numberGenerator.getNextNumber();
        accounts.put(accountNumber, new SavingsAccount(accountNumber, client));
    }

    public Account getAccount(int accountNumber) throws NonExistentAccountException {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new NonExistentAccountException("Account does not exist");
        }
        return account;
    }

    public void deposit(int accountNumber, double value) throws NonExistentAccountException,
            InvalidNumberException {
        Account account = getAccount(accountNumber);
        account.deposit(value);
    }

    public boolean withdraw(int accountNumber, double value) throws NonExistentAccountException,
            InvalidNumberException {
        Account account = getAccount(accountNumber);
        return account.withdraw(value);
    }

    public void transfer(int sourceAccountNumber, int destinationAccountNumber, double value)
            throws NonExistentAccountException, InvalidNumberException {
        Account sourceAccount = getAccount(sourceAccountNumber);
        Account destinationAccount = getAccount(destinationAccountNumber);

        boolean success = sourceAccount.withdraw(value);
        if (success) {
            destinationAccount.deposit(value);
        }
    }

    public void removeAccount(int accountNumber) throws NonExistentAccountException {
        Account account = getAccount(accountNumber);
        accounts.remove(accountNumber);
    }

    public boolean hasAccount(String cpf) {
        return accounts.values().stream()
                .anyMatch(account -> account.getClientCpf().equals(cpf));
    }

    public List<String> getAllAccountsInfo() {
        return accounts.values().stream()
                .map(c -> c.toString() + "\n")
                .collect(Collectors.toList());
    }

    public List<String> getCurrentAccountsSortedByNumber() {
        return accounts.values().stream()
                .filter(account -> account instanceof CurrentAccount)
//                .sorted((c1, c2) -> c1.getNumber() - c2.getNumber())
                .sorted(Comparator.comparingInt(Account::getNumber))
                .map(Account::toString)
                .collect(Collectors.toList());
    }

    public List<String> getCurrentAccountsSortedByBalance() {
        return accounts.values().stream()
                .filter(account -> account instanceof CurrentAccount)
//                .sorted((c1, c2) -> c2.compareTo(c1))
                .sorted(Comparator.reverseOrder())
                .map(Account::toString)
                .collect(Collectors.toList());
    }

    public List<String> getSpecialAccountsWithNegativeBalance() {
        return accounts.values().stream()
                .filter(account -> account instanceof SpecialAccount)
                .filter(account -> account.getBalance() < 0)
                .sorted(Comparator.reverseOrder())
                .map(Account::toString)
                .collect(Collectors.toList());
    }
}
