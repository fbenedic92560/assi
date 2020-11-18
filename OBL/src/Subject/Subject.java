package Subject;

import Labeling.SecurityLevel;
import ObjectManager.Exceptions.ObjectManagerException;
import ObjectManager.ObjectManager;
import Subject.Exceptions.SubjectException;
import java.util.Objects;

/**
 *
 * @author martellocauda
 */
public class Subject {

    private String name;
    private int temp;
    private SecurityLevel securityLevel;

    public Subject() {//check this default values
        this.name = "";
        this.temp = 0;
        this.securityLevel = SecurityLevel.LOW;
    }

    public Subject(String name, SecurityLevel securityLevel) {
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
        final Subject other = (Subject) obj;
        if (!Objects.equals(this.name.toLowerCase(), other.name.toLowerCase())) {
            return false;
        }
        return true;
    }

}
