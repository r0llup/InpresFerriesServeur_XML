/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inpresferriesserveur_xml;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Sh1fT
 */

public final class TXTLoader {
    protected String filename;
    protected BufferedReader bufferedReader;

    /**
     * Creates new instance TXTLoader
     * @param filename 
     */
    public TXTLoader(String filename) {
        this.setFilename(filename);
        this.loadFile();
    }

    public String getFilename() {
        return this.filename;
    }

    protected void setFilename(String filename) {
        this.filename = filename;
    }

    public BufferedReader getBufferedReader() {
        return this.bufferedReader;
    }

    protected void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    /**
     * Load The TXT File
     */
    protected void loadFile() {
        try {
            FileInputStream fis = new FileInputStream(this.getFilename()); 
            InputStreamReader isr = new InputStreamReader(fis);
            this.setBufferedReader(new BufferedReader(isr));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        }
    }

    /**
     * Retrieve Data From The TXT File
     * @return 
     */
    public List<String> retrieveData() {
        try {
            List<String> listeString = new LinkedList<String>();
            String ligne;
            while ((ligne = this.getBufferedReader().readLine()) != null)
                listeString.add(ligne);
            this.getBufferedReader().close();
            return listeString;
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        }
        return null;
    }
}