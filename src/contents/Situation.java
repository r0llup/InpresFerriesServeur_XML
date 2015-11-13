/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contents;

/**
 *
 * @author Sh1fT
 */

public class Situation {
    protected String region;
    protected String pays;
    protected Dates dates;

    public Situation() {}

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPays() {
        return this.pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Dates getDates() {
        return this.dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    @Override
    public String toString() {
        return new StringBuilder("\n\t\tRegion : ").append(this.getRegion())
            .append("\n\t\tPays : ").append(this.getPays())
            .append("\n\t\tDates :").append(this.getDates()).toString();
    }
}