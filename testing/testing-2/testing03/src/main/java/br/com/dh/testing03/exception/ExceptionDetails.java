package br.com.dh.testing03.exception;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionDetails {

    private String title;
    private int status;
    private String message;
    private LocalDateTime timestamp;
}
