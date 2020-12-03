/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleeper;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class sleeperTest {
    
    public sleeperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of sleepMinutes method, of class sleeper.
     */
    @Test
    public void testSleepMinutes() {
        System.out.println("sleepMinutes");
        ModeTimeAdvancer modeTimeAdvancer = null;
        sleeper instance = new sleeper();
        instance.sleepMinutes(modeTimeAdvancer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
