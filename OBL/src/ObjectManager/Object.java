package ObjectManager;

import Labeling.SensibilityLabel;
import java.util.Objects;

/**
 *
 * @author martellocauda
 */
public class Object {

    private String name;
    private int value;
    private SensibilityLabel sensibilityLabel;

    public Object() {//check this default values
        this.name = "";
        this.value = 0;
        this.sensibilityLabel = new SensibilityLabel();
    }

    public Object(String name, int value, SensibilityLabel sensibilityLabel) {
        this.name = name;
        this.value = value;
        this.sensibilityLabel = sensibilityLabel;
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

    public SensibilityLabel getSensibilityLabel() {
        return this.sensibilityLabel;
    }

    public void setSensibilityLevel(SensibilityLabel sensibilityLabel) {
        this.sensibilityLabel = sensibilityLabel;
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
