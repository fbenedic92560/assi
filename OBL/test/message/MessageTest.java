/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class MessageTest {
    
    public MessageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of convertMessageToBitsArray method, of class Message.
     */
    @Test
    public void testConvertMessageOneCharacterToBitsArray() {
        String message = "m";
        Message instance = new Message();
        String expResult = "01101101";
        String result = instance.convertStringToBitsArray(message);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConvertMessageToBitsArray() {
        String message = "mensaje";
        Message instance = new Message();
        String expResult = "01101101011001010110111001110011011000010110101001100101";
        String result = instance.convertStringToBitsArray(message);
        assertEquals(expResult, result);
    }    
}
