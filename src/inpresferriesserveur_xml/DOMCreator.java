/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inpresferriesserveur_xml;

import contents.Cours;
import contents.Ferry;
import contents.Freetax;
import contents.Jour;
import contents.Meteo;
import contents.Monnaie;
import contents.Product;
import contents.Situation;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Sh1fT
 */

public final class DOMCreator {
    protected String filename;
    protected Document document;

    /**
     * Creates new instance DOMCreator
     * @param filename
     * @param serveurInformations 
     */
    public DOMCreator(String filename, ServeurInformations serveurInformations) {
        this.setFilename(filename);
        this.setDocument(null);
        this.buildDOM(serveurInformations);
        this.saveDOM();
    }

    public String getFilename() {
        return this.filename;
    }

    protected void setFilename(String filename) {
        this.filename = filename;
    }

    public Document getDocument() {
        return this.document;
    }

    protected void setDocument(Document document) {
        this.document = document;
    }

    /**
     * Création d'un nouveau DOM
     * @param si 
     */
    protected void buildDOM(ServeurInformations si) {
        try {
            DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();
            fabrique.setValidating(true);
            DocumentBuilder constructeur = fabrique.newDocumentBuilder();
            this.setDocument(constructeur.newDocument());
            // Propriétés du DOM
            this.getDocument().setXmlVersion("1.0");
            //this.getDocument().setXmlStandalone(true);
            this.getDocument().setDocumentURI(si.getOutputDTDFilename());
            // Création de l'arborescence du DOM
            Element racine = this.getDocument().createElement("Ferry");
            Ferry ferry_ = si.getFerry();
            Monnaie monnaie_ = ferry_.getMonnaie();
            Meteo meteo_ = ferry_.getMeteo();
            Freetax freetax_ = ferry_.getFreetax();
            racine.setAttribute("name", ferry_.getNomFerry());
            racine.setAttribute("voyageur", ferry_.getNomVoyageur());
            if (monnaie_ != null) {
                Element monnaie = this.getDocument().createElement("Monnaie");
                for (Cours cours_ : monnaie_.getCours()) {
                    Element cours = this.getDocument().createElement("Cours");
                    cours.setAttribute("paysFrom", cours_.getPaysFrom());
                    cours.setAttribute("paysTo", cours_.getPaysTo());
                    cours.setAttribute("uniteMonetairePaysFrom", cours_.getUniteMonetairePaysFrom());
                    cours.setAttribute("uniteMonetairePaysTo", cours_.getUniteMonetairePaysTo());
                    cours.setAttribute("facteurConversion", cours_.getFacteurConversion());
                    monnaie.appendChild(cours);
                }
                racine.appendChild(monnaie);
            }
            if (meteo_ != null) {
                Element meteo = this.getDocument().createElement("Meteo");
                for (Situation situation_ : meteo_.getSituation()) {
                    Element situation = this.getDocument().createElement("Situation");
                    situation.setAttribute("region", situation_.getRegion());
                    situation.setAttribute("pays", situation_.getPays());
                    Element dates = this.getDocument().createElement("Dates");
                    for (Jour jour_ : situation_.getDates().getJours()) {
                        Element date = this.getDocument().createElement("Jour");
                        date.setAttribute("value", jour_.getJour());
                        date.setAttribute("temperature", jour_.getTemperature());
                        date.setAttribute("forceVent", jour_.getForceVent());
                        date.setAttribute("typeTemps", jour_.getTypeTemps());
                        dates.appendChild(date);
                    }
                    situation.appendChild(dates);
                    meteo.appendChild(situation);
                }
                racine.appendChild(meteo);
            }
            if (freetax_ != null) {
                Element freetax = this.getDocument().createElement("Freetax");
                for (Product alcools_ : freetax_.getAlcools()) {
                    Element alcools = this.getDocument().createElement("Alcools");
                    alcools.setAttribute("nom", alcools_.getNom());
                    alcools.setAttribute("marque", alcools_.getMarque());
                    alcools.setAttribute("quantite", alcools_.getQuantite());
                    alcools.setAttribute("prix", alcools_.getPrix());
                    freetax.appendChild(alcools);
                }
                for (Product parfums_ : freetax_.getParfums()) {
                    Element parfums = this.getDocument().createElement("Parfums");
                    parfums.setAttribute("nom", parfums_.getNom());
                    parfums.setAttribute("marque", parfums_.getMarque());
                    parfums.setAttribute("quantite", parfums_.getQuantite());
                    parfums.setAttribute("prix", parfums_.getPrix());
                    freetax.appendChild(parfums);
                }
                for (Product tabacs_ : freetax_.getTabacs()) {
                    Element tabacs = this.getDocument().createElement("Tabacs");
                    tabacs.setAttribute("nom", tabacs_.getNom());
                    tabacs.setAttribute("marque", tabacs_.getMarque());
                    tabacs.setAttribute("quantite", tabacs_.getQuantite());
                    tabacs.setAttribute("prix", tabacs_.getPrix());
                    freetax.appendChild(tabacs);
                }
                racine.appendChild(freetax);
            }
            this.getDocument().appendChild(racine);
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        }
    }

    /**
     * Sauvegarde du DOM dans un fichier XML
     */
    protected void saveDOM() {
        try {
            // Création de la source DOM
            Source source = new DOMSource(this.getDocument());
            // Création du fichier de sortie
            Result resultat = new StreamResult(this.getFilename());
            // Configuration du transformer
            TransformerFactory fabrique = TransformerFactory.newInstance();
            Transformer transformer = fabrique.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            // Transformation
            transformer.transform(source, resultat);
        } catch(Exception ex){
            ex.printStackTrace(System.out);
            System.exit(1);
        }
    }
}