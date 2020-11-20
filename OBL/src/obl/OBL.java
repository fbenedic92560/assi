package obl;

import labeling.SecurityLevel;
import object_manager.ObjectManager;
import entity.obl_object.OBLObject;
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
        //some tests
    }
}
