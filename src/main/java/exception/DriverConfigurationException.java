package exception;

public class DriverConfigurationException extends Exception {
    public DriverConfigurationException() {
    }

    public DriverConfigurationException(String message) {
        super(message);
    }

    public DriverConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DriverConfigurationException(Throwable cause) {
        super(cause);
    }
}
