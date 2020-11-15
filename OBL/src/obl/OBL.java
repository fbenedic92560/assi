/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obl;

import ObjectManager.ObjectManager;
import ObjectManager.Object;
import InstructionObject.*;
import Persistence.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author martellocauda
 */
public class OBL {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        ObjectManager anObjectManager = new ObjectManager();
        InstructionObject anInstructionObject = new InstructionObject();
        Persistence aPersistence = new PersistenceFile();
        
        
        String nameFile = "c:\\temp\\assi_example001.txt";
        if (!aPersistence.openPersistence(nameFile)) {
            JOptionPane.showMessageDialog(new JFrame(), nameFile + "Error opening ", "Dialog", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        String line;
        Boolean lineValid;
        while ((line = aPersistence.retrieveOneLine()) != null) {
            lineValid = anInstructionObject.analizeInstruction(line);
            System.out.println(line + lineValid.toString());
        }
        
        aPersistence.closePersistence();
        
        anObjectManager.addObject(new Object("test", 1, new java.lang.Object()));
        anObjectManager.addObject(new Object("test2", 0, new java.lang.Object()));
        
        System.out.println(anObjectManager.read("test"));
        anObjectManager.write("test2", 0);
        System.out.println(anObjectManager.read("test"));
    }
}