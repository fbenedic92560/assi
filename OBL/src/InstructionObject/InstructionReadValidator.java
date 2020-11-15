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
    
    private static final String verb = "READ";
        
    @Override
    public Boolean validate(String instruction) {     
        if (!instruction.toUpperCase().contains(verb)) {
            return Boolean.FALSE;
        }

        String[] elementsInstruction = instruction.split(" ");
        try {
            if (elementsInstruction.length != 3) {
                throw new InstructionReadException("Sentencia READ incorrecta");
            }
        } catch (InstructionReadException ex) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
    
}