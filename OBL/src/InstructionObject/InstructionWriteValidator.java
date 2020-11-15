/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InstructionObject;

import InstructionObject.Exceptions.InstructionWriteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class InstructionWriteValidator extends InstructionValidator {
    
    @Override
    public Boolean validate(String instruction) {
        String operatorInstruction;
        String[] elementsInstruction = instruction.split(" ");
        try {
            if (elementsInstruction.length != 4) {
                throw new InstructionWriteException("Sentencia WRITE incorrecta");
            }
        } catch (InstructionWriteException ex) {
            Logger.getLogger(InstructionWriteValidator.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
        
        operatorInstruction = elementsInstruction[0];
        try {
        if (!"WRITE".equals(operatorInstruction.toUpperCase())) {
            throw new InstructionWriteException("Sentencia no reconocida");
        }
        } catch (InstructionWriteException ex) {
            Logger.getLogger(InstructionWriteValidator.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}