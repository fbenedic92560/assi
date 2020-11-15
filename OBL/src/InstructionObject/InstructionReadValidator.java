/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InstructionObject;

import InstructionObject.Exceptions.InstructionReadException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class InstructionReadValidator extends InstructionValidator {
    
    @Override
    public Boolean validate(String instruction) {
        String operatorInstruction;
        String[] elementsInstruction = instruction.split(" ");
        
        try {
            if (elementsInstruction.length != 3) {
                throw new InstructionReadException("Sentencia READ incorrecta");
            }
        } catch (InstructionReadException ex) {
            Logger.getLogger(InstructionReadValidator.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
        
        operatorInstruction = elementsInstruction[0];
        try {
            if (!"READ".equals(operatorInstruction.toUpperCase())) {
                throw new InstructionReadException("Sentencia no reconocida");
            }
        } catch (InstructionReadException ex) {
            Logger.getLogger(InstructionReadValidator.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
        
        return Boolean.TRUE;
    }
}