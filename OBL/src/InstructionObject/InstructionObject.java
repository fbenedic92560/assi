/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InstructionObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Subject.Subject;
import Persistence.*;
import ReferenceMonitor.ReferenceMonitor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Instruction.Instruction;

/**
 *
 * @author Usuario
 */
public class InstructionObject {
    private final List<InstructionValidator> listOfInstructionValidators;
    
    public InstructionObject() {
        this.listOfInstructionValidators = new ArrayList<>();
        this.listOfInstructionValidators.add(new InstructionReadValidator());
        this.listOfInstructionValidators.add(new InstructionWriteValidator());
    }
    
    private Instruction analizeInstruction(String instruction) {
        Instruction instruction;
        
        instruction = Instruction.BAD;
        for (InstructionValidator validator : this.listOfInstructionValidators) {
            if (Objects.equals(validator.validate(instruction), Boolean.TRUE)) {
                resultValidation = Boolean.TRUE;
                break;
            }
        }
        return instruction;
    }
    
    private Subject searchSubject(String nameSubject, List<Subject> listOfSubjects) {
        Subject subject = null;
        
        for (Subject s : listOfSubjects) {
            if (s.getName().equals(nameSubject)) {
                subject = s;
                break;
            }
        }
        
        return subject;
    }
    
    public void readFile(String nameFile, List<Subject> listOfSubjects, ReferenceMonitor referenceMonitor) {
        Persistence persistence = new PersistenceFile();

        try {
            persistence.openPersistence(nameFile);
            
            String line;
            while ((line = persistence.retrieveOneLine()) != null) {
                if (this.analizeInstruction(line)) {
                    
                }
            }
            
            persistence.closePersistence();
        } catch (IOException ex) {
            Logger.getLogger(InstructionObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}