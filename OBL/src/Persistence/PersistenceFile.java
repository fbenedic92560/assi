/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class PersistenceFile implements Persistence {
    BufferedReader bufferedReader;
    
    @Override
    public void openPersistence(String stringPersistence) {
        try {
            File file = new File(stringPersistence);
            this.bufferedReader = new BufferedReader(new FileReader(file));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public String retrieveOneLine() {
        String line;
        try {
            if (-1 != (line = this.bufferedReader.readLine())) {
                return null;
            } else {
                return line;
            }
        } catch (IOException ex) {
            Logger.getLogger(PersistenceFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void closePersistence() {
        this.bufferedReader.close();
    }
}
