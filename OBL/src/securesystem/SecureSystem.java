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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import message.Message;
import persistence.Persistence;
import persistence.PersistenceFile;

/**
 *
 * @author Usuario
 */
public class SecureSystem {
    private enum ValidSequenceCharacter { H, M, L };

    private final List<EntitySubject> listOfSubjects;
    private final ReferenceMonitor referenceMonitor;
    private final InstructionObject instructionObject;
    
    public SecureSystem() {
        this.listOfSubjects = new ArrayList<>();
        this.referenceMonitor = new ReferenceMonitor();
        this.instructionObject = new InstructionObject();
    }
    
    private void printStateOfEntitySubjects() {
        String subjectName;
        Integer subjectTempValue;
        
        for (EntitySubject entitySubject : this.listOfSubjects) {
            subjectName = entitySubject.getName();
            subjectTempValue = entitySubject.getTemp();
            System.out.println(subjectName + " has recently read: " + subjectTempValue);
        }
    }
    
    private void printState() {
        System.out.println("The current state is:");
        this.printStateOfEntitySubjects();
        this.referenceMonitor.printObjectsInfo();
    }
    
    public void readFile(String nameFile) {
        System.out.println("Reading from file: " + nameFile);
        this.instructionObject.readFile(nameFile, this.listOfSubjects, this.referenceMonitor);
        this.printState();
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
    
    private Boolean validateSequenceCharacter(Character characterSequence) {
        ValidSequenceCharacter[] validCharacters = ValidSequenceCharacter.values();
        
        Boolean valid = Boolean.FALSE;
        for (char c : Arrays.toString(validCharacters).toCharArray()) {
            if (characterSequence == c) {
                valid = Boolean.TRUE;
                break;
            }
        }
        
        return valid;
    }
    
    public void covertChannel(String messageFileName, String sequenceFileName) {
        Persistence persistenceMessageFile = new PersistenceFile();
        Persistence persistenceSequenceFile = new PersistenceFile();
              
        try {
            persistenceMessageFile.openPersistence(messageFileName);
            persistenceSequenceFile.openPersistence(sequenceFileName);
            
            Character characterSequence;
            Character characterMessage;
            Character[] bitsOfCharacter = new Character[8];
            Integer offsetBitOfCharacter;
            Message message = new Message();
            
            Boolean endMessage = Boolean.FALSE;
            offsetBitOfCharacter = 8;
            while ((characterSequence = persistenceSequenceFile.retrieveOneCharacter()) != null) {
                if (validateSequenceCharacter(characterSequence)) {
                    switch (ValidSequenceCharacter.valueOf(characterSequence.toString())) {
                        case H:
                            if (offsetBitOfCharacter > 7) {
                                if (endMessage) {
                                    break;
                                }
                                characterMessage = persistenceMessageFile.retrieveOneCharacter();
                                if (characterMessage != null) {
                                    offsetBitOfCharacter = 0;
                                    bitsOfCharacter = message.convertCharactertoBitsArray(characterMessage);
                                    System.out.print(bitsOfCharacter[offsetBitOfCharacter]);
                                    // call Hal with bitsOfCharacters{offsetBitOfCharacter]
                                    offsetBitOfCharacter++;
                                } else {
                                    endMessage = Boolean.TRUE;
                                    offsetBitOfCharacter = 0;
                                }
                            } else {
                                if (endMessage) {
                                    System.out.print('0');
                                    // call Hal with '0'
                                } else {
                                    System.out.print(bitsOfCharacter[offsetBitOfCharacter]);
                                    // call Hal with bitsOfCharacters{offsetBitOfCharacter]
                                }
                                offsetBitOfCharacter++;
                            }
                            break;
                        case M:
                            // call Moe
                            break;
                        case L:
                            // call Lil
                            break;
                    }
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(SecureSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
