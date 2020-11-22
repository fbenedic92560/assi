/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package securesystem;

import java.util.List;

import instructionobject.InstructionObject;
import referencemonitor.ReferenceMonitor;
import entitysubject.EntitySubject;
import labeling.SecurityLevel;
import exception.ReferenceMonitorException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class SecureSystem {
    private final List<EntitySubject> listOfSubjects;
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
        EntitySubject subject;
        
        subject = new EntitySubject(nameSubject, securityLevel);
        this.listOfSubjects.add(subject);
    }
    
    public void createObject(String nameObject, SecurityLevel securityLevel) {
        try {
            this.referenceMonitor.createEntityObject(nameObject, securityLevel);
        } catch ( ReferenceMonitorException ex ) {
            Logger.getLogger(SecureSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
