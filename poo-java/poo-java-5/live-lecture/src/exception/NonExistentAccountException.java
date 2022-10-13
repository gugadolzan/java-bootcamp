package exception;

public class NonExistentAccountException extends Exception {

    public NonExistentAccountException(String message) {
        super(message);
    }

}
