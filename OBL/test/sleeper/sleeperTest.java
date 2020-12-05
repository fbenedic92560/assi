/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleeper;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
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
     * Test of sleepMinutesToEvenFromEven method, of class Sleeper.
     */
    @Test
    public void testSleepMinutesToEvenFromEven() {
        ModeTimeAdvancer modeTimeAdvancer = ModeTimeAdvancer.EVEN;
        Sleeper sleeper = new Sleeper();
        Integer minutes, actualMinutes;
        LocalDateTime localDateTime;
        
        actualMinutes = LocalDateTime.now().getMinute();
        while (Boolean.TRUE) {
            if ((actualMinutes % 2 ) != 0) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sleeperTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                break;
            }
            actualMinutes = LocalDateTime.now().getMinute();
        }
        sleeper.sleepMinutes(modeTimeAdvancer);
        
        localDateTime = LocalDateTime.now();
        minutes = localDateTime.getMinute();
        assertEquals(minutes % 2, 0);
    }

    /**
     * Test of sleepMinutesToEvenFromOdd method, of class Sleeper.
     */
    @Test
    public void testSleepMinutesToEvenFromOdd() {
        ModeTimeAdvancer modeTimeAdvancer = ModeTimeAdvancer.EVEN;
        Sleeper sleeper = new Sleeper();
        Integer minutes, actualMinutes;
        LocalDateTime localDateTime;

        actualMinutes = LocalDateTime.now().getMinute();        
        while (Boolean.TRUE) {
            if ((actualMinutes % 2 ) == 0) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sleeperTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                break;
            }
            actualMinutes = LocalDateTime.now().getMinute();
        }
        sleeper.sleepMinutes(modeTimeAdvancer);
        
        localDateTime = LocalDateTime.now();
        minutes = localDateTime.getMinute();
        assertEquals(minutes % 2, 0);
    }

    /**
     * Test of sleepMinutesToOddFromEven method, of class Sleeper.
     */
    @Test
    public void testSleepMinutesToOddFromEven() {
        ModeTimeAdvancer modeTimeAdvancer = ModeTimeAdvancer.ODD;
        Sleeper sleeper = new Sleeper();
        Integer minutes, actualMinutes;
        LocalDateTime localDateTime;
        
        actualMinutes = LocalDateTime.now().getMinute();
        while (Boolean.TRUE) {
            if ((actualMinutes % 2 ) != 0) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sleeperTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                break;
            }
            actualMinutes = LocalDateTime.now().getMinute();
        }
        
        sleeper.sleepMinutes(modeTimeAdvancer);
        
        localDateTime = LocalDateTime.now();
        minutes = localDateTime.getMinute();
        assertEquals(minutes % 2, 1);
    }
    
    /**
     * Test of sleepMinutesToOddFromOdd method, of class Sleeper.
     */
    @Test
    public void testSleepMinutesToOddFromOdd() {
        ModeTimeAdvancer modeTimeAdvancer = ModeTimeAdvancer.ODD;
        Sleeper sleeper = new Sleeper();
        Integer minutes, actualMinutes;
        LocalDateTime localDateTime;
        
        actualMinutes = LocalDateTime.now().getMinute();
        while (Boolean.TRUE) {
            if ((actualMinutes % 2 ) == 0) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sleeperTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                break;
            }
            actualMinutes = LocalDateTime.now().getMinute();
        }
        
        sleeper.sleepMinutes(modeTimeAdvancer);
        
        localDateTime = LocalDateTime.now();
        minutes = localDateTime.getMinute();
        assertEquals(minutes % 2, 1);
    }

    /**
     * Test of sleepMinutesToNeutralFromEven method, of class Sleeper.
     */
    @Test
    public void testSleepMinutesToNeutralFromEven() {
        ModeTimeAdvancer modeTimeAdvancer = ModeTimeAdvancer.NEUTRAL;
        Sleeper sleeper = new Sleeper();
        Integer minutes, actualMinutes;
        LocalDateTime localDateTime;
        
        actualMinutes = LocalDateTime.now().getMinute();
        while (Boolean.TRUE) {
            if ((actualMinutes % 2 ) != 0) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sleeperTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                break;
            }
            actualMinutes = LocalDateTime.now().getMinute();
        }
        
        sleeper.sleepMinutes(modeTimeAdvancer);
        
        localDateTime = LocalDateTime.now();
        minutes = localDateTime.getMinute();
        assertEquals(minutes % 2, 0);
    }
    
    /**
     * Test of sleepMinutesToNeutralFromOdd method, of class Sleeper.
     */
    @Test
    public void testSleepMinutesToNeutralFromOdd() {
        ModeTimeAdvancer modeTimeAdvancer = ModeTimeAdvancer.NEUTRAL;
        Sleeper sleeper = new Sleeper();
        Integer minutes, actualMinutes;
        LocalDateTime localDateTime;
        
        actualMinutes = LocalDateTime.now().getMinute();
        while (Boolean.TRUE) {
            if ((actualMinutes % 2 ) == 0) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sleeperTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                break;
            }
            actualMinutes = LocalDateTime.now().getMinute();
        }
        
        sleeper.sleepMinutes(modeTimeAdvancer);
        
        localDateTime = LocalDateTime.now();
        minutes = localDateTime.getMinute();
        assertEquals(minutes % 2, 1);
    }
        
    /**
     * Test of sleepSecondsToEvenFromEven method, of class Sleeper.
     */
    @Test
    public void testSleepSecondsToEvenFromEven() {
        ModeTimeAdvancer modeTimeAdvancer = ModeTimeAdvancer.EVEN;
        Sleeper sleeper = new Sleeper();
        Integer seconds, actualSeconds;
        LocalDateTime localDateTime;
        
        actualSeconds = LocalDateTime.now().getSecond();
        while (Boolean.TRUE) {
            if ((actualSeconds % 2 ) != 0) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sleeperTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                break;
            }
            actualSeconds = LocalDateTime.now().getSecond();
        }
        
        sleeper.sleepSeconds(modeTimeAdvancer);
        
        localDateTime = LocalDateTime.now();
        seconds = localDateTime.getSecond();
        assertEquals(seconds % 2, 0);
    }

    /**
     * Test of sleepSecondsToEvenFromOdd method, of class Sleeper.
     */
    @Test
    public void testSleepSecondsToEvenFromOdd() {
        ModeTimeAdvancer modeTimeAdvancer = ModeTimeAdvancer.EVEN;
        Sleeper sleeper = new Sleeper();
        Integer seconds, actualSeconds;
        LocalDateTime localDateTime;
        
        actualSeconds = LocalDateTime.now().getSecond();
        while (Boolean.TRUE) {
            if ((actualSeconds % 2 ) == 0) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sleeperTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                break;
            }
            actualSeconds = LocalDateTime.now().getSecond();
        }
        
        sleeper.sleepSeconds(modeTimeAdvancer);
        
        localDateTime = LocalDateTime.now();
        seconds = localDateTime.getSecond();
        assertEquals(seconds % 2, 0);
    }

    /**
     * Test of sleepSecondsToOddFromEven method, of class Sleeper.
     */
    @Test
    public void testSleepSecondsToOddFromEven() {
        ModeTimeAdvancer modeTimeAdvancer = ModeTimeAdvancer.ODD;
        Sleeper sleeper = new Sleeper();
        Integer seconds, actualSeconds;
        LocalDateTime localDateTime;
        
        actualSeconds = LocalDateTime.now().getSecond();
        while (Boolean.TRUE) {
            if ((actualSeconds % 2 ) != 0) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sleeperTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                break;
            }
            actualSeconds = LocalDateTime.now().getSecond();
        }
        
        sleeper.sleepSeconds(modeTimeAdvancer);
        
        localDateTime = LocalDateTime.now();
        seconds = localDateTime.getSecond();
        assertEquals(seconds % 2, 1);
    }
    
    /**
     * Test of sleepSecondsToOddFromOdd method, of class Sleeper.
     */
    @Test
    public void testSleepSecondsToOddFromOdd() {
        ModeTimeAdvancer modeTimeAdvancer = ModeTimeAdvancer.ODD;
        Sleeper sleeper = new Sleeper();
        Integer seconds, actualSeconds;
        LocalDateTime localDateTime;
        
        actualSeconds = LocalDateTime.now().getSecond();
        while (Boolean.TRUE) {
            if ((actualSeconds % 2 ) == 0) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sleeperTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                break;
            }
            actualSeconds = LocalDateTime.now().getSecond();
        }
        
        sleeper.sleepMinutes(modeTimeAdvancer);
        
        localDateTime = LocalDateTime.now();
        seconds = localDateTime.getSecond();
        assertEquals(seconds % 2, 1);
    }

    /**
     * Test of sleepSecondsToNeutralFromEven method, of class Sleeper.
     */
    @Test
    public void testSleepSecondsToNeutralFromEven() {
        ModeTimeAdvancer modeTimeAdvancer = ModeTimeAdvancer.NEUTRAL;
        Sleeper sleeper = new Sleeper();
        Integer seconds, actualSeconds;
        LocalDateTime localDateTime;
        
        actualSeconds = LocalDateTime.now().getSecond();
        while (Boolean.TRUE) {
            if ((actualSeconds % 2 ) != 0) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sleeperTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                break;
            }
            actualSeconds = LocalDateTime.now().getSecond();
        }
        
        sleeper.sleepSeconds(modeTimeAdvancer);
        
        localDateTime = LocalDateTime.now();
        seconds = localDateTime.getSecond();
        assertEquals(seconds % 2, 0);
    }
    
    /**
     * Test of sleepSecondsToNeutralFromOdd method, of class Sleeper.
     */
    @Test
    public void testSleepSecondsToNeutralFromOdd() {
        ModeTimeAdvancer modeTimeAdvancer = ModeTimeAdvancer.NEUTRAL;
        Sleeper sleeper = new Sleeper();
        Integer seconds, actualSeconds;
        LocalDateTime localDateTime;
        
        actualSeconds = LocalDateTime.now().getSecond();
        while (Boolean.TRUE) {
            if ((actualSeconds % 2 ) == 0) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sleeperTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                break;
            }
            actualSeconds = LocalDateTime.now().getSecond();
        }
        
        sleeper.sleepSeconds(modeTimeAdvancer);
        
        localDateTime = LocalDateTime.now();
        seconds = localDateTime.getSecond();
        assertEquals(seconds % 2, 1);
    }
}
