package ReferenceMonitor;

import ObjectManager.ObjectManager;
import ObjectManager.Object;
import Labeling.SecurityLevel;
import ObjectManager.Exceptions.ObjectManagerException;
import ReferenceMonitor.Exceptions.ReferenceMonitorException;
import Subject.Subject;

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

    public Subject createNewSubject(String name, SecurityLevel securityLevel) {
        return new Subject(name, securityLevel);
    }

    private void verifyIfItCanRead(Subject subject, Object object) throws ReferenceMonitorException {
        if (subject.getSecurityLevel().ordinal() < object.getSecurityLevel().ordinal()) {
            throw new ReferenceMonitorException("The subject "
                    + subject.getName()
                    + " cannot perform a READ over the object "
                    + object.getName() + " according with BLP rules.");
        }
    }

    private void verifyIfItCanWrite(Subject subject, Object object) throws ReferenceMonitorException {
        if (object.getSecurityLevel().ordinal() < subject.getSecurityLevel().ordinal()) {
            throw new ReferenceMonitorException("The subject "
                    + subject.getName()
                    + " cannot perform a WRITE over the object "
                    + object.getName() + " according with BLP rules.");
        }
    }

    public int executeRead(Subject subject, String objectName) throws ReferenceMonitorException {
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

    public void executeWrite(Subject subject, String objectName, int value) throws ReferenceMonitorException {
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
