/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ServeurInformations.java
 *
 * Created on 30 oct. 2011, 13:25:55
 */

package inpresferriesserveur_xml;

import contents.Cours;
import contents.Ferry;
import contents.Freetax;
import contents.Jour;
import contents.Meteo;
import contents.Monnaie;
import contents.Product;
import contents.Situation;
import java.awt.Color;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import javax.swing.JLabel;
import utils.PropertiesLauncher;

/**
 *
 * @author Sh1fT
 */

<<<<<<< HEAD
public final class ServeurInformations extends javax.swing.JFrame {
=======
public class ServeurInformations extends javax.swing.JFrame {
>>>>>>> 4adae89a657e8abea90dbb131ba8014b4660e289
    protected DemarrerServeur demarrerServeur;
    protected ServerSocket sSocket;
    protected Socket cSocket;
    protected Ferry ferry;
    protected SAXParsing parsingSAX;
    protected DOMCreator creationDOM;
    protected HTMLCreator creationHTML;
    protected String [] temperatureSample;
    protected String [] forceVentSample;
    protected List<String> typeTempsSample;
    protected List<Product> alcoolsSample;
    protected List<Product> parfumsSample;
    protected List<Product> tabacsSample;
    protected PropertiesLauncher propertiesLauncher;

    /**
     * Creates new form ServeurInformations
     * @param parent
     * @param modal 
     */
    public ServeurInformations() {
        this.initComponents();
        this.setDemarrerServeur(null);
        this.setSSocket(null);
        this.setCSocket(null);
        this.setFerry(null);
        this.setParsingSAX(null);
        this.setCreationDOM(null);
        this.setCreationHTML(null);
        this.setTemperatureSample(new String[30]);
        for (int i=0 ; i < this.getTemperatureSample().length ; i++)
            this.getTemperatureSample()[i] = String.valueOf(i);
        this.setForceVentSample(new String[13]);
        for (int i=0 ; i < this.getForceVentSample().length ; i++)
            this.getForceVentSample()[i] = String.valueOf(i);
        this.setTypeTempsSample(null);
        this.setAlcoolsSample(null);
        this.setParfumsSample(null);
        this.setTabacsSample(null);
        this.setPropertiesLauncher(new PropertiesLauncher(
            System.getProperty("file.separator") + "properties" +
            System.getProperty("file.separator") + "InpresFerriesServeur_XML.properties"));
        this.loadTXT();
        this.loadCSV();
    }

    /**
     * Load The TXT Files
     */
    private void loadTXT() {
        this.setTypeTempsSample(new TXTLoader(this.getTypeTempsSampleFn()).retrieveData());
    }

    /**
     * Load The CSV Files
     */
    private void loadCSV() {
        this.setAlcoolsSample(new CSVLoader(this.getSampleDir(), this.getAlcoolsSampleFn()).retrieveData());
        this.setParfumsSample(new CSVLoader(this.getSampleDir(), this.getParfumsSampleFn()).retrieveData());
        this.setTabacsSample(new CSVLoader(this.getSampleDir(), this.getTabacsSampleFn()).retrieveData());
    }

    public ServerSocket getSSocket() {
        return this.sSocket;
    }

    protected void setSSocket(ServerSocket sSocket) {
        this.sSocket = sSocket;
    }

    public Socket getCSocket() {
        return this.cSocket;
    }

    protected void setCSocket(Socket cSocket) {
        this.cSocket = cSocket;
    }

    public DemarrerServeur getDemarrerServeur() {
        return this.demarrerServeur;
    }

    protected void setDemarrerServeur(DemarrerServeur demarrerServeur) {
        this.demarrerServeur = demarrerServeur;
    }

    public Ferry getFerry() {
        return this.ferry;
    }

    protected void setFerry(Ferry ferry) {
        this.ferry = ferry;
    }

    public SAXParsing getParsingSAX() {
        return this.parsingSAX;
    }

    protected void setParsingSAX(SAXParsing parsingSAX) {
        this.parsingSAX = parsingSAX;
    }

    public DOMCreator getCreationDOM() {
        return this.creationDOM;
    }

    protected void setCreationDOM(DOMCreator creationDOM) {
        this.creationDOM = creationDOM;
    }

    public HTMLCreator getCreationHTML() {
        return this.creationHTML;
    }

    protected void setCreationHTML(HTMLCreator creationHTML) {
        this.creationHTML = creationHTML;
    }

    public String[] getTemperatureSample() {
        return this.temperatureSample;
    }

    protected void setTemperatureSample(String[] temperatureSample) {
        this.temperatureSample = temperatureSample;
    }

    public String[] getForceVentSample() {
        return this.forceVentSample;
    }

    protected void setForceVentSample(String[] forceVentSample) {
        this.forceVentSample = forceVentSample;
    }

    public List<String> getTypeTempsSample() {
        return this.typeTempsSample;
    }

    protected void setTypeTempsSample(List<String> typeTempsSample) {
        this.typeTempsSample = typeTempsSample;
    }

    public List<Product> getAlcoolsSample() {
        return this.alcoolsSample;
    }

    protected void setAlcoolsSample(List<Product> alcoolsSample) {
        this.alcoolsSample = alcoolsSample;
    }

    public List<Product> getParfumsSample() {
        return this.parfumsSample;
    }

    protected void setParfumsSample(List<Product> parfumsSample) {
        this.parfumsSample = parfumsSample;
    }

    public List<Product> getTabacsSample() {
        return this.tabacsSample;
    }

    protected void setTabacsSample(List<Product> tabacsSample) {
        this.tabacsSample = tabacsSample;
    }

    public PropertiesLauncher getPropertiesLauncher() {
        return this.propertiesLauncher;
    }

    protected void setPropertiesLauncher(PropertiesLauncher propertiesLauncher) {
        this.propertiesLauncher = propertiesLauncher;
    }

    public JLabel getClientLabel() {
        return this.clientLabel;
    }

    /**
     * Return the Output XML Filename
     * @return 
     */
    public String getOutputXMLFilename() {
        return this.getPropertiesLauncher().getProperties().getProperty("outputXMLFn");
    }

    /**
     * Return the Output DTD Filename
     * @return 
     */
    public String getOutputDTDFilename() {
        return this.getPropertiesLauncher().getProperties().getProperty("outputDTDFn");
    }

    /**
     * Return the Output XSL Filename
     * @return 
     */
    public String getOutputXSLFilename() {
        return this.getPropertiesLauncher().getProperties().getProperty("outputXSLFn");
    }

    /**
     * Return the Output HTML Filename
     * @return 
     */
    public String getOutputHTMLFilename() {
        return this.getPropertiesLauncher().getProperties().getProperty("outputHTMLFn");
    }

    /**
     * Return the Server Port
     * @return 
     */
    public Integer getServerPort() {
        return Integer.parseInt(this.getPropertiesLauncher().getProperties().getProperty("serverPort"));
    }

    /**
     * Return the FcEuroLivre
     * @return 
     */
    public String getFcEuroLivre() {
        return this.getPropertiesLauncher().getProperties().getProperty("fcEuroLivre");
    }

    /**
     * Return the FcLivreEuro
     * @return 
     */
    public String getFcLivreEuro() {
        return this.getPropertiesLauncher().getProperties().getProperty("fcLivreEuro");
    }

    /**
     * Return the Sample Directory
     * @return 
     */
    public String getSampleDir() {
        return this.getPropertiesLauncher().getProperties().getProperty("sampleDir");
    }

    /**
     * Return the Alcools Sample Filename
     * @return 
     */
    public String getAlcoolsSampleFn() {
        return this.getPropertiesLauncher().getProperties().getProperty("alcoolsSampleFn");
    }

    /**
     * Return the Parfums Sample Filename
     * @return 
     */
    public String getParfumsSampleFn() {
        return this.getPropertiesLauncher().getProperties().getProperty("parfumsSampleFn");
    }

    /**
     * Return the Tabacs Sample Filename
     * @return 
     */
    public String getTabacsSampleFn() {
        return this.getPropertiesLauncher().getProperties().getProperty("tabacsSampleFn");
    }

    /**
     * Return the TypeTemps Sample Filename
     * @return 
     */
    public String getTypeTempsSampleFn() {
        return this.getPropertiesLauncher().getProperties().getProperty("typeTempsSampleFn");
    }

    /**
     * Check the values of 'Monnaie'
     * @param c 
     */
    public void checkMonnaie(Cours c) {
        if (c.getPaysFrom().compareTo("Royaume-Uni") == 0) {
            c.setUniteMonetairePaysFrom("GBP");
            if (c.getPaysTo().compareTo("Royaume-Uni") != 0) {
                c.setUniteMonetairePaysTo("EUR");
                c.setFacteurConversion(this.getFcLivreEuro());
            } else {
                c.setUniteMonetairePaysTo("GBP");
                c.setFacteurConversion("1");
            }
        } else if (c.getPaysFrom().compareTo("Royaume-Uni") != 0) {
            c.setUniteMonetairePaysFrom("EUR");
            if (c.getPaysTo().compareTo("Royaume-Uni") == 0) {
                c.setUniteMonetairePaysTo("GBP");
                c.setFacteurConversion(this.getFcEuroLivre());
            } else {
                c.setUniteMonetairePaysTo("EUR");
                c.setFacteurConversion("1");
            }
        }
    }

    /**
     * Feed the fields of 'Monnaie'
     */
    public void feedMonnaie() {
        Monnaie monnaie = this.getFerry().getMonnaie();
        if (monnaie != null) {
            if (monnaie.getCours() != null) {
                for (Cours c : monnaie.getCours())
                    this.checkMonnaie(c);
            }
        }
    }

    /**
     * Feed the fields of 'Meteo'
     */
    public void feedMeteo() {
        Meteo meteo = this.getFerry().getMeteo();
        if (meteo != null) {
            if (meteo.getSituation() != null) {
                for (Situation s : meteo.getSituation()) {
                    for (Jour j : s.getDates().getJours()) {
                        j.setTemperature(this.getTemperatureSample()
                            [(int)(Math.random() * (this.getTemperatureSample().length-0)) + 0]);
                        j.setForceVent(this.getForceVentSample()
                            [(int)(Math.random() * (this.getForceVentSample().length-0)) + 0]);
                        j.setTypeTemps(this.getTypeTempsSample().get(
                            (int)(Math.random() * (this.getTypeTempsSample().size()-0)) + 0));
                    }
                }
            }
        }
    }

    /**
     * Feed the fields of 'Freetax'
     */
    public void feedFreetax() {
        Freetax freetax = this.getFerry().getFreetax();
        if (freetax != null) {
            if (freetax.getAlcools() != null) {
                if (freetax.getAlcools().get(0).getNom().compareTo("yes") == 0)
                    freetax.setAlcools(this.getAlcoolsSample());
                else
                    freetax.getAlcools().remove(0);
            }
            if (freetax.getParfums() != null) {
                if (freetax.getParfums().get(0).getNom().compareTo("yes") == 0)
                    freetax.setParfums(this.getParfumsSample());
                else
                    freetax.getParfums().remove(0);
            }
            if (freetax.getTabacs() != null) {
                if (freetax.getTabacs().get(0).getNom().compareTo("yes") == 0)
                    freetax.setTabacs(this.getTabacsSample());
                else
                    freetax.getTabacs().remove(0);
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        demarrerToggleButton = new javax.swing.JToggleButton();
        arreterToggleButton = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        etatLabel = new javax.swing.JLabel();
        clientLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        quitterButton = new javax.swing.JButton();

        buttonGroup1.add(this.demarrerToggleButton);
        buttonGroup1.add(this.arreterToggleButton);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Serveur_Information");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        demarrerToggleButton.setText("Démarrer");
        demarrerToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demarrerToggleButtonActionPerformed(evt);
            }
        });

        arreterToggleButton.setText("Arrêter");
        arreterToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arreterToggleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(demarrerToggleButton)
                .addGap(18, 18, 18)
                .addComponent(arreterToggleButton)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arreterToggleButton)
                    .addComponent(demarrerToggleButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations"));

        jLabel1.setText("Client connecté :");

        jLabel2.setText("État du serveur :");

        etatLabel.setText("inconnu");

        clientLabel.setText("aucun");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(etatLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(clientLabel)))
                .addContainerGap(221, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(etatLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(clientLabel)))
        );

        quitterButton.setText("Quitter");
        quitterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(quitterButton)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(quitterButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void demarrerToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demarrerToggleButtonActionPerformed
        if (this.getDemarrerServeur() == null) {
            this.setDemarrerServeur(new DemarrerServeur(this));
            this.getDemarrerServeur().start();
            this.etatLabel.setForeground(Color.green);
            this.etatLabel.setText("démarré");
        }
    }//GEN-LAST:event_demarrerToggleButtonActionPerformed

    private void arreterToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arreterToggleButtonActionPerformed
        if (this.getDemarrerServeur() != null) {
            this.getDemarrerServeur().interrupt();
            this.setDemarrerServeur(null);
            this.etatLabel.setForeground(Color.red);
            this.etatLabel.setText("arrêté");
            this.clientLabel.setText("");
        }
    }//GEN-LAST:event_arreterToggleButtonActionPerformed

    private void quitterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterButtonActionPerformed
        if (this.getDemarrerServeur() != null)
            this.getDemarrerServeur().interrupt();
        System.exit(0);
    }//GEN-LAST:event_quitterButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServeurInformations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServeurInformations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServeurInformations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServeurInformations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ServeurInformations dialog = new ServeurInformations();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton arreterToggleButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel clientLabel;
    private javax.swing.JToggleButton demarrerToggleButton;
    private javax.swing.JLabel etatLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton quitterButton;
    // End of variables declaration//GEN-END:variables
}