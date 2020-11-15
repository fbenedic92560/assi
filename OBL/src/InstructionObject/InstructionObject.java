/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InstructionObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class InstructionObject {
    private List<InstructionValidator> listOfInstructionValidators;
    
    public InstructionObject() {
        this.listOfInstructionValidators = new ArrayList<>();
        this.listOfInstructionValidators.add(new InstructionReadValidator());
        this.listOfInstructionValidators.add(new InstructionWriteValidator());
    }
    
    public Boolean analizeInstruction(String instruction) {
        Boolean resultValidation;
        
        resultValidation = Boolean.FALSE;
        for (InstructionValidator validator : this.listOfInstructionValidators) {
            if (Objects.equals(validator.validate(instruction), Boolean.TRUE)) {
                resultValidation = Boolean.TRUE;
                break;
            }
        }
        return resultValidation;
    }
}