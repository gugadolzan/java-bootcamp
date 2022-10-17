package br.com.dh.testing03.controller;

import br.com.dh.testing03.dto.TransfDTO;
import br.com.dh.testing03.exception.InvalidNumberException;
import br.com.dh.testing03.exception.NonExistentAccountException;
import br.com.dh.testing03.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping("/transf/{origin}/{destination}/{value}")
    public ResponseEntity<TransfDTO> transfer(
        @PathVariable int origin,
        @PathVariable int destination,
        @PathVariable double value
    ) throws NonExistentAccountException, InvalidNumberException {
        TransfDTO transfDTO = service.transfer(origin, destination, value);

        return new ResponseEntity<>(transfDTO, HttpStatus.OK);
    }
}
