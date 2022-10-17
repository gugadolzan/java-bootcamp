package br.com.dh.testing03.dao;

import br.com.dh.testing03.exception.NonExistentAccountException;
import br.com.dh.testing03.model.*;
import br.com.dh.testing03.util.NumberGenerator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

    NumberGenerator numberGenerator;
    private final Map<Integer, Account> accounts;

    public AccountDAO() {
        accounts = new HashMap<>();
        numberGenerator = NumberGenerator.getInstance();
    }

    public CurrentAccount newCurrentAccount(String client) {
        int accountNumber = numberGenerator.getNextNumber();
        CurrentAccount currentAccount = new CurrentAccount(
            accountNumber,
            client
        );
        accounts.put(accountNumber, currentAccount);
        return currentAccount;
    }

    public void newSpecialAccount(String client, double limit) {
        int accountNumber = numberGenerator.getNextNumber();
        accounts.put(
            accountNumber,
            new SpecialAccount(accountNumber, client, limit)
        );
    }

    public void newSavingsAccount(String client) {
        int accountNumber = numberGenerator.getNextNumber();
        accounts.put(accountNumber, new SavingsAccount(accountNumber, client));
    }

    public Account getAccount(int accountNumber)
        throws NonExistentAccountException {
        Account account = accounts.get(accountNumber);

        if (account != null) {
            return account;
        }

        throw new NonExistentAccountException(
            "Account " + accountNumber + " does not exist."
        );
    }

    public CurrentAccount getCurrentAccount(int accountNumber)
        throws NonExistentAccountException {
        Account account = accounts.get(accountNumber);

        if (account instanceof CurrentAccount) {
            return (CurrentAccount) account;
        }

        throw new NonExistentAccountException("Current account does not exist");
    }

    public SpecialAccount getSpecialAccount(int accountNumber)
        throws NonExistentAccountException {
        Account account = accounts.get(accountNumber);

        if (account instanceof SpecialAccount) {
            return (SpecialAccount) account;
        }

        throw new NonExistentAccountException("Special account does not exist");
    }

    public SavingsAccount getSavingsAccount(int accountNumber)
        throws NonExistentAccountException {
        Account account = accounts.get(accountNumber);

        if (account instanceof SavingsAccount) {
            return (SavingsAccount) account;
        }

        throw new NonExistentAccountException("Savings account does not exist");
    }

    public boolean updateAccount(Account account)
        throws NonExistentAccountException {
        Account accountToUpdate = accounts.get(account.getNumber());
        if (accountToUpdate == null) {
            throw new NonExistentAccountException(
                "Account " + account.getNumber() + " does not exist."
            );
        }
        accounts.put(account.getNumber(), account);
        return true;
    }

    public String getAccountData(int accountNumber)
        throws NonExistentAccountException {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new NonExistentAccountException(
                "Account " + accountNumber + " does not exist."
            );
        }
        return account.toString();
    }

    public void remove(int accountNumber) throws NonExistentAccountException {
        Account account = accounts.remove(accountNumber);
        if (account == null) {
            throw new NonExistentAccountException(
                "Account " + accountNumber + " does not exist."
            );
        }
    }

    public void deleteAll() {
        accounts.clear();
    }

    public List<String> getAllAccounts() {
        return accounts
            .values()
            .stream()
            .map(c -> c.toString() + "\n")
            .collect(Collectors.toList());
    }

    public List<String> getCurrentAccountsByNumber() {
        return accounts
            .values()
            .stream()
            .filter(c -> c instanceof CurrentAccount)
            .sorted(Comparator.comparingInt(Account::getNumber))
            .map(Account::toString)
            .collect(Collectors.toList());
    }

    public List<String> getCurrentAccountsByBalance() {
        return accounts
            .values()
            .stream()
            .filter(c -> c instanceof CurrentAccount)
            .sorted(Comparator.reverseOrder())
            .map(Account::toString)
            .collect(Collectors.toList());
    }

    public List<String> getAllSpecialAccountsWithNegativeBalance() {
        return accounts
            .values()
            .stream()
            .filter(c -> c instanceof SpecialAccount)
            .filter(c -> c.getBalance() < 0)
            .sorted(Comparator.reverseOrder())
            .map(Account::toString)
            .collect(Collectors.toList());
    }
}
