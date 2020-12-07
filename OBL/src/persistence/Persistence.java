package persistence;

import java.io.IOException;

/**
 *
 * @author Usuario
 */
public interface Persistence {
    public Boolean openPersistence(String stringPersistence) throws IOException;
    public String retrieveOneLine() throws IOException;
    public Character retrieveOneCharacter() throws IOException;
    public Boolean closePersistence() throws IOException;
}
