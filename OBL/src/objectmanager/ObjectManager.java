package objectmanager;

import entityobject.EntityObject;
import entitysubject.EntitySubject;
import labeling.SecurityLevel;
import java.util.List;
import java.util.ArrayList;
import exception.ObjectManagerException;

/**
 *
 * @author martellocauda
 */
public class ObjectManager {

    private List<EntityObject> listOfEntityObjects;

    public ObjectManager() {
        this.listOfEntityObjects = new ArrayList<EntityObject>();
    }

    public void addObject(String name, SecurityLevel securityLevel) throws ObjectManagerException {
        EntityObject entityObject = new EntityObject(name.toLowerCase(), securityLevel);
        if (this.listOfEntityObjects.contains(entityObject)) {
            throw new ObjectManagerException("This object already exists.");
        } else {
            this.listOfEntityObjects.add(entityObject);
        }
    }

    public EntityObject getObjectByName(String objectName) throws ObjectManagerException {
        EntityObject wanted = this.listOfEntityObjects.stream()
                .filter(object -> objectName.equals(object.getName().toLowerCase()))
                .findAny()
                .orElse(null);
        if (wanted == null) {
            throw new ObjectManagerException("Object not found.");
        }
        return wanted;
    }

    public void read(EntitySubject entitySubject, EntityObject entityObject) throws ObjectManagerException {
        Integer value = entityObject.getValue();
        entitySubject.setTemp(value);
    }

    public void write(EntityObject entityObject, Integer value) throws ObjectManagerException {
        entityObject.setValue(value);
    }
}
