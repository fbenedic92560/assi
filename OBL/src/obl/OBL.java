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

    private static void displayMainUI() {
        
    }
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}