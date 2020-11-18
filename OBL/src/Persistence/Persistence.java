package Persistence;

/**
 *
 * @author Usuario
 */
public interface Persistence {
    public Boolean openPersistence(String stringPersistence);
    public String retrieveOneLine();
    public Boolean closePersistence();
}
