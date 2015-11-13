/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contents;

/**
 *
 * @author Sh1fT
 */

public class Product {
    protected String nom;
    protected String marque;
    protected String quantite;
    protected String prix;

    public Product() {}

    public Product(String nom, String marque, String quantite, String prix) {
        this.nom = nom;
        this.marque = marque;
        this.quantite =quantite;
        this.prix = prix;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return this.marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getQuantite() {
        return this.quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public String getPrix() {
        return this.prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return new StringBuilder("\n\t\tNom : ").append(this.getNom())
            .append("\n\t\tMarque : ").append(this.getMarque())
            .append("\n\t\tQuantite : ").append(this.getQuantite())
            .append("\n\t\tPrix : ").append(this.getPrix()).toString();
    }
}