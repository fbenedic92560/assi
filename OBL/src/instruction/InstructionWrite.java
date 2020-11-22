/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instruction;

import entityobject.EntityObject;
import entitysubject.EntitySubject;

/**
 *
 * @author Usuario
 */
public class InstructionWrite extends Instruction {
    private EntitySubject oblSubject;
    private EntityObject oblObject;
    private String nameObject;
    private Integer value;
    
    public InstructionWrite(EntitySubject oblSubject, String nameObject, Integer value) {
        this.oblSubject = oblSubject;
        this.oblObject = null;
        this.nameObject = nameObject;
        this.value = value;
    }
    
    public EntitySubject getOBLSubject() {
        return this.oblSubject;
    }
    
    public String getNameObject() {
        return this.nameObject;
    }
    
    public void setOBLObject(EntityObject oblObject) {
        this.oblObject = oblObject;
    }
    
    public void execute() {
        //
    }
}
