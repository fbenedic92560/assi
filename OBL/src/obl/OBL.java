package obl;

import labeling.SecurityLevel;
import objectmanager.ObjectManager;
import entityobject.EntityObject;
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
