/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contents;

/**
 *
 * @author Sh1fT
 */

public class Cours {
    protected String paysFrom;
    protected String paysTo;
    protected String uniteMonetairePaysFrom;
    protected String uniteMonetairePaysTo;
    protected String facteurConversion;

    public Cours() {}

    public String getPaysFrom() {
        return this.paysFrom;
    }

    public void setPaysFrom(String paysFrom) {
        this.paysFrom = paysFrom;
    }

    public String getPaysTo() {
        return this.paysTo;
    }

    public void setPaysTo(String paysTo) {
        this.paysTo = paysTo;
    }

    public String getUniteMonetairePaysFrom() {
        return this.uniteMonetairePaysFrom;
    }

    public void setUniteMonetairePaysFrom(String uniteMonetairePaysFrom) {
        this.uniteMonetairePaysFrom = uniteMonetairePaysFrom;
    }

    public String getUniteMonetairePaysTo() {
        return this.uniteMonetairePaysTo;
    }

    public void setUniteMonetairePaysTo(String uniteMonetairePaysTo) {
        this.uniteMonetairePaysTo = uniteMonetairePaysTo;
    }

    public String getFacteurConversion() {
        return this.facteurConversion;
    }

    public void setFacteurConversion(String facteurConversion) {
        this.facteurConversion = facteurConversion;
    }

    @Override
    public String toString() {
        return new StringBuilder("\n\t\tPays de provenance : ").append(this.getPaysFrom())
            .append("\n\t\tPays de destination : ").append(this.getPaysTo())
            .append("\n\t\tUnite monetaire du pays de provenance : ").append(this.getUniteMonetairePaysFrom())
            .append("\n\t\tUnite monetaire du pays de destination : ").append(this.getUniteMonetairePaysTo())
            .append("\n\t\tFacteur de conversion : ").append(this.getFacteurConversion()).toString();
    }
}