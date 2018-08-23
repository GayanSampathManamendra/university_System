
package uniapp.dbConnection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class createConenction {
    
    private static Connection con;
    
    public static Connection setConnection() throws SQLException{
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try{
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/nsbm","root","");
            }
            catch(SQLException e){
                System.out.println("SQL error !");
            }
        } 
        catch (ClassNotFoundException ex) {
            System.out.println("class not found !");
        }
        return con;
    }
    
    public static Connection getConenction() throws SQLException{
        setConnection();
        return con;
    }
}
