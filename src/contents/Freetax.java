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

public class Freetax {
    protected List<Product> alcools;
    protected List<Product> parfums;
    protected List<Product> tabacs;

    public Freetax() {}

    public List<Product> getAlcools() {
        return this.alcools;
    }

    public void setAlcools(List<Product> alcools) {
        this.alcools = alcools;
    }

    public List<Product> getParfums() {
        return this.parfums;
    }

    public void setParfums(List<Product> parfums) {
        this.parfums = parfums;
    }

    public List<Product> getTabacs() {
        return this.tabacs;
    }

    public void setTabacs(List<Product> tabacs) {
        this.tabacs = tabacs;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (Product a : this.getAlcools())
            buf.append("\n\tAlcools :").append(a);
        for (Product p : this.getParfums())
            buf.append("\n\tParfums :").append(p);
        for (Product t : this.getTabacs())
            buf.append("\n\tTabacs :").append(t);
        return buf.toString();
    }
}