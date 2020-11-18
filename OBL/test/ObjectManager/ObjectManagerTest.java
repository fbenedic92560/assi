package ObjectManager;

import Labeling.SecurityLevel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ObjectManager.Exceptions.ObjectManagerException;

/**
 *
 * @author martellocauda
 */
public class ObjectManagerTest {

    public ObjectManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testAddObjectOK() throws ObjectManagerException {
        ObjectManager objectManager = new ObjectManager();
        try {
            objectManager.addObject("hobj", SecurityLevel.HIGH);
        } catch (ObjectManagerException e) {
            throw e;
        }
        assertTrue(Boolean.TRUE);
    }

    @Test
    public void testAddObjectOK2() throws ObjectManagerException {
        ObjectManager objectManager = new ObjectManager();
        try {
            objectManager.addObject("hobj", SecurityLevel.HIGH);
            objectManager.addObject("mobj", SecurityLevel.MEDIUM);
        } catch (ObjectManagerException e) {
            throw e;
        }
        assertTrue(Boolean.TRUE);
    }

    @Test
    public void testAddObjectFAIL() throws ObjectManagerException {
        ObjectManager objectManager = new ObjectManager();
        try {
            objectManager.addObject("hobj", SecurityLevel.HIGH);
            objectManager.addObject("hobj", SecurityLevel.HIGH);
            assertTrue(Boolean.FALSE);
        } catch (ObjectManagerException e) {
            assertEquals("This object already exists.", e.getMessage());
        }
    }

    @Test
    public void testAddObjectFAIL2() throws ObjectManagerException {
        ObjectManager objectManager = new ObjectManager();
        try {
            objectManager.addObject("hobj", SecurityLevel.HIGH);
            objectManager.addObject("HoBJ", SecurityLevel.HIGH);
            assertTrue(Boolean.FALSE);
        } catch (ObjectManagerException e) {
            assertEquals("This object already exists.", e.getMessage());
        }
    }

    @Test
    public void testGetObjectByNameOK() throws ObjectManagerException {
        ObjectManager objectManager = new ObjectManager();
        try {
            objectManager.addObject("lobj", SecurityLevel.LOW);
        } catch (ObjectManagerException e) {
            throw e;
        }
        assertEquals(new Object("lobj", SecurityLevel.LOW), objectManager.getObjectByName("lobj"));
    }

    @Test
    public void testGetObjectByNameFAIL() throws ObjectManagerException {
        ObjectManager objectManager = new ObjectManager();
        try {
            objectManager.addObject("lobj", SecurityLevel.LOW);
            objectManager.getObjectByName("hobj");
            assertTrue(Boolean.FALSE);
        } catch (ObjectManagerException e) {
            assertEquals("Object not found.", e.getMessage());
        }
    }

    @Test
    public void testGetObjectByNameFAIL2() throws ObjectManagerException {
        ObjectManager objectManager = new ObjectManager();
        try {
            objectManager.getObjectByName("hobj");
            assertTrue(Boolean.FALSE);
        } catch (ObjectManagerException e) {
            assertEquals("Object not found.", e.getMessage());
        }
    }

    @Test
    public void testReadOK() throws ObjectManagerException {
        ObjectManager objectManager = new ObjectManager();
        int value = 100;
        try {
            objectManager.addObject("mobj", SecurityLevel.MEDIUM);
            value = objectManager.read("mobj");
        } catch (ObjectManagerException e) {
            throw e;
        }
        assertEquals(0, value);
    }

    @Test
    public void testReadFAIL() throws ObjectManagerException {
        ObjectManager objectManager = new ObjectManager();
        int value = 100;
        try {
            objectManager.addObject("mobj", SecurityLevel.MEDIUM);
            value = objectManager.read("hobj");
            assertTrue(Boolean.FALSE);
        } catch (ObjectManagerException e) {
            assertEquals("Object not found.", e.getMessage());
        }
    }

    @Test
    public void testWriteOK() throws ObjectManagerException {
        ObjectManager objectManager = new ObjectManager();
        int value = 0;
        try {
            objectManager.addObject("mobj", SecurityLevel.MEDIUM);
            objectManager.write("mobj", 5);
            value = objectManager.read("mobj");
        } catch (ObjectManagerException e) {
            throw e;
        }
        assertEquals(5, value);
    }

    @Test
    public void testWriteOK2() throws ObjectManagerException {
        ObjectManager objectManager = new ObjectManager();
        int value = 0;
        try {
            objectManager.addObject("mobj", SecurityLevel.MEDIUM);
            objectManager.write("mobj", 5);
            objectManager.write("mobj", 1000);
            value = objectManager.read("mobj");
        } catch (ObjectManagerException e) {
            throw e;
        }
        assertEquals(1000, value);
    }

    @Test
    public void testWriteFAIL() throws ObjectManagerException {
        ObjectManager objectManager = new ObjectManager();
        int value = 100;
        try {
            objectManager.addObject("mobj", SecurityLevel.MEDIUM);
            objectManager.write("lobj", 5);
            assertTrue(Boolean.FALSE);
        } catch (ObjectManagerException e) {
            assertEquals("Object not found.", e.getMessage());
        }
    }
}
