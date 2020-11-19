/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instruction;

import ObjectManager.Object;
import Subject.Subject;

/**
 *
 * @author Usuario
 */
public class InstructionRead {
    public void execute(Subject subject, Object object) {
        subject.setTemp(object.getValue());
    }
}
