package exception;

/**
 *
 * @author martellocauda
 */
public class SubjectException extends Exception {

    public SubjectException(String message) {
        super(message);
    }

    public SubjectException(String message, Throwable cause) {
        super(message, cause);
    }
}