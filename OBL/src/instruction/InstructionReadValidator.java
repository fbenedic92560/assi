/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instruction;

import exception.InstructionReadException;

/**
 *
 * @author Usuario
 */
class InstructionReadValidator extends InstructionValidator {
    
    private static final String verb = InstructionType.READ.toString();
        
    @Override
    InstructionType validate(String instruction) {     
        if (!instruction.toUpperCase().contains(verb)) {
            return InstructionType.BAD;
        }

        String[] elementsInstruction = instruction.split(" ");
        if (elementsInstruction.length != 3) {
            return InstructionType.BAD;
        }
            
        return InstructionType.READ;
    }    
}