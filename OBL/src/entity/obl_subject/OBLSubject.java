package entity.obl_subject;

import labeling.SecurityLevel;
import object_manager.exception.ObjectManagerException;
import object_manager.ObjectManager;
import entity.obl_subject.exception.SubjectException;
import java.util.Objects;

/**
 *
 * @author martellocauda
 */
public class OBLSubject {

    private String name;
    private int temp;
    private SecurityLevel securityLevel;

    public OBLSubject() {//check this default values
        this.name = "";
        this.temp = 0;
        this.securityLevel = SecurityLevel.LOW;
    }

    public OBLSubject(String name, SecurityLevel securityLevel) {
        this.name = name.toLowerCase();
        this.temp = 0;
        this.securityLevel = securityLevel;
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
        final OBLSubject other = (OBLSubject) obj;
        if (!Objects.equals(this.name.toLowerCase(), other.name.toLowerCase())) {
            return false;
        }
        return true;
    }

}
