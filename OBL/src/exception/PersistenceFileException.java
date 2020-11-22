/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Usuario
 */
public class PersistenceFileException extends Exception {
    public PersistenceFileException(String message) {
        super(message);
    }

    public PersistenceFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
