package Subject;

import Labeling.AuthorizationLabel;
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
    private AuthorizationLabel authorizationLabel;

    public Subject() {//check this default values
        this.name = "";
        this.temp = 0;
        this.authorizationLabel = new AuthorizationLabel();
    }

    public Subject(String name, AuthorizationLabel authorizationLabel) {
        this.name = name;
        this.temp = 0;
        this.authorizationLabel = authorizationLabel;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTemp() {
        return this.temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public AuthorizationLabel getAuthorizationLabel() {
        return this.authorizationLabel;
    }

    public void setAuthorizationLevel(AuthorizationLabel authorizationLabel) {
        this.authorizationLabel = authorizationLabel;
    }

    public int read(ObjectManager objectManager, String name) throws SubjectException {
        int value;
        try {
            value = objectManager.read(name);
        } catch (ObjectManagerException e) {
            throw new SubjectException(e.getMessage());
        }
        this.temp = value;
        return value;
    }

    public void write(ObjectManager objectManager, String name, int value) throws SubjectException {
        try {
            objectManager.write(name, value);
        } catch (ObjectManagerException e) {
            throw new SubjectException(e.getMessage());
        }
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
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

}
