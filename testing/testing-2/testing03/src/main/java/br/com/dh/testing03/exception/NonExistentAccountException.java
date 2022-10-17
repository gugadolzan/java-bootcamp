package br.com.dh.testing03.exception;

public class NonExistentAccountException extends Exception {

    public NonExistentAccountException(String message) {
        super(message);
    }
}
