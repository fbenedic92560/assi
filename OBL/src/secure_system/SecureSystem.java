/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secure_system;

import java.util.List;

import instruction.InstructionObject;
import reference_monitor.ReferenceMonitor;
import entity.obl_subject.OBLSubject;
import labeling.SecurityLevel;
import reference_monitor.exception.ReferenceMonitorException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class SecureSystem {
    private final List<OBLSubject> listOfSubjects;
    private final ReferenceMonitor referenceMonitor;
    private final InstructionObject instructionObject;
    
    public SecureSystem() {
        this.listOfSubjects = new ArrayList<>();
        this.referenceMonitor = new ReferenceMonitor();
        this.instructionObject = new InstructionObject();
    }
    
    public void readFile(String nameFile) {
        this.instructionObject.readFile(nameFile, this.listOfSubjects, this.referenceMonitor);
    }
    
    public void createSubject(String nameSubject, SecurityLevel securityLevel) {
        OBLSubject subject;
        
        subject = new OBLSubject(nameSubject, securityLevel);
        this.listOfSubjects.add(subject);
    }
    
    public void createObject(String nameObject, SecurityLevel securityLevel) {
        try {
            this.referenceMonitor.createNewObject(nameObject, securityLevel);
        } catch ( ReferenceMonitorException ex ) {
            Logger.getLogger(SecureSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
