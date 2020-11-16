package Labeling.Exceptions;

/**
 *
 * @author martellocauda
 */
public class AccessLevelException extends Exception {

    public AccessLevelException(String message) {
        super(message);
    }

    public AccessLevelException(String message, Throwable cause) {
        super(message, cause);
    }
}