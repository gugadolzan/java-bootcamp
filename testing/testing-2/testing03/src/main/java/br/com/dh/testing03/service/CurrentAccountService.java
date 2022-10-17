package br.com.dh.testing03.service;

import br.com.dh.testing03.dao.AccountDAO;
import br.com.dh.testing03.exception.InvalidNumberException;
import br.com.dh.testing03.exception.NonExistentAccountException;
import br.com.dh.testing03.model.Account;
import br.com.dh.testing03.model.CurrentAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrentAccountService {

    @Autowired
    private AccountDAO dao;

    public CurrentAccount newCurrentAccount(String client) {
        return dao.newCurrentAccount(client);
    }

    public CurrentAccount getAccount(int number)
        throws NonExistentAccountException {
        return dao.getCurrentAccount(number);
    }

    public boolean withdraw(int accountNumber, double value)
        throws NonExistentAccountException, InvalidNumberException {
        CurrentAccount account = dao.getCurrentAccount(accountNumber);

        if (account.withdraw(value)) {
            return dao.updateAccount(account);
        }

        return false;
    }

    public void deposit(int accountNumber, double value)
        throws NonExistentAccountException, InvalidNumberException {
        Account account = dao.getCurrentAccount(accountNumber);

        account.deposit(value);

        dao.updateAccount(account);
    }
}
