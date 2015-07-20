package martinkontsek.database;

import java.sql.ResultSet;

/**
 * Interface for accessing database.
 * 
 * @author Martin Kontsek
 */
public interface IDatabase 
{  
    /**
     * Executes SQL query 
     * @param paSQLquery query for execution
     * @return result
     */
    public ResultSet executeQuery(String paSQLquery);
    
    /**
     * Returns ID of row after query
     * 
     * @return id of added row 
     */
    public int getAutoincrementID();
    
    /**
     * Disconnects from database
     */
    public void disconnect();
    
    /**
     * Returns true if table exists
     * 
     * @param paName Name of table
     * @return true if table exists
     */
    public boolean tableExists(String paName);
}
