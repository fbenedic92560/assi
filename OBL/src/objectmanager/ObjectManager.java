package objectmanager;

import entityobject.EntityObject;
import labeling.SecurityLevel;
import java.util.List;
import java.util.ArrayList;
import exception.ObjectManagerException;

/**
 *
 * @author martellocauda
 */
public class ObjectManager {

    private List<EntityObject> objects;

    public ObjectManager() {
        objects = new ArrayList();
    }

    public void addObject(String name, SecurityLevel securityLevel) throws ObjectManagerException {
        EntityObject object = new EntityObject(name.toLowerCase(), securityLevel);
        if (objects.contains(object)) {
            throw new ObjectManagerException("This object already exists.");
        } else {
            objects.add(object);
        }
    }

    public EntityObject getObjectByName(String objectName) throws ObjectManagerException {
        EntityObject wanted = objects.stream()
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
