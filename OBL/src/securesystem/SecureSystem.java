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
import instruction.*;
import secureSubject.SecureSubject;
import sleeper.*;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

/**
 *
 * @author Usuario
 */
public class SecureSystem {

    private enum ValidSequenceCharacter {
        H, M, L
    };

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
        System.out.println("The current state is:\n");
        this.printStateOfEntitySubjects();
        this.referenceMonitor.printObjectsInfo();
    }

    public void readFile(String nameFile) {
        this.instructionObject.readFile(nameFile, this.listOfSubjects, this.referenceMonitor);
        //this.printState();
    }

    public void createSubject(String nameSubject, SecurityLevel securityLevel) {
        EntitySubject subject;

        subject = new EntitySubject(nameSubject, securityLevel);
        this.listOfSubjects.add(subject);
    }

    public EntitySubject getSubject(String nameSubject) {
        EntitySubject subject;

        subject = listOfSubjects.get(listOfSubjects.indexOf(new EntitySubject(nameSubject, null)));
        return subject;
    }

    public void createObject(String nameObject, EntitySubject entitySubject) {
        try {
            this.referenceMonitor.createEntityObject(nameObject, entitySubject.getSecurityLevel());
        } catch (ReferenceMonitorException ex) {
            //Logger.getLogger(SecureSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroyObject(String nameObject, EntitySubject entitySubject) {
        try {
            this.referenceMonitor.destroyEntityObject(entitySubject, nameObject);
        } catch (ReferenceMonitorException ex) {
            //Logger.getLogger(SecureSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readObject(String nameObject, EntitySubject entitySubject) {
        this.referenceMonitor.executeInstruction(new InstructionRead(entitySubject, nameObject));
    }

    public void writeObject(String nameObject, EntitySubject entitySubject, int value) {
        this.referenceMonitor.executeInstruction(new InstructionWrite(entitySubject, nameObject, value));
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

    public void covertChannel(String messageFileName, String sequenceFileName, String outputFileName) {
        Persistence persistenceMessageFile = new PersistenceFile();
        Persistence persistenceSequenceFile = new PersistenceFile();

        try {
            if (!persistenceMessageFile.openPersistence(messageFileName)) {
                return;
            }
            if (!persistenceSequenceFile.openPersistence(sequenceFileName)) {
                return;
            }

            Character characterSequence;
            Character characterMessage;
            Character[] bitsOfCharacter = new Character[8];
            Integer offsetBitOfCharacter;
            Message message = new Message();
            SecureSubject secureSubject = new SecureSubject();

            Boolean endMessage = Boolean.FALSE;
            offsetBitOfCharacter = 8;
            Sleeper sleeper = new Sleeper();
            sleeper.sleepSeconds(ModeTimeAdvancer.EVEN);
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
                                    //System.out.println("BYTE A MANDAR, SECURESYSTEM " + Arrays.toString(bitsOfCharacter));
                                    //System.out.print(bitsOfCharacter[offsetBitOfCharacter]);
                                    secureSubject.halTurn(bitsOfCharacter[offsetBitOfCharacter], this);
                                    offsetBitOfCharacter++;
                                } else {
                                    endMessage = Boolean.TRUE;
                                    offsetBitOfCharacter = 0;
                                }
                            } else {
                                if (endMessage) {
                                    //System.out.print('0');
                                    secureSubject.halTurn('0', this);
                                } else {
                                    //System.out.print(bitsOfCharacter[offsetBitOfCharacter]);
                                    secureSubject.halTurn(bitsOfCharacter[offsetBitOfCharacter], this);
                                }
                                offsetBitOfCharacter++;
                            }
                            break;
                        case M:
                            secureSubject.moeTurn(this);
                            break;
                        case L:
                            secureSubject.lyleTurn(this);
                            break;
                    }
                }
            }

            String receivedMessage = this.decryptLyleReceivedMessage();
            writeLyleReceivedMessageToOutputFile(outputFileName, receivedMessage);
            
            persistenceMessageFile.closePersistence();
            persistenceSequenceFile.closePersistence();
        } catch (IOException ex) {
            Logger.getLogger(SecureSystem.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String decryptLyleReceivedMessage() {
        List<Character> readedBytes = getSubject("lyle").getReadedBytes();
        String receivedMessage = "";
        int firstIndex = 0;
        int lastIndex = 8;

        for (int i = 0; i < readedBytes.size() / 8; i++) {
            List<Character> aByte = readedBytes.subList(firstIndex, lastIndex);
            String aByteInString = "";
            for (int j = 0; j < aByte.size(); j++) {
                aByteInString += aByte.get(j);
            }
            int a = Integer.parseInt(aByteInString, 2);
            receivedMessage += (char) (a);
            firstIndex += 8;
            lastIndex += 8;
        }

        return receivedMessage;
    }

    private void writeLyleReceivedMessageToOutputFile(String outputFileName, String receivedMessage) {
        try {
            FileWriter myWriter = new FileWriter(outputFileName);
            myWriter.write(receivedMessage);
            myWriter.close();
            System.out.println("Lyle received message was stored in: " + outputFileName);
        } catch (IOException ex) {
            Logger.getLogger(SecureSystem.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
