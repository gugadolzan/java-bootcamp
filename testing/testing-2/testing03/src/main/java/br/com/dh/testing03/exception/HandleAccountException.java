package br.com.dh.testing03.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleAccountException {

    @ExceptionHandler(NonExistentAccountException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(
        NonExistentAccountException ex
    ) {
        ExceptionDetails exceptionDetails = ExceptionDetails
            .builder()
            .title("Account not found")
            .message(ex.getMessage())
            .status(HttpStatus.NOT_FOUND.value())
            .timestamp(LocalDateTime.now())
            .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<ExceptionDetails> handlerInsufficientSaldoException(
        InsufficientBalanceException ex
    ) {
        ExceptionDetails exceptionDetails = ExceptionDetails
            .builder()
            .title("Insufficient balance")
            .message(ex.getMessage())
            .status(HttpStatus.BAD_REQUEST.value())
            .timestamp(LocalDateTime.now())
            .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }
}
