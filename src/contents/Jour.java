/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contents;

/**
 *
 * @author Sh1fT
 */

public class Jour {
    protected String jour;
    protected String temperature;
    protected String forceVent;
    protected String typeTemps;

    public Jour() {}

    public String getJour() {
        return this.jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getTemperature() {
        return this.temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getForceVent() {
        return this.forceVent;
    }

    public void setForceVent(String forceVent) {
        this.forceVent = forceVent;
    }

    public String getTypeTemps() {
        return this.typeTemps;
    }

    public void setTypeTemps(String typeTemps) {
        this.typeTemps = typeTemps;
    }

    @Override
    public String toString() {
        return new StringBuilder("\n\t\t\t\tJour : ").append(this.getJour())
            .append("\n\t\t\t\tTemperature : ").append(this.getTemperature())
            .append("\n\t\t\t\tForce du vent : ").append(this.getForceVent())
            .append("\n\t\t\t\tType de temps : ").append(this.getTypeTemps())
            .toString();
    }
}