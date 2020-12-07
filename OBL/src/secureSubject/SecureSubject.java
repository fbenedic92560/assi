package secureSubject;

import entitysubject.EntitySubject;
import labeling.SecurityLevel;
import sleeper.*;
import securesystem.SecureSystem;

/**
 *
 * @author martellocauda
 */
public class SecureSubject {

    private Character run(EntitySubject entitySubject, Character bit) {
        Sleeper sleeper = new Sleeper();
        Character toSendBit = 'n';//only modified by hal run

        switch (entitySubject.getSecurityLevel()) {
            case LOW://lyle
                if (sleeper.getParity() == ModeTimeAdvancer.ODD) {//something was sent
                    entitySubject.storeBit(entitySubject.getTemp());
                    sleeper.sleepSeconds(ModeTimeAdvancer.EVEN);
                }
                break;
            case MEDIUM://moe, do nothing, not modify
                sleeper.sleepSeconds(ModeTimeAdvancer.NEUTRAL);
                break;
            case HIGH://hal
                if (sleeper.getParity() == ModeTimeAdvancer.EVEN) {//lyle already readed
                    entitySubject.nextBit();
                    entitySubject.enqueueBitInCache(bit);
                    toSendBit = entitySubject.getBitFromCache();
                } else {//lyle not readed yet
                    entitySubject.enqueueBitInCache(bit);
                    toSendBit = entitySubject.getBitFromCache();
                }
                sleeper.sleepSeconds(ModeTimeAdvancer.ODD);
                break;
        }

        return toSendBit;
    }

    //maybe this turns logic, not be here
    public void halTurn(Character bit, SecureSystem secureSystem) {
        EntitySubject hal = secureSystem.getSubject("hal");
        
        Character toSendBit = run(hal, bit);
        if (toSendBit == '0') {
            secureSystem.createObject("obj", hal);
        }
    }

    public void lyleTurn(SecureSystem secureSystem) {
        EntitySubject lyle = secureSystem.getSubject("lyle");

        secureSystem.createObject("obj", lyle);
        secureSystem.writeObject("obj", lyle, 1);
        secureSystem.readObject("obj", lyle);
        secureSystem.destroyObject("obj", lyle);
        run(lyle, 'n');
    }

    public void moeTurn(SecureSystem secureSystem) {
        EntitySubject moe = secureSystem.getSubject("moe");

        secureSystem.writeObject("obj", moe, 9);
        run(moe, 'n');
    }
}
