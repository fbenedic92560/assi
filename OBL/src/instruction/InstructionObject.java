/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instruction;

import instruction.validator.InstructionReadValidator;
import instruction.validator.InstructionWriteValidator;
import instruction.validator.InstructionValidator;
import persistence.PersistenceFile;
import persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import entity.obl_subject.OBLSubject;
import reference_monitor.ReferenceMonitor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    private Boolean analizeInstruction(String instruction) {
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
    
    private OBLSubject searchSubject(String nameSubject, List<OBLSubject> listOfSubjects) {
        OBLSubject subject = null;
        
        for (OBLSubject s : listOfSubjects) {
            if (s.getName().equals(nameSubject)) {
                subject = s;
                break;
            }
        }
        
        return subject;
    }
    
    public void readFile(String nameFile, List<OBLSubject> listOfSubjects, ReferenceMonitor referenceMonitor) {
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