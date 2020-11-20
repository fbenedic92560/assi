package object_manager;

import entity.obl_object.OBLObject;
import labeling.SecurityLevel;
import java.util.List;
import java.util.ArrayList;
import object_manager.exception.ObjectManagerException;

/**
 *
 * @author martellocauda
 */
public class ObjectManager {

    private List<OBLObject> objects;

    public ObjectManager() {
        objects = new ArrayList();
    }

    public void addObject(String name, SecurityLevel securityLevel) throws ObjectManagerException {
        OBLObject object = new OBLObject(name.toLowerCase(), securityLevel);
        if (objects.contains(object)) {
            throw new ObjectManagerException("This object already exists.");
        } else {
            objects.add(object);
        }
    }

    public OBLObject getObjectByName(String objectName) throws ObjectManagerException {
        OBLObject wanted = objects.stream()
                .filter(object -> objectName.equals(object.getName().toLowerCase()))
                .findAny()
                .orElse(null);
        if (wanted == null) {
            throw new ObjectManagerException("Object not found.");
        }
        return wanted;
    }

    public int read(String objectName) throws ObjectManagerException {
        return getObjectByName(objectName).getValue();
    }

    public void write(String objectName, int value) throws ObjectManagerException {
        getObjectByName(objectName).setValue(value);
    }
}
