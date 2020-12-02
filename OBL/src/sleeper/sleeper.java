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
public class sleeper {
    private static final Integer secondsOfMinutes = 60;
    
    public void sleepMinutes(ModeTimeAdvancer modeTimeAdvancer) {
        switch (modeTimeAdvancer) {
            case EVEN:
                sleepMinutesToEven();
                break;
            case ODD:
                sleepMinutesToOdd();
                break;
            case NEUTRAL:
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
            secondsToSleep = secondsOfMinutes - seconds;
        } else {
            secondsToSleep = secondsOfMinutes - seconds + secondsOfMinutes;
        }
        
        try {
            TimeUnit.SECONDS.sleep(secondsToSleep);
        } catch (InterruptedException ex) {
            Logger.getLogger(sleeper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sleepMinutesToOdd() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Integer minutes = localDateTime.getMinute();
        Integer seconds = localDateTime.getSecond();
        
        Integer secondsToSleep;
        
        Integer moduleMinutes = minutes % 2;
        if (moduleMinutes == 1) {
            secondsToSleep = secondsOfMinutes - seconds;
        } else {
            secondsToSleep = secondsOfMinutes - seconds + secondsOfMinutes;
        }
        
        try {
            TimeUnit.SECONDS.sleep(secondsToSleep);
        } catch (InterruptedException ex) {
            Logger.getLogger(sleeper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
