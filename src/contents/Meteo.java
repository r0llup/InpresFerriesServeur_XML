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

public class Meteo {
    protected List<Situation> situation;

    public Meteo() {}

    public List<Situation> getSituation() {
        return this.situation;
    }

    public void setSituation(List<Situation> situation) {
        this.situation = situation;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (Situation s : this.getSituation())
            buf.append("\n\tSituation :").append(s);
        return buf.toString();
    }
}