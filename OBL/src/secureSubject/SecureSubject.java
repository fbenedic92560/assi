package secureSubject;

import entitysubject.EntitySubject;
import labeling.SecurityLevel;
import sleeper.*;

/**
 *
 * @author martellocauda
 */
public class SecureSubject {

    public void Run(EntitySubject entitySubject, Integer bit) {
        Sleeper sleeper = new Sleeper();
        switch (entitySubject.getSecurityLevel()) {
            case LOW://lyle
                if (sleeper.getParity() == ModeTimeAdvancer.ODD) {//something was sent
                    entitySubject.ReadBit(entitySubject.getTemp());
                    sleeper.sleepSeconds(ModeTimeAdvancer.EVEN);
                }
                break;
            case MEDIUM://moe, do nothing, not modify
                sleeper.sleepSeconds(ModeTimeAdvancer.NEUTRAL);
                break;
            case HIGH://hal
                if (sleeper.getParity() == ModeTimeAdvancer.EVEN) {//lyle already readed
                    if (bit != -1) {//have some new to send
                        entitySubject.enqueueBitInCache(bit);
                    }
                    sleeper.sleepSeconds(ModeTimeAdvancer.ODD);
                    sleeper.sleepSeconds(ModeTimeAdvancer.ODD);
                } else {//lyle not readed yet
                    if (bit != -1) {//have some new to send
                        entitySubject.enqueueBitInCache(bit);
                    }
                    sleeper.sleepSeconds(ModeTimeAdvancer.ODD);
                }
                break;
        }
    }
}
