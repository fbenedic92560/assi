/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obl;

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
        anObjectManager.addObject(new Object("test", 1, new java.lang.Object()));
        anObjectManager.addObject(new Object("test2", 0, new java.lang.Object()));
        System.out.println(anObjectManager.read("test"));
        anObjectManager.write("test2", 0);
        System.out.println(anObjectManager.read("test"));
    }

}
