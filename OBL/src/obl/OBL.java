package obl;

import labeling.SecurityLevel;
import securesystem.SecureSystem;

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
        SecureSystem secureSystem = new SecureSystem();
        
        secureSystem.createObject("lobj", SecurityLevel.LOW);
        secureSystem.createObject("mobj", SecurityLevel.MEDIUM);
        secureSystem.createObject("hobj", SecurityLevel.HIGH);
        
        secureSystem.createSubject("lyle", SecurityLevel.LOW);
        secureSystem.createSubject("moe", SecurityLevel.MEDIUM);
        secureSystem.createSubject("hal", SecurityLevel.HIGH);
        
        secureSystem.readFile("c:\\temp\\assi_example001.txt");
    }
}
