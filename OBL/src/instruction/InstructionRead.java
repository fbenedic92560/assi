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
public class InstructionRead extends Instruction {
    private EntitySubject oblSubject;
    private EntityObject oblObject;
    private String nameObject;
    
    public InstructionRead(EntitySubject oblSubject, String nameObject) {
        this.oblSubject = oblSubject;
        this.oblObject = null;
        this.nameObject = nameObject;
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
