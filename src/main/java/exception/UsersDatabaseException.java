package exception;

public class UsersDatabaseException extends Exception {
    public UsersDatabaseException() {
    }

    public UsersDatabaseException(String message) {
        super(message);
    }

    public UsersDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsersDatabaseException(Throwable cause) {
        super(cause);
    }
}
