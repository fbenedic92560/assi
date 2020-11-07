/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InstructionObject;

/**
 *
 * @author Usuario
 */
public class InstructionReadValidator extends InstructionValidator {
    @Override
    public Boolean validate(String instruction) {
        String[] elementsInstruction = instruction.split(" .");
        if (elementsInstruction.length != 3) {
            System.out.println("Sentencia READ incorrecta");
            return Boolean.FALSE;
        }
        if (elementsInstruction[0].toLowerCase() != "READ") {
            System.out.println("Sentencia no reconocida");
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}