/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InstructionObject.Exceptions;

/**
 *
 * @author Usuario
 */
public class InstructionWriteException extends Exception {
    public InstructionWriteException(String message) {
        super(message);
    }

    public InstructionWriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
