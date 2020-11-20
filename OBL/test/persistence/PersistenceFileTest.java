/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import persistence.PersistenceFile;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class PersistenceFileTest {
    
    public PersistenceFileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of openPersistence method, of class PersistenceFile.
     */
    @Test
    public void testOpenPersistence() {
        String stringPersistence;
        Boolean expResult;
        
        System.out.println("openPersistence");
        stringPersistence = "C:\\Temp\\we_have_a_leak.txt";
        PersistenceFile instance = new PersistenceFile();
        expResult = instance.openPersistence(stringPersistence);
        assertEquals(expResult, Boolean.TRUE);
    }

    /**
     * Test of retrieveOneLine method, of class PersistenceFile.
     */
    @Test
    public void testRetrieveOneLine() {
        System.out.println("retrieveOneLine");
        PersistenceFile instance = new PersistenceFile();
        String expResult = "";
        String result = instance.retrieveOneLine();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closePersistence method, of class PersistenceFile.
     */
    @Test
    public void testClosePersistence() {
        System.out.println("closePersistence");
        PersistenceFile instance = new PersistenceFile();
        instance.closePersistence();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
