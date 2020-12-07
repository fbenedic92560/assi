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
public class InstructionWrite extends Instruction {
    private EntitySubject entitySubject;
    private String objectName;
    private Integer value;
    
    public InstructionWrite(EntitySubject entitySubject, String objectName, Integer value) {
        this.entitySubject = entitySubject;
        this.objectName = objectName;
        this.value = value;
    }
    
    public EntitySubject getEntitySubject() {
        return this.entitySubject;
    }
    
    public String getObjectName() {
        return this.objectName;
    }
    
    public Integer getValue() {
        return this.value;
    }
        
    public void execute() {
        //
    }
}
