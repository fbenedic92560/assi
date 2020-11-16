package Labeling;

import Labeling.Exceptions.AccessLevelException;
import java.util.Objects;

/**
 *
 * @author martellocauda
 */
public class AccessLevel {

    private String name;
    private int level; //only 1,2,3?

    public AccessLevel() {
        this.name = "";
        this.level = 1;
    }

    public AccessLevel(String name, int level) throws AccessLevelException {
        this.name = name;
        checkLevel(level);
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    private void checkLevel(int level) throws AccessLevelException {
        if (level > 3 || level < 1) {
            throw new AccessLevelException("The level cannot be lower than 1 or grather than 3.");
        }
    }

    public void setLevel(int level) throws AccessLevelException {
        checkLevel(level);
        this.level = level;
    }

    @Override
    public boolean equals(Object obj) { //check this
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AccessLevel other = (AccessLevel) obj;
        if (this.level != other.level) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    

}
