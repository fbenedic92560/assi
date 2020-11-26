/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instruction;

import exception.InstructionWriteException;

/**
 *
 * @author Usuario
 */
class InstructionWriteValidator extends InstructionValidator {

    private static final String verb = InstructionType.WRITE.toString();
    
    @Override
    InstructionType validate(String instruction) {
        if (!instruction.toUpperCase().contains(verb)) {
            return InstructionType.BAD;
        }

        String[] elementsInstruction = instruction.split(" ");
        try {
            if (elementsInstruction.length != 4) {
                throw new InstructionWriteException("Sentencia WRITE incorrecta");
            }
        } catch (InstructionWriteException ex) {
            return InstructionType.BAD;
        }
        
        return InstructionType.WRITE;
    }
}