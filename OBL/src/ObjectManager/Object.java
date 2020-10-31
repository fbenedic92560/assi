package ObjectManager;

import java.util.Objects;

/**
 *
 * @author martellocauda
 */
public class Object {

    private String name;
    private int value;
    private java.lang.Object sensibilityLevel;//change for SensibilityLevel when created

    public Object() {//check this default values
        this.name = "";
        this.value = 0;
        this.sensibilityLevel = new java.lang.Object();
    }

    public Object(String name, int value, java.lang.Object sensibilityLevel) {
        this.name = name;
        this.value = value;
        this.sensibilityLevel = sensibilityLevel;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public java.lang.Object getSensibilityLavel() {//change for SensibilityLevel when created
        return this.sensibilityLevel;
    }

    public void setSensibilityLevel(java.lang.Object sensibilityLevel) {//change for SensibilityLevel when created
        this.sensibilityLevel = sensibilityLevel;
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
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
}
