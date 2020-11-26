/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructionobject;

import persistence.PersistenceFile;
import persistence.Persistence;
import entitysubject.EntitySubject;
import instruction.Instruction;
import instruction.InstructionCreator;
import referencemonitor.ReferenceMonitor;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import static java.util.Objects.isNull;

/**
 *
 * @author Usuario
 */
public class InstructionObject {
                
    public void readFile(String nameFile, List<EntitySubject> listOfEntitySubjects, ReferenceMonitor referenceMonitor) {
        Instruction instruction;
        Persistence persistence = new PersistenceFile();
        InstructionCreator instructionCreator = new InstructionCreator();

        try {
            persistence.openPersistence(nameFile);
            
            String line;
            while ((line = persistence.retrieveOneLine()) != null) {
                instruction = instructionCreator.createInstruction(line, listOfEntitySubjects);
                if (!isNull(instruction)) {
                    // aca le envia la instruccion al referenceMonitor
                }
            }
            
            persistence.closePersistence();
        } catch (IOException ex) {
            Logger.getLogger(InstructionObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}