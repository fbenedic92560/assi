/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InstructionObject.Exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class InstructionWriteException extends Exception {
    public InstructionWriteException(String message) {
        Logger.getLogger(InstructionWriteException.class.getName()).log(Level.INFO, message);
    }

    public InstructionWriteException(String message, Throwable cause) {
        super(message, cause);
        Logger.getLogger(InstructionWriteException.class.getName()).log(Level.SEVERE, message);
    }
}
