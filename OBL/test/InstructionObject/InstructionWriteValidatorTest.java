/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InstructionObject;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class InstructionWriteValidatorTest {
    
    public InstructionWriteValidatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of validate method, of class InstructionWriteValidator.
     */
    @Test
    public void testValidateLegalInstruction() {
        String instruction = "write subject object value";
        InstructionWriteValidator instance = new InstructionWriteValidator();
        Boolean expResult = Boolean.TRUE;
        Boolean result = instance.validate(instruction);
        assertEquals(expResult, result);
    }
    @Test
    public void testValidateIlegalInstruction() {
        String instruction = "wrte subject object value";
        InstructionWriteValidator instance = new InstructionWriteValidator();
        Boolean expResult = Boolean.FALSE;
        Boolean result = instance.validate(instruction);
        assertEquals(expResult, result);
    }    
    @Test
    public void testValidateWithoutValue() {
        String instruction = "write subject object";
        InstructionWriteValidator instance = new InstructionWriteValidator();
        Boolean expResult = Boolean.FALSE;
        Boolean result = instance.validate(instruction);
        assertEquals(expResult, result);
    }    
    @Test
    public void testValidateWithoutValueOrObject() {
        String instruction = "write subject";
        InstructionWriteValidator instance = new InstructionWriteValidator();
        Boolean expResult = Boolean.FALSE;
        Boolean result = instance.validate(instruction);
        assertEquals(expResult, result);
    }        
    @Test
    public void testValidateWithoutValueOrObjectOrSubject() {
        String instruction = "write";
        InstructionWriteValidator instance = new InstructionWriteValidator();
        Boolean expResult = Boolean.FALSE;
        Boolean result = instance.validate(instruction);
        assertEquals(expResult, result);
    }        
}
