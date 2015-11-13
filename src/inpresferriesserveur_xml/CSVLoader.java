/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inpresferriesserveur_xml;

import contents.Product;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Sh1fT
 */

public final class CSVLoader {
    protected String directory;
    protected String name;
    protected Connection connection;
    protected Statement statement;
    protected ResultSet results;

    /**
     * Creates new instance CSVLoader
     * @param directory 
     */
    public CSVLoader(String directory, String name) {
        this.setDirectory(directory);
        this.setName(name);
        this.setConnection(null);
        this.setStatement(null);
        this.setResults(null);
        this.loadDriver();
    }

    public String getDirectory() {
        return this.directory;
    }

    protected void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public Connection getConnection() {
        return this.connection;
    }

    protected void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return this.statement;
    }

    protected void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResults() {
        return this.results;
    }

    protected void setResults(ResultSet results) {
        this.results = results;
    }

    /**
     * Load The CSV Driver
     */
    protected void loadDriver() {
        try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            this.setConnection(DriverManager.getConnection("jdbc:relique:csv:" + this.getDirectory()));
            this.setStatement(this.getConnection().createStatement());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        }
    }

    /**
     * Close The CSV Driver
     */
    protected void closeDriver() throws SQLException {
        this.getStatement().close();
        this.getConnection().close();
    }

    /**
     * Retrieve The Data
     * @return 
     */
    public List<Product> retrieveData() {
        try {
            List<Product> listeProduct = new LinkedList<Product>();
            this.setResults(this.getStatement().executeQuery("SELECT * FROM " + this.getName()));
            while (this.getResults().next())
                listeProduct.add(new Product(this.getResults().getString(1),
                    this.getResults().getString(2),
                    this.getResults().getString(3),
                    this.getResults().getString(4)));
            this.getResults().close();
            this.closeDriver();
            return listeProduct;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.exit(1);
        }
        return null;
    }
}