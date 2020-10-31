package ObjectManager.Exceptions;

/**
 *
 * @author martellocauda
 */
public class ObjectManagerException extends Exception {

    public ObjectManagerException(String message) {
        super(message);
    }

    public ObjectManagerException(String message, Throwable cause) {
        super(message, cause);
    }
}
