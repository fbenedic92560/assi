/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

/**
 *
 * @author Usuario
 */
public interface Persistence {
    public Boolean openPersistence(String stringPersistence);
    public String retrieveOneLine();
    public Boolean closePersistence();
}
