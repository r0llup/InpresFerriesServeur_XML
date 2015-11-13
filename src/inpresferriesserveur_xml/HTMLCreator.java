/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inpresferriesserveur_xml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Sh1fT
 */

public final class HTMLCreator {
    protected String xmlFilename;
    protected String xslFilename;
    protected String htmlFilename;

    /**
     * Creates new instance HTMLCreator
     * @param xmlFilename
     * @param xslFilename
     * @param htmlFilename 
     */
    public HTMLCreator(String xmlFilename, String xslFilename, String htmlFilename) {
        this.setXmlFilename(xmlFilename);
        this.setXslFilename(xslFilename);
        this.setHtmlFilename(htmlFilename);
        this.saveHTML();
    }

    public String getXmlFilename() {
        return this.xmlFilename;
    }

    protected void setXmlFilename(String xmlFilename) {
        this.xmlFilename = xmlFilename;
    }

    public String getXslFilename() {
        return this.xslFilename;
    }

    protected void setXslFilename(String xslFilename) {
        this.xslFilename = xslFilename;
    }

    public String getHtmlFilename() {
        return this.htmlFilename;
    }

    protected void setHtmlFilename(String htmlFilename) {
        this.htmlFilename = htmlFilename;
    }

    /**
     * Save To HTML
     */
    protected void saveHTML() {
        try {
            DocumentBuilderFactory fabriqueD = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructeur;
            constructeur = fabriqueD.newDocumentBuilder();
            fabriqueD.setValidating(true);
            File fileXml = new File(this.getXmlFilename());
            Document document = constructeur.parse(fileXml);
            Source source = new DOMSource(document);
            // Création du fichier de sortie
            File fileHtml = new File(this.getHtmlFilename());
            Result resultat = new StreamResult(fileHtml);
            // Configuration du transformer
            TransformerFactory fabriqueT = TransformerFactory.newInstance();
            StreamSource stylesource = new StreamSource(this.getXslFilename());
            Transformer transformer = fabriqueT.newTransformer(stylesource);
            transformer.setOutputProperty(OutputKeys.METHOD, "html");
            // Transformation
            transformer.transform(source, resultat);
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        } catch (TransformerConfigurationException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        } catch (TransformerException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        }
    }
}