/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instruction;

/**
 *
 * @author Usuario
 */
public class InstructionBad extends Instruction{
    private String message;
    
    InstructionBad(String message) {
        this.message = message;
    }
    
    public void execute() {
        //
    }
}
