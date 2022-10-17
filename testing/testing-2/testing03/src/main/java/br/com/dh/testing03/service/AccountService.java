package br.com.dh.testing03.service;

import br.com.dh.testing03.dao.AccountDAO;
import br.com.dh.testing03.dto.TransfDTO;
import br.com.dh.testing03.exception.InvalidNumberException;
import br.com.dh.testing03.exception.NonExistentAccountException;
import br.com.dh.testing03.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountDAO dao;

    public TransfDTO transfer(
        int originAccountNumber,
        int destinationAccountNumber,
        double value
    ) throws NonExistentAccountException, InvalidNumberException {
        Account originAccount = dao.getAccount(originAccountNumber);
        Account destinationAccount = dao.getAccount(destinationAccountNumber);

        boolean successfulWithdraw = originAccount.withdraw(value);

        if (successfulWithdraw) {
            destinationAccount.deposit(value);
        }

        dao.updateAccount(originAccount);
        dao.updateAccount(destinationAccount);

        return new TransfDTO(originAccount, destinationAccount);
    }
}
