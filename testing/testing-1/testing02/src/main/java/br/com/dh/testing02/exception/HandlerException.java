package br.com.dh.testing02.exception;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request
    ) {
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();

        return new ResponseEntity<>(
            ExceptionDetails
                .builder()
                .title("Invalid fields")
                .message("The fields are invalid")
                .fields(
                    errors
                        .stream()
                        .map(FieldError::getField)
                        .collect(Collectors.joining(";"))
                )
                .fieldsMessages(
                    errors
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .collect(Collectors.joining(";"))
                )
                .timestamp(LocalDateTime.now())
                .build(),
            status
        );
    }
}
