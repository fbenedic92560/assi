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

/**
 *
 * @author Usuario
 */
public class Sleeper {
    private static final Integer SECONDS_OF_MINUTES = 60;
    private static final Integer NANOS_OF_SECONDS = 1000000000;
      
    public void sleepSeconds(ModeTimeAdvancer modeTimeAdvancer) {
        switch (modeTimeAdvancer) {
            case EVEN:
                sleepSecondsToEven();
                break;
            case ODD:
                sleepSecondsToOdd();
                break;
            case NEUTRAL:
                sleepSecondsToNeutral();
                break;
        }
    }
    
    private void sleepSecondsToEven() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Integer seconds = localDateTime.getSecond();
        Integer nanoSeconds = localDateTime.getNano();
        
        Integer nanoSecondsToSleep;
        
        Integer moduleSeconds = seconds % 2;
        if (moduleSeconds == 1) {
            nanoSecondsToSleep = NANOS_OF_SECONDS - nanoSeconds;
        } else {
            nanoSecondsToSleep = NANOS_OF_SECONDS - nanoSeconds + NANOS_OF_SECONDS;
        }
        
        try {
            TimeUnit.NANOSECONDS.sleep(nanoSecondsToSleep);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sleeper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void sleepSecondsToOdd() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Integer seconds = localDateTime.getSecond();
        Integer nanoSeconds = localDateTime.getNano();
        
        Integer nanoSecondsToSleep;
        
        Integer moduleSeconds = seconds % 2;
        if (moduleSeconds == 1) {
            nanoSecondsToSleep = NANOS_OF_SECONDS - nanoSeconds + NANOS_OF_SECONDS;
        } else {
            nanoSecondsToSleep = NANOS_OF_SECONDS - nanoSeconds;
        }
        
        try {
            TimeUnit.NANOSECONDS.sleep(nanoSecondsToSleep);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sleeper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void sleepSecondsToNeutral() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Integer nanoSeconds = localDateTime.getNano();
        
        Integer nanoSecondsToSleep = SECONDS_OF_MINUTES - nanoSeconds + SECONDS_OF_MINUTES;
        try {
            TimeUnit.NANOSECONDS.sleep(nanoSecondsToSleep);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sleeper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sleepMinutes(ModeTimeAdvancer modeTimeAdvancer) {
        switch (modeTimeAdvancer) {
            case EVEN:
                sleepMinutesToEven();
                break;
            case ODD:
                sleepMinutesToOdd();
                break;
            case NEUTRAL:
                sleepMinutesToNeutral();
                break;
        }
    }

    private void sleepMinutesToEven() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Integer minutes = localDateTime.getMinute();
        Integer seconds = localDateTime.getSecond();
        
        Integer secondsToSleep;
        
        Integer moduleMinutes = minutes % 2;
        if (moduleMinutes == 1) {
            secondsToSleep = SECONDS_OF_MINUTES - seconds;
        } else {
            secondsToSleep = SECONDS_OF_MINUTES - seconds + SECONDS_OF_MINUTES;
        }
        
        try {
            TimeUnit.SECONDS.sleep(secondsToSleep);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sleeper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sleepMinutesToOdd() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Integer minutes = localDateTime.getMinute();
        Integer seconds = localDateTime.getSecond();
        
        Integer secondsToSleep;
        
        Integer moduleMinutes = minutes % 2;
        if (moduleMinutes == 1) {
            secondsToSleep = SECONDS_OF_MINUTES - seconds + SECONDS_OF_MINUTES;
        } else {
            secondsToSleep = SECONDS_OF_MINUTES - seconds;
        }
        
        try {
            TimeUnit.SECONDS.sleep(secondsToSleep);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sleeper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void sleepMinutesToNeutral() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Integer seconds = localDateTime.getSecond();
        
        Integer secondsToSleep = SECONDS_OF_MINUTES - seconds + SECONDS_OF_MINUTES;
        try {
            TimeUnit.SECONDS.sleep(secondsToSleep);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sleeper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
