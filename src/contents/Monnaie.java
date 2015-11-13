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

public final class Monnaie {
    protected List<Cours> cours;

    public Monnaie() {}

    public List<Cours> getCours() {
        return this.cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (Cours c : this.getCours())
            buf.append("\n\tCours :").append(c);
        return buf.toString();
    }
}