package reference_monitor;

import object_manager.ObjectManager;
import entity.obl_object.OBLObject;
import labeling.SecurityLevel;
import object_manager.exception.ObjectManagerException;
import reference_monitor.exception.ReferenceMonitorException;
import entity.obl_subject.OBLSubject;

/**
 *
 * @author martellocauda
 */
public class ReferenceMonitor {

    private ObjectManager objectManager;

    public ReferenceMonitor() {
        this.objectManager = new ObjectManager();
    }

    public void createNewObject(String name, SecurityLevel securityLevel) throws ReferenceMonitorException {
        try {
            objectManager.addObject(name, securityLevel);
        } catch (ObjectManagerException e) {
            throw new ReferenceMonitorException(e.getMessage());
        }
    }

    public OBLSubject createNewSubject(String name, SecurityLevel securityLevel) {
        return new OBLSubject(name, securityLevel);
    }

    private void verifyIfItCanRead(OBLSubject subject, OBLObject object) throws ReferenceMonitorException {
        if (subject.getSecurityLevel().ordinal() < object.getSecurityLevel().ordinal()) {
            throw new ReferenceMonitorException("The subject "
                    + subject.getName()
                    + " cannot perform a READ over the object "
                    + object.getName() + " according with BLP rules.");
        }
    }

    private void verifyIfItCanWrite(OBLSubject subject, OBLObject object) throws ReferenceMonitorException {
        if (object.getSecurityLevel().ordinal() < subject.getSecurityLevel().ordinal()) {
            throw new ReferenceMonitorException("The subject "
                    + subject.getName()
                    + " cannot perform a WRITE over the object "
                    + object.getName() + " according with BLP rules.");
        }
    }

    public int executeRead(OBLSubject subject, String objectName) throws ReferenceMonitorException {
        int value;
        try {
            verifyIfItCanRead(subject, objectManager.getObjectByName(objectName));
        } catch (ObjectManagerException e) {
            throw new ReferenceMonitorException(e.getMessage());
        }
        try {
            value = objectManager.read(objectName);
        } catch (ObjectManagerException e) {
            throw new ReferenceMonitorException(e.getMessage());
        }
        subject.setTemp(value);
        return value;
    }

    public void executeWrite(OBLSubject subject, String objectName, int value) throws ReferenceMonitorException {
        try {
            verifyIfItCanWrite(subject, objectManager.getObjectByName(objectName));
        } catch (ObjectManagerException e) {
            throw new ReferenceMonitorException(e.getMessage());
        }
        try {
            objectManager.write(objectName, value);
        } catch (ObjectManagerException e) {
            throw new ReferenceMonitorException(e.getMessage());
        }
    }
}
