package br.com.dh.spring03.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerExceptions {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handleNotFoundException(NotFoundException e) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Object Not Found")
                .status(HttpStatus.NOT_FOUND.value())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

}
