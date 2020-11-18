package ReferenceMonitor;

import Labeling.SecurityLevel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ReferenceMonitor.Exceptions.ReferenceMonitorException;

/**
 *
 * @author martellocauda
 */
public class ReferenceMonitorTest {

    public ReferenceMonitorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testCreateNewObjectOK() throws ReferenceMonitorException {
        ReferenceMonitor referenceMonitor = new ReferenceMonitor();
        try {
            referenceMonitor.createNewObject("hobj", SecurityLevel.HIGH);
        } catch (ReferenceMonitorException e) {
            throw e;
        }
        assertTrue(Boolean.TRUE);
    }

    @Test
    public void testCreateNewObjectFAIL() throws ReferenceMonitorException {
        ReferenceMonitor referenceMonitor = new ReferenceMonitor();
        try {
            referenceMonitor.createNewObject("hobj", SecurityLevel.HIGH);
            referenceMonitor.createNewObject("hobj", SecurityLevel.HIGH);
            assertTrue(Boolean.FALSE);
        } catch (ReferenceMonitorException e) {
            assertEquals("This object already exists.", e.getMessage());
        }
    }

    @Test
    public void testCreateNewObjectFAIL2() throws ReferenceMonitorException {
        ReferenceMonitor referenceMonitor = new ReferenceMonitor();
        try {
            referenceMonitor.createNewObject("hobj", SecurityLevel.HIGH);
            referenceMonitor.createNewObject("hobj", SecurityLevel.LOW);
            assertTrue(Boolean.FALSE);
        } catch (ReferenceMonitorException e) {
            assertEquals("This object already exists.", e.getMessage());
        }
    }

    @Test
    public void testCreateNewObjectFAIL3() throws ReferenceMonitorException {
        ReferenceMonitor referenceMonitor = new ReferenceMonitor();
        try {
            referenceMonitor.createNewObject("hobj", SecurityLevel.HIGH);
            referenceMonitor.createNewObject("HobJ", SecurityLevel.LOW);
            assertTrue(Boolean.FALSE);
        } catch (ReferenceMonitorException e) {
            assertEquals("This object already exists.", e.getMessage());
        }
    }

    @Test
    public void createNewSubjectOK() throws ReferenceMonitorException {
        ReferenceMonitor referenceMonitor = new ReferenceMonitor();
        assertEquals("hal", referenceMonitor.createNewSubject("hal", SecurityLevel.HIGH).getName());
    }

    @Test
    public void createNewSubjectOK2() throws ReferenceMonitorException {
        ReferenceMonitor referenceMonitor = new ReferenceMonitor();
        assertEquals(SecurityLevel.HIGH, referenceMonitor.createNewSubject("hal", SecurityLevel.HIGH).getSecurityLevel());
    }

    @Test
    public void createNewSubjectOK3() throws ReferenceMonitorException {
        ReferenceMonitor referenceMonitor = new ReferenceMonitor();
        assertEquals("lyle", referenceMonitor.createNewSubject("LyLE", SecurityLevel.HIGH).getName());
    }

    @Test
    public void executeReadOK() throws ReferenceMonitorException {
        ReferenceMonitor referenceMonitor = new ReferenceMonitor();
        int value = 100;
        try {
            referenceMonitor.createNewObject("hobj", SecurityLevel.HIGH);
        } catch (ReferenceMonitorException e) {
        }
        try {
            value = referenceMonitor.executeRead(
                    referenceMonitor.createNewSubject("hal", SecurityLevel.HIGH),
                    "hobj");
        } catch (ReferenceMonitorException e) {
            throw e;
        }
        assertEquals(0, value);
    }

    @Test
    public void executeReadOK2() throws ReferenceMonitorException {
        ReferenceMonitor referenceMonitor = new ReferenceMonitor();
        int value = 0;
        try {
            referenceMonitor.createNewObject("lobj", SecurityLevel.LOW);
        } catch (ReferenceMonitorException e) {
        }
        try {
            referenceMonitor.executeWrite(
                    referenceMonitor.createNewSubject("lyle", SecurityLevel.LOW),
                    "lobj",
                    2);
            value = referenceMonitor.executeRead(
                    referenceMonitor.createNewSubject("moe", SecurityLevel.MEDIUM),
                    "lobj");
        } catch (ReferenceMonitorException e) {
            throw e;
        }
        assertEquals(2, value);
    }

    @Test
    public void executeReadFAIL() throws ReferenceMonitorException {
        ReferenceMonitor referenceMonitor = new ReferenceMonitor();
        int value = 0;
        try {
            referenceMonitor.createNewObject("hobj", SecurityLevel.HIGH);
        } catch (ReferenceMonitorException e) {
        }
        try {
            referenceMonitor.executeRead(
                    referenceMonitor.createNewSubject("moe", SecurityLevel.MEDIUM),
                    "hobj");
            assertTrue(Boolean.FALSE);
        } catch (ReferenceMonitorException e) {
            assertEquals("The subject moe cannot perform a READ over the object hobj according with BLP rules.", e.getMessage());
        }
    }

    @Test
    public void executeWriteOK() throws ReferenceMonitorException {
        ReferenceMonitor referenceMonitor = new ReferenceMonitor();
        int value = 0;
        try {
            referenceMonitor.createNewObject("mobj", SecurityLevel.MEDIUM);
        } catch (ReferenceMonitorException e) {
        }
        try {
            referenceMonitor.executeWrite(
                    referenceMonitor.createNewSubject("moe", SecurityLevel.MEDIUM),
                    "mobj", 2);
        } catch (ReferenceMonitorException e) {
            throw e;
        }
        value = referenceMonitor.executeRead(
                referenceMonitor.createNewSubject("moe", SecurityLevel.MEDIUM),
                "mobj");
        assertEquals(2, value);
    }

    @Test
    public void executeWriteFAIL() throws ReferenceMonitorException {
        ReferenceMonitor referenceMonitor = new ReferenceMonitor();
        int value = 0;
        try {
            referenceMonitor.createNewObject("mobj", SecurityLevel.MEDIUM);
        } catch (ReferenceMonitorException e) {
        }
        try {
            referenceMonitor.executeWrite(
                    referenceMonitor.createNewSubject("hal", SecurityLevel.HIGH),
                    "mobj", 2);
            assertTrue(Boolean.FALSE);
        } catch (ReferenceMonitorException e) {
            assertEquals("The subject hal cannot perform a WRITE over the object mobj according with BLP rules.", e.getMessage());
        }
    }

}
