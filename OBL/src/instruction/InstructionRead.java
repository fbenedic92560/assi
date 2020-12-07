/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instruction;

import entitysubject.EntitySubject;

/**
 *
 * @author Usuario
 */
public class InstructionRead extends Instruction {
    private EntitySubject entitySubject;
    private String objectName;
    
    public InstructionRead(EntitySubject entitySubject, String objectName) {
        this.entitySubject = entitySubject;
        this.objectName = objectName;
    }
    
    public EntitySubject getEntitySubject() {
        return this.entitySubject;
    }
    
    public String getObjectName() {
        return this.objectName;
    }
       
    public void execute() {
        //
    }
}
