/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inpresferriesserveur_xml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Sh1fT
 */

public final class SAXParsing {
    protected String xmlFilename;
    protected File xmlFile;
    protected InputSource xmlSource;
    protected DefaultHandler gestionnaire;

    /**
     * Creates new instance SAXParsing
     * @param xmlFilename
     * @param gestionnaire 
     */
    public SAXParsing(String xmlFilename, DefaultHandler gestionnaire) {
        this.setXmlFilename(xmlFilename);
        this.setXmlFile(null);
        this.setXmlSource(null);
        this.setGestionnaire(gestionnaire);
        this.parseSAX();
    }

    /**
     * Creates new instance SAXParsing
     * @param xmlFile
     * @param gestionnaire 
     */
    public SAXParsing(File xmlFile, DefaultHandler gestionnaire) {
        this.setXmlFilename(null);
        this.setXmlFile(xmlFile);
        this.setXmlSource(null);
        this.setGestionnaire(gestionnaire);
        this.parseSAX();
    }

    /**
     * Creates new instance SAXParsing
     * @param xmlSource
     * @param gestionnaire 
     */
    public SAXParsing(InputSource xmlSource, DefaultHandler gestionnaire) {
        this.setXmlFilename(null);
        this.setXmlFile(null);
        this.setXmlSource(xmlSource);
        this.setGestionnaire(gestionnaire);
        this.parseSAX();
    }

    /**
     * Creates new instance SAXParsing
     * @param xmlFilename
     */
    public SAXParsing(String xmlFilename) {
        this.setXmlFilename(xmlFilename);
        this.setXmlFile(null);
        this.setXmlSource(null);
        this.setGestionnaire(new FerryHandler());
        this.parseSAX();
    }

    /**
     * Creates new instance SAXParsing
     * @param xmlFile
     */
    public SAXParsing(File xmlFile) {
        this.setXmlFilename(null);
        this.setXmlFile(xmlFile);
        this.setXmlSource(null);
        this.setGestionnaire(new FerryHandler());
        this.parseSAX();
    }

    /**
     * Creates new instance SAXParsing
     * @param xmlSource
     */
    public SAXParsing(InputSource xmlSource) {
        this.setXmlFilename(null);
        this.setXmlFile(null);
        this.setXmlSource(xmlSource);
        this.setGestionnaire(new FerryHandler());
        this.parseSAX();
    }

    public String getXmlFilename() {
        return this.xmlFilename;
    }

    protected void setXmlFilename(String xmlFilename) {
        this.xmlFilename = xmlFilename;
    }

    public File getXmlFile() {
        return this.xmlFile;
    }

    protected void setXmlFile(File xmlFile) {
        this.xmlFile = xmlFile;
    }

    public InputSource getXmlSource() {
        return this.xmlSource;
    }

    protected void setXmlSource(InputSource xmlSource) {
        this.xmlSource = xmlSource;
    }

    public DefaultHandler getGestionnaire() {
        return this.gestionnaire;
    }

    protected void setGestionnaire(DefaultHandler gestionnaire) {
        this.gestionnaire = gestionnaire;
    }

    /**
     * Permet le parsing d'un fichier XML par SAX
     */
    protected void parseSAX() {
        try {
            SAXParserFactory fabrique = SAXParserFactory.newInstance();
            fabrique.setValidating(true);
            SAXParser parseur = fabrique.newSAXParser();
            if (this.getXmlFilename() != null)
                parseur.parse(new File(this.getXmlFilename()), this.getGestionnaire());
            if (this.getXmlFile() != null)
                parseur.parse(this.getXmlFile(), this.getGestionnaire());
            if (this.getXmlSource() != null)
                parseur.parse(this.getXmlSource(), this.getGestionnaire());
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        }
    }
}