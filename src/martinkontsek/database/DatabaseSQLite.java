package martinkontsek.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Implementation of SQLite database
 * low-level access
 * 
 * @author Martin Kontsek
 */
public class DatabaseSQLite implements IDatabase
{
    private String aDatabaseFileName;
    private Connection aConnection;
    private Statement aSQLQuery;
    private ResultSet aResult;
    
    private ResultSet aAutoincrementID;
        
    /**
     * Constructor
     * 
     * @param paDatabaseFileName name of file, where database is stored
     */
    public DatabaseSQLite(String paDatabaseFileName)
    {
        aDatabaseFileName = paDatabaseFileName;
        aConnection = null;
        aSQLQuery = null;
        aResult = null;
    }
    
    /**
     * Connects to database
     * 
     * @return true if connection successful
     */
    private boolean connect()
    {      
        try {
            Class.forName("org.sqlite.JDBC");
            aConnection = DriverManager.getConnection("jdbc:sqlite:"+aDatabaseFileName);
            return true;
        } catch ( ClassNotFoundException | SQLException e ) {
            return false;
        }        
    }       
    
    /**
     * 
     * Execute SQL query
     * @param paSQLquery query for execution
     * @return result
     */
    @Override
    public ResultSet executeQuery(String paSQLquery)
    {
        if(this.connect())
        {
            try {
                aSQLQuery = aConnection.createStatement();                
                aSQLQuery.execute(paSQLquery);
                aResult = aSQLQuery.getResultSet();
                aSQLQuery = aConnection.createStatement();                
                aAutoincrementID = aSQLQuery.executeQuery("SELECT last_insert_rowid()");
                return aResult;                
            } catch (SQLException ex) {
                this.disconnect();
                return null;
            }           
        }
        return null;
    }
    
    /**
     * Returns ID of row after addition
     * 
     * @return id of added row 
     */
    @Override
    public int getAutoincrementID()
    {
        try {
            aAutoincrementID.next();
            return aAutoincrementID.getInt(1);
        } catch (SQLException ex) {
            return 0;
        }
    }
    
    /**
     * Disconnects from database 
     */
    @Override
    public void disconnect()
    {        
        try {
            if(aAutoincrementID != null)
                aAutoincrementID.close();
            if(aResult != null)
                aResult.close();
            if(aSQLQuery != null)
                aSQLQuery.close();
            if(aConnection != null)    
                aConnection.close();
        } catch (SQLException ex) {            
        }
    }
    
    /**
     * Returns true if table exists
     * 
     * @param paName Name of table
     * @return true if table exists
     */
    @Override
    public boolean tableExists(String paName)
    {
        try {
            String vyraz = "SELECT count(*) as pocet FROM sqlite_master WHERE type='table' AND name='"+paName+"'";
            ResultSet vysledok = this.executeQuery(vyraz);            
            vysledok.next();
            if(vysledok.getInt("pocet") == 1)
            {
                this.disconnect();
                return true;
            } else { 
                this.disconnect();
                return false;
            }
        } catch (SQLException | NullPointerException ex) {
            return false;
        }
    }
    
}
