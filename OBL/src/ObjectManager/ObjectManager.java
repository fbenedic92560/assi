package ObjectManager;

import java.util.List;
import java.util.ArrayList;
import ObjectManager.Exceptions.ObjectManagerException;

/**
 *
 * @author martellocauda
 */
public class ObjectManager {
    
    private List<Object> objects;
    
    public ObjectManager() {
        objects = new ArrayList();
    }
    
    public void addObject(Object object) throws ObjectManagerException {
        if (objects.contains(object)) {
            throw new ObjectManagerException("This object already exists.");
        } else {
            objects.add(object);
        }
    }
    
    private Object getObjectByName(String objectName) throws ObjectManagerException {
        Object wanted = objects.stream()
                .filter(object -> objectName.equals(object.getName()))
                .findAny()
                .orElse(null);
        if (wanted == null) {
            throw new ObjectManagerException("Object not found.");
        }
        return wanted;
    }
    
    public int read(String objectName) throws ObjectManagerException {
        try {
            return getObjectByName(objectName).getValue();
        } catch (ObjectManagerException e) {
            throw e;
        }
    }
    
    public void write(String objectName, int value) throws ObjectManagerException {
        try {
            getObjectByName(objectName).setValue(value);
        } catch (ObjectManagerException e) {
            throw e;
        }
    }
}
