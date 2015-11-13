/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contents;

/**
 *
 * @author Sh1fT
 */

public class Ferry {
    protected String nomFerry;
    protected String nomVoyageur;
    protected Monnaie monnaie;
    protected Meteo meteo;
    protected Freetax freetax;

    public Ferry() {}

    public String getNomFerry() {
        return this.nomFerry;
    }

    public void setNomFerry(String nomFerry) {
        this.nomFerry = nomFerry;
    }

    public String getNomVoyageur() {
        return this.nomVoyageur;
    }

    public void setNomVoyageur(String nomVoyageur) {
        this.nomVoyageur = nomVoyageur;
    }

    public Monnaie getMonnaie() {
        return this.monnaie;
    }

    public void setMonnaie(Monnaie monnaie) {
        this.monnaie = monnaie;
    }

    public Meteo getMeteo() {
        return this.meteo;
    }

    public void setMeteo(Meteo meteo) {
        this.meteo = meteo;
    }

    public Freetax getFreetax() {
        return this.freetax;
    }

    public void setFreetax(Freetax freetax) {
        this.freetax = freetax;
    }

    @Override
    public String toString() {
        return new StringBuilder("\nNom du ferry : ").append(this.getNomFerry())
            .append("\nNom du voyageur : ").append(this.getNomVoyageur())
            .append("\nMonnaie :").append(this.getMonnaie())
            .append("\nMeteo :").append(this.getMeteo())
            .append("\nFreetax :").append(this.getFreetax()).toString();
    }
}