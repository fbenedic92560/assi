/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instruction;

import entitysubject.EntitySubject;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;

/**
 *
 * @author Usuario
 */
public class InstructionCreator {
    private final List<InstructionValidator> listOfInstructionValidators;
    
    public InstructionCreator() {
        this.listOfInstructionValidators = new ArrayList<InstructionValidator>();
        this.listOfInstructionValidators.add(new InstructionReadValidator());
        this.listOfInstructionValidators.add(new InstructionWriteValidator());
    }
    
    private InstructionType analizeInstruction(String lineInstruction) {
        InstructionType instructionType;
        
        instructionType = InstructionType.BAD;
        for (InstructionValidator validator : this.listOfInstructionValidators) {
            instructionType = validator.validate(lineInstruction);
            if (!instructionType.equals(InstructionType.BAD)) {
                return instructionType;
            }
        }
        
        return instructionType;
    }
    
    private Instruction createReadInstruction(List<EntitySubject> listOfEntitySubjects, String lineInstruction) {        
        String[] operatorsInstruction = lineInstruction.split("[ ]+");
        String subjectName = operatorsInstruction[1];
        String objectName = operatorsInstruction[2];
        
        EntitySubject entitySubject = searchSubject(listOfEntitySubjects, subjectName);
        if (isNull(entitySubject)) {
            return null;
        }
        Instruction instruction = new InstructionRead(entitySubject, objectName);
        return instruction;
    }
    
    private Instruction createWriteInstruction(List<EntitySubject> listOfEntitySubjects, String lineInstruction) {       
        String[] operatorsInstruction = lineInstruction.split("[ ]+");
        String subjectName = operatorsInstruction[1];
        String objectName = operatorsInstruction[2];
        Integer value = Integer.parseInt(operatorsInstruction[3]);
        
        EntitySubject entitySubject = searchSubject(listOfEntitySubjects, subjectName);
        if (isNull(entitySubject)) {
            return null;
        }
        Instruction instruction = new InstructionWrite(entitySubject, objectName, value);
        return instruction;
    }
    
    private Instruction createBadInstruction(String lineInstruction) {
        Instruction instruction = new InstructionBad(lineInstruction);
        return instruction;
    }

    private EntitySubject searchSubject(List<EntitySubject> listOfEntitySubjects, String nameSubject) {
        for (EntitySubject entitySubject : listOfEntitySubjects) {
            if (entitySubject.getName().equals(nameSubject)) {
                return entitySubject;
            }
        }
        return null;
    }
    
    public Instruction createInstruction(String lineInstruction, List<EntitySubject> listOfEntitySubjects) {
        InstructionType instructionType;
        Instruction instruction;
        
        instructionType = analizeInstruction(lineInstruction);
        switch (instructionType) {
            case BAD:
                instruction = createBadInstruction(lineInstruction);
                break;
            case READ:
                instruction = createReadInstruction(listOfEntitySubjects, lineInstruction);
                break;
            case WRITE:
                instruction = createWriteInstruction(listOfEntitySubjects, lineInstruction);
                break;
            default:
                instruction = createBadInstruction(lineInstruction);
                break;
        }
        return instruction;
    }
}
