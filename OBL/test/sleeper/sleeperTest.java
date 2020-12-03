/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleeper;

import java.time.LocalDateTime;
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
     * Test of sleepMinutesToEven method, of class Sleeper.
     */
    @Test
    public void testSleepMinutesToEven() {
        ModeTimeAdvancer modeTimeAdvancer = ModeTimeAdvancer.EVEN;
        Sleeper sleeper = new Sleeper();
        Integer minutes;
        LocalDateTime localDateTime;
        
        sleeper.sleepMinutes(modeTimeAdvancer);
        
        localDateTime = LocalDateTime.now();
        minutes = localDateTime.getMinute();
        assertEquals(minutes % 2, 0);
    }

    /**
     * Test of sleepMinutesToOdd method, of class Sleeper.
     */
    @Test
    public void testSleepMinutesToOdd() {
        ModeTimeAdvancer modeTimeAdvancer = ModeTimeAdvancer.EVEN;
        Sleeper sleeper = new Sleeper();
        Integer minutes;
        LocalDateTime localDateTime;
        
        sleeper.sleepMinutes(modeTimeAdvancer);
        
        localDateTime = LocalDateTime.now();
        minutes = localDateTime.getMinute();
        assertEquals(minutes % 2, 1);
    }
    
}
