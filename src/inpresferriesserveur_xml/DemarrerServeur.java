/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inpresferriesserveur_xml;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import org.xml.sax.InputSource;

/**
 *
 * @author Sh1fT
 */

<<<<<<< HEAD
public final class DemarrerServeur extends Thread {
=======
public class DemarrerServeur extends Thread {
>>>>>>> 4adae89a657e8abea90dbb131ba8014b4660e289
    protected ServeurInformations parent;

    /**
     * Creates new instance DemarrerServeur
     * @param parent 
     */
    public DemarrerServeur(ServeurInformations parent) {
<<<<<<< HEAD
        this.setParent(parent);
=======
        this.parent = parent;
>>>>>>> 4adae89a657e8abea90dbb131ba8014b4660e289
    }

    public ServeurInformations getParent() {
        return this.parent;
    }
<<<<<<< HEAD

    protected void setParent(ServeurInformations parent) {
=======
    public void setParent(ServeurInformations parent) {
>>>>>>> 4adae89a657e8abea90dbb131ba8014b4660e289
        this.parent = parent;
    }

    @Override
    public void run() {
        try {
            this.getParent().setSSocket(new ServerSocket(this.getParent().getServerPort()));
            while (true) {
                this.getParent().setCSocket(this.getParent().getSSocket().accept());
                this.getParent().getClientLabel().setText(this.getParent().getCSocket().getInetAddress().getHostAddress());
                InputSource is = new InputSource(new InputStreamReader(this.getParent().getCSocket().getInputStream()));
                this.getParent().setParsingSAX(new SAXParsing(is));
                this.getParent().setFerry(((FerryHandler) this.getParent().getParsingSAX().getGestionnaire()).getFerry());
                this.getParent().feedMonnaie();
                this.getParent().feedMeteo();
                this.getParent().feedFreetax();
                this.getParent().setCreationDOM(new DOMCreator(this.getParent().getOutputXMLFilename(), this.getParent()));
                this.getParent().setCreationHTML(new HTMLCreator(
                    this.getParent().getOutputXMLFilename(),
                    this.getParent().getOutputXSLFilename(),
                    this.getParent().getOutputHTMLFilename()));
                this.getParent().getCSocket().close();
                this.getParent().getClientLabel().setText("aucun");
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        }
    }
}