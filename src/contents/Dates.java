/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contents;

import java.util.List;

/**
 *
 * @author Sh1fT
 */

public class Dates {
    protected List<Jour> jours;

    public Dates() {}

    public List<Jour> getJours() {
        return this.jours;
    }

    public void setJours(List<Jour> jours) {
        this.jours = jours;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (Jour j : this.getJours())
            buf.append("\n\t\t\tJour :").append(j);
        return buf.toString();
    }
}