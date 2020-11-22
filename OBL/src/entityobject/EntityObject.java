package entityobject;

import labeling.SecurityLevel;
import java.util.Objects;

/**
 *
 * @author martellocauda
 */
public class EntityObject {

    private String name;
    private int value;
    private SecurityLevel securityLevel;

    public EntityObject() {//check this default values
        this.name = "";
        this.value = 0;
        this.securityLevel = SecurityLevel.HIGH;
    }

    public EntityObject(String name, int value, SecurityLevel securityLevel) {
        this.name = name.toLowerCase();
        this.value = value;
        this.securityLevel = securityLevel;
    }

    public EntityObject(String name, SecurityLevel securityLevel) {
        this.name = name.toLowerCase();
        this.value = 0;
        this.securityLevel = securityLevel;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SecurityLevel getSecurityLevel() {
        return this.securityLevel;
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EntityObject other = (EntityObject) obj;
        if (!Objects.equals(this.name.toLowerCase(), other.name.toLowerCase())) {
            return false;
        }
        return true;
    }
}
