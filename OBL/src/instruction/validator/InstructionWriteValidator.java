/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instruction.validator;

import instruction.validator.InstructionValidator;
import instruction.exception.InstructionWriteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class InstructionWriteValidator extends InstructionValidator {

    private static final String verb = "WRITE";
    
    @Override
    public Boolean validate(String instruction) {
        if (!instruction.toUpperCase().contains(verb)) {
            return Boolean.FALSE;
        }

        String[] elementsInstruction = instruction.split(" ");
        try {
            if (elementsInstruction.length != 4) {
                throw new InstructionWriteException("Sentencia WRITE incorrecta");
            }
        } catch (InstructionWriteException ex) {
            return Boolean.FALSE;
        }
        
        return Boolean.TRUE;
    }
    
}