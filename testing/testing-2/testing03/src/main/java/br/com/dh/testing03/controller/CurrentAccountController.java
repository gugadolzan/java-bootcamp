package br.com.dh.testing03.controller;

import br.com.dh.testing03.dto.AccountDTO;
import br.com.dh.testing03.exception.InsufficientBalanceException;
import br.com.dh.testing03.exception.InvalidNumberException;
import br.com.dh.testing03.exception.NonExistentAccountException;
import br.com.dh.testing03.model.CurrentAccount;
import br.com.dh.testing03.service.CurrentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/current-accounts")
public class CurrentAccountController {

    @Autowired
    private CurrentAccountService service;

    @GetMapping("/{number}")
    public ResponseEntity<CurrentAccount> getAccount(@PathVariable int number)
        throws NonExistentAccountException {
        CurrentAccount currentAccount = service.getAccount(number);

        return new ResponseEntity<>(currentAccount, HttpStatus.OK);
    }

    @PostMapping("/{client}")
    public ResponseEntity<CurrentAccount> newCurrentAccount(
        @PathVariable String client
    ) {
        CurrentAccount newCurrentAccount = service.newCurrentAccount(client);

        return new ResponseEntity<>(newCurrentAccount, HttpStatus.CREATED);
    }

    @PatchMapping("/dep/{number}/{value}")
    public ResponseEntity<CurrentAccount> deposit(
        @PathVariable int number,
        @PathVariable double value
    ) throws NonExistentAccountException, InvalidNumberException {
        CurrentAccount cc = service.getAccount(number);
        service.deposit(number, value);
        return new ResponseEntity<>(cc, HttpStatus.OK);
    }

    @PatchMapping("/withdraw/{number}/{value}")
    public ResponseEntity<CurrentAccount> withdraw(
        @PathVariable int number,
        @PathVariable double value
    )
        throws NonExistentAccountException, InvalidNumberException, InsufficientBalanceException {
        CurrentAccount cc = service.getAccount(number);
        if (service.withdraw(number, value)) {
            return new ResponseEntity<>(cc, HttpStatus.OK);
        }
        throw new InsufficientBalanceException("Insufficient balance");
    }

    @PostMapping("/new")
    public ResponseEntity<CurrentAccount> newCurrentAccountBody(
        @RequestBody AccountDTO accountDTO
    ) {
        CurrentAccount newCurrentAccount = service.newCurrentAccount(
            accountDTO.getClient()
        );

        return new ResponseEntity<>(newCurrentAccount, HttpStatus.CREATED);
    }
}
