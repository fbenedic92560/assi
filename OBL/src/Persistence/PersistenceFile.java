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
    
    public PersistenceFile() {
        this.bufferedReader = null;
    }
    
    @Override
    public Boolean openPersistence(String stringPersistence) {
        try {
            File file = new File(stringPersistence);
            this.bufferedReader = new BufferedReader(new FileReader(file));
            return Boolean.TRUE;
        } catch (IOException ex) {
            Logger.getLogger(PersistenceFile.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
    }
    @Override
    public String retrieveOneLine() {
        String lineBufferedReader;
        String line = null;
        if (this.bufferedReader != null) {
            try {
                lineBufferedReader = this.bufferedReader.readLine();
                if (lineBufferedReader != null) {
                    line = lineBufferedReader;
                }
            } catch (IOException ex) {
                Logger.getLogger(PersistenceFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return line;
    }
    @Override
    public Boolean closePersistence() {
        try {
            this.bufferedReader.close();
            return Boolean.TRUE;
        } catch (IOException ex) {
            Logger.getLogger(PersistenceFile.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }
    }
}