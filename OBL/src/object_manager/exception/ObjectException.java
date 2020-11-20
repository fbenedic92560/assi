package object_manager.exception;

/**
 *
 * @author martellocauda
 */
public class ObjectException extends Exception {

    public ObjectException(String message) {
        super(message);
    }

    public ObjectException(String message, Throwable cause) {
        super(message, cause);
    }
}