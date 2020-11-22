/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class InstructionReadException extends Exception {
    public InstructionReadException(String message) {
        Logger.getLogger(InstructionReadException.class.getName()).log(Level.INFO, message);
    }

    public InstructionReadException(String message, Throwable cause) {
        super(message, cause);
        Logger.getLogger(InstructionReadException.class.getName()).log(Level.SEVERE, message, cause);
    }
}
