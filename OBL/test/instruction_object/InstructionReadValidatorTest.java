/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instruction_object;

import instruction.validator.InstructionReadValidator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class InstructionReadValidatorTest {
    
    public InstructionReadValidatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of validate method, of class InstructionReadValidator.
     */
    @Test
    public void testValidateLegalInstruction() {
        String instruction = "read subject object";
        InstructionReadValidator instance = new InstructionReadValidator();
        Boolean expResult = Boolean.TRUE;
        Boolean result = instance.validate(instruction);
        assertEquals(expResult, result);
    }
    @Test
    public void testValidateIlegalInstruction() {
        String instruction = "rad subject object";
        InstructionReadValidator instance = new InstructionReadValidator();
        Boolean expResult = Boolean.FALSE;
        Boolean result = instance.validate(instruction);
        assertEquals(expResult, result);
    }    
    @Test
    public void testValidateWithoutObject() {
        String instruction = "read subject";
        InstructionReadValidator instance = new InstructionReadValidator();
        Boolean expResult = Boolean.FALSE;
        Boolean result = instance.validate(instruction);
        assertEquals(expResult, result);
    }    
    @Test
    public void testValidateWithoutSubjectOrObject() {
        String instruction = "read";
        InstructionReadValidator instance = new InstructionReadValidator();
        Boolean expResult = Boolean.FALSE;
        Boolean result = instance.validate(instruction);
        assertEquals(expResult, result);
    }    
}
