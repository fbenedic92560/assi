package obl;

import Labeling.SensibilityLabel;
import ObjectManager.ObjectManager;
import ObjectManager.Object;

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
        //some tests
        ObjectManager anObjectManager = new ObjectManager();
        anObjectManager.addObject(new Object("test", 1, new SensibilityLabel()));
        anObjectManager.addObject(new Object("test2", 0, new SensibilityLabel()));
        System.out.println(anObjectManager.read("test"));
        anObjectManager.write("test2", 0);
        System.out.println(anObjectManager.read("test"));
    }

}
