package ObjectManager;

import Labeling.SecurityLevel;
import java.util.Objects;

/**
 *
 * @author martellocauda
 */
public class Object {

    private String name;
    private int value;
    private SecurityLevel securityLevel;

    public Object() {//check this default values
        this.name = "";
        this.value = 0;
        this.securityLevel = SecurityLevel.HIGH;
    }

    public Object(String name, int value, SecurityLevel securityLevel) {
        this.name = name.toLowerCase();
        this.value = value;
        this.securityLevel = securityLevel;
    }

    public Object(String name, SecurityLevel securityLevel) {
        this.name = name.toLowerCase();
        this.value = 0;
        this.securityLevel = securityLevel;
    }

    public String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name.toLowerCase();
    }

    int getValue() {
        return this.value;
    }

    void setValue(int value) {
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
        final Object other = (Object) obj;
        if (!Objects.equals(this.name.toLowerCase(), other.name.toLowerCase())) {
            return false;
        }
        return true;
    }
}
