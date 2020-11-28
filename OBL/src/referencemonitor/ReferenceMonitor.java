package referencemonitor;

import objectmanager.ObjectManager;
import entityobject.EntityObject;
import labeling.SecurityLevel;
import exception.ObjectManagerException;
import exception.ReferenceMonitorException;
import entitysubject.EntitySubject;
import instruction.Instruction;
import instruction.InstructionRead;
import instruction.InstructionWrite;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author martellocauda
 */
public class ReferenceMonitor {

    private ObjectManager objectManager;

    public ReferenceMonitor() {
        this.objectManager = new ObjectManager();
    }

    public void printObjectsInfo() {
        this.objectManager.printStateOfEntityObjects();
    }

    public void createEntityObject(String name, SecurityLevel securityLevel) throws ReferenceMonitorException {
        try {
            this.objectManager.create(name, securityLevel);
        } catch (ObjectManagerException e) {
            throw new ReferenceMonitorException(e.getMessage());
        }
    }

    public EntitySubject createEntitySubject(String name, SecurityLevel securityLevel) {
        return new EntitySubject(name, securityLevel);
    }

    public void destroyEntityObject(EntitySubject subject, String objectName) throws ReferenceMonitorException {
        try {
            verifyIfItCanWrite(subject, objectManager.getObjectByName(objectName));
            this.objectManager.destroy(objectName);
        } catch (ObjectManagerException e) {
            throw new ReferenceMonitorException(e.getMessage());
        }
    }

    private void verifyIfItCanRead(EntitySubject subject, EntityObject object) throws ReferenceMonitorException {
        if (subject.getSecurityLevel().ordinal() < object.getSecurityLevel().ordinal()) {
            throw new ReferenceMonitorException("The subject "
                    + subject.getName()
                    + " cannot perform a READ over the object "
                    + object.getName() + " according with BLP rules.");
        }
    }

    private void verifyIfItCanWrite(EntitySubject subject, EntityObject object) throws ReferenceMonitorException {
        if (object.getSecurityLevel().ordinal() < subject.getSecurityLevel().ordinal()) {
            throw new ReferenceMonitorException("The subject "
                    + subject.getName()
                    + " cannot perform a WRITE over the object "
                    + object.getName() + " according with BLP rules.");
        }
    }

    public void executeInstruction(Instruction instruction) {
        Integer value;
        EntitySubject entitySubject;
        String objectName;

        switch (instruction.getClass().toString()) {
            case "InstructionRead":
                entitySubject = ((InstructionRead) instruction).getEntitySubject();
                objectName = ((InstructionRead) instruction).getObjectName();
                try {
                    this.executeRead(entitySubject, objectName);
                } catch (ReferenceMonitorException ex) {
                    Logger.getLogger(ReferenceMonitor.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "InstructionWrite":
                entitySubject = ((InstructionWrite) instruction).getEntitySubject();
                objectName = ((InstructionWrite) instruction).getObjectName();
                value = ((InstructionWrite) instruction).getValue();
                try {
                    this.executeWrite(entitySubject, objectName, value);
                } catch (ReferenceMonitorException ex) {
                    Logger.getLogger(ReferenceMonitor.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
        }
    }

    private void executeRead(EntitySubject entitySubject, String objectName) throws ReferenceMonitorException {
        EntityObject entityObject;

        try {
            entityObject = this.objectManager.getObjectByName(objectName);
            verifyIfItCanRead(entitySubject, entityObject);
            this.objectManager.read(entitySubject, entityObject);
        } catch (ObjectManagerException e) {
            throw new ReferenceMonitorException(e.getMessage());
        }
    }

    private void executeWrite(EntitySubject subject, String objectName, Integer value) throws ReferenceMonitorException {
        EntityObject entityObject;

        try {
            entityObject = this.objectManager.getObjectByName(objectName);
            verifyIfItCanWrite(subject, objectManager.getObjectByName(objectName));
            this.objectManager.write(entityObject, value);
        } catch (ObjectManagerException e) {
            throw new ReferenceMonitorException(e.getMessage());
        }
    }
}
