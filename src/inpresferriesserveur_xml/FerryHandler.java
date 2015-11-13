/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inpresferriesserveur_xml;

import contents.Cours;
import contents.Dates;
import contents.Ferry;
import contents.Freetax;
import contents.Jour;
import contents.Meteo;
import contents.Monnaie;
import contents.Product;
import contents.Situation;
import java.util.LinkedList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Sh1fT
 */

public final class FerryHandler extends DefaultHandler {
    protected Ferry ferry;
    protected Cours cours;
    protected Situation situation;
    protected Boolean inFerry;
    protected Boolean inMonnaie;
    protected Boolean inCours;
    protected Boolean inMeteo;
    protected Boolean inSituation;
    protected Boolean inDates;
    protected Boolean inJour;
    protected Boolean inFreetax;
    protected Boolean inAlcools;
    protected Boolean inParfums;
    protected Boolean inTabacs;
    protected StringBuffer buffer;

    /**
     * Creates new instance FerryHandler
     */
    public FerryHandler() {
        super();
        this.setBuffer(new StringBuffer());
    }

    public Ferry getFerry() {
        return this.ferry;
    }

    protected void setFerry(Ferry ferry) {
        this.ferry = ferry;
    }

    public Cours getCours() {
        return this.cours;
    }

    protected void setCours(Cours cours) {
        this.cours = cours;
    }

    public Situation getSituation() {
        return this.situation;
    }

    protected void setSituation(Situation situation) {
        this.situation = situation;
    }

    public StringBuffer getBuffer() {
        return this.buffer;
    }

    protected void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }

    /**
     * Détection d'ouverture de balises
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException 
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("Ferry")) {
            this.setFerry(new Ferry());
            this.getFerry().setNomFerry(attributes.getValue("name"));
            this.getFerry().setNomVoyageur(attributes.getValue("voyageur"));
            this.inFerry = true;
        } else if (qName.equals("Monnaie")) {
            this.getFerry().setMonnaie(new Monnaie());
            this.getFerry().getMonnaie().setCours(new LinkedList<Cours>());
            this.inMonnaie = true;
        } else if (qName.equals("Cours")) {
            this.setCours(new Cours());
            this.getCours().setPaysFrom(attributes.getValue("paysFrom"));
            this.getCours().setPaysTo(attributes.getValue("paysTo"));
            this.inCours = true;
        } else if (qName.equals("Meteo")) {
            this.getFerry().setMeteo(new Meteo());
            this.getFerry().getMeteo().setSituation(new LinkedList<Situation>());
            this.inMeteo = true;
        } else if (qName.equals("Situation")) {
            this.setSituation(new Situation());
            this.getSituation().setRegion(attributes.getValue("region"));
            this.getSituation().setPays(attributes.getValue("pays"));
            this.getSituation().setDates(new Dates());
            this.inSituation = true;
        } else if (qName.equals("Dates")) {
            this.getSituation().getDates().setJours(new LinkedList<Jour>());
            this.inDates = true;
        } else if (qName.equals("Freetax")) {
            this.getFerry().setFreetax(new Freetax());
            this.inFreetax = true;
        } else {
            this.setBuffer(new StringBuffer());
            if (qName.equals("Jour")) {
                this.inJour = true;
            } else if (qName.equals("Alcools")) {
                this.getFerry().getFreetax().setAlcools(new LinkedList<Product>());
                this.getFerry().getFreetax().getAlcools().add(new Product());
                this.inAlcools = true;
            } else if (qName.equals("Parfums")) {
                this.getFerry().getFreetax().setParfums(new LinkedList<Product>());
                this.getFerry().getFreetax().getParfums().add(new Product());
                this.inParfums = true;
            } else if (qName.equals("Tabacs")) {
                this.getFerry().getFreetax().setTabacs(new LinkedList<Product>());
                this.getFerry().getFreetax().getTabacs().add(new Product());
                this.inTabacs = true;
            } else {
                throw new SAXException("Balise '" + qName + "' inconnue.");
            }
        }
    }

    /**
     * Détection fin de balise
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("Ferry")) {
            this.inFerry = false;
    	} else if (qName.equals("Monnaie")) {
            this.inMonnaie = false;
    	} else if (qName.equals("Cours")) {
            this.getFerry().getMonnaie().getCours().add(this.getCours());
            this.inCours = false;
    	} else if (qName.equals("Meteo")) {
            this.inMeteo = false;
    	} else if (qName.equals("Situation")) {
            this.getFerry().getMeteo().getSituation().add(this.getSituation());
            this.inSituation = false;
    	} else if (qName.equals("Dates")) {
            this.inDates = false;
    	} else if (qName.equals("Jour")) {
            Jour j = new Jour();
            j.setJour(this.getBuffer().toString());
            this.getSituation().getDates().getJours().add(j);
            this.setBuffer(null);
            this.inJour = false;
    	} else if (qName.equals("Freetax")) {
            this.inFreetax = false;
    	} else if (qName.equals("Alcools")) {
            this.getFerry().getFreetax().getAlcools().get(0).setNom(this.getBuffer().toString());
            this.setBuffer(null);
            this.inAlcools = false;
    	} else if (qName.equals("Parfums")) {
            this.getFerry().getFreetax().getParfums().get(0).setNom(this.getBuffer().toString());
            this.setBuffer(null);
            this.inParfums = false;
    	} else if (qName.equals("Tabacs")) {
            this.getFerry().getFreetax().getTabacs().get(0).setNom(this.getBuffer().toString());
            this.setBuffer(null);
            this.inTabacs = false;	
    	}
    }

    /**
     * Détection de caractères
     * @param ch
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String lecture = new String(ch, start, length);
        if(buffer != null)
            buffer.append(lecture);       
    }

    /**
     * Début du parsing
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Début du parsing");
    }

    /**
     * Fin du parsing
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
        System.out.println("Fin du parsing");
        System.out.println("Resultats du parsing");
        System.out.println(this.getFerry().toString());
    }
}