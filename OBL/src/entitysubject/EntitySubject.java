package entitysubject;

import labeling.SecurityLevel;
import exception.ObjectManagerException;
import objectmanager.ObjectManager;
import exception.SubjectException;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author martellocauda
 */
public class EntitySubject {

    private String name;
    private int temp;
    private SecurityLevel securityLevel;
    /*local vars to store lyle things*/
    private int[] lastByte;
    private int bitToRead;
    /*local vars to store hal things*/
    private List<Integer> bitCacheToSend;

    public EntitySubject() {//check this default values
        this.name = "";
        this.temp = 0;
        this.securityLevel = SecurityLevel.LOW;
        this.bitToRead = 0;
        this.lastByte = new int[8];
        this.bitCacheToSend = new ArrayList<Integer>();
    }

    public EntitySubject(String name, SecurityLevel securityLevel) {
        this.name = name.toLowerCase();
        this.temp = 0;
        this.securityLevel = securityLevel;
        this.bitToRead = 0;
        this.lastByte = new int[8];
        this.bitCacheToSend = new ArrayList<Integer>();
    }

    public int[] getLastByte() {
        return lastByte;
    }

    public String getLastByteInString() {
        String lastByteInString = "";
        for (int i = 0; i < lastByte.length; i++) {
            lastByteInString += lastByte[i];
        }
        return lastByteInString;
    }

    public void setLastByte(int[] lastByte) {
        this.lastByte = lastByte;
    }

    public int getBitToRead() {
        return bitToRead;
    }

    public void setBitToRead(int bitToRead) {
        this.bitToRead = bitToRead;
    }

    private void initializeLastByte() {
        for (int i = 0; i < lastByte.length; i++) {
            lastByte[i] = 0;
        }
    }

    private void incrementBitToRead() {
        bitToRead++;
        if (bitToRead == 8) {
            bitToRead = 0;
            initializeLastByte();
        }
    }

    public void ReadBit(int bit) {
        lastByte[bitToRead] = bit;
        incrementBitToRead();
    }

    public void enqueueBitInCache(Integer bit) {
        bitCacheToSend.add(bit);
    }

    public Integer dequeueBitFromCache() {
        Integer bit = bitCacheToSend.get(0);
        bitCacheToSend.remove(0);
        return bit;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public int getTemp() {
        return this.temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public SecurityLevel getSecurityLevel() {
        return this.securityLevel;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EntitySubject other = (EntitySubject) obj;
        if (!Objects.equals(this.name.toLowerCase(), other.name.toLowerCase())) {
            return false;
        }
        return true;
    }

}
