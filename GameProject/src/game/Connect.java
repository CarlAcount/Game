/**
 *
 * @author Carl and GuoHao
 * @version 1.0
 */
package game;

import java.sql.Connection; 
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.sql.SQLException;  
import java.sql.Statement;
       
public class Connect {  

    static Connection connect() throws SQLException {
         String url = "jdbc:sqlite:database.db"; 
     Connection conn = DriverManager.getConnection(url);  
     
     return conn;
    }
    /** 
    * Connect to a sample database 
    */  
  
    public static void insert(String name, double amount) {  
   String sql = "INSERT INTO players(name, amount) VALUES(?,?)"; 
   String url = "jdbc:sqlite:database.db"; 
        try{  
            Connection conn = DriverManager.getConnection(url); 
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, name);  
            pstmt.setDouble(2, amount);  
            pstmt.executeUpdate(); 
            pstmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }
    public static void createNewTable() {  
        // SQLite connection string  
           String url = "jdbc:sqlite:database.db";  
          
        // SQL statement for creating a new table  
        String sql1 = "DROP TABLE IF EXISTS players";  

        String sql = "CREATE TABLE IF NOT EXISTS players (\n"  
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"  
                + " name text NOT NULL,\n"  
                + " amount real\n"  
                + ");";  
          
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            stmt.execute(sql1);
             stmt.execute(sql);
             stmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
//update user details
  public static void update(int id, double amount) { 
    String sql = "UPDATE players SET amount = ?  "
                + "WHERE id = ?";
                String url = "jdbc:sqlite:database.db"; 
    try{  
            Connection conn = DriverManager.getConnection(url); 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, id);
            
            pstmt.executeUpdate();
             pstmt.close();
            System.out.println("User data updated succefully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }
   public void getMydata(int id) { 
    String sql = "SELECT * FROM players WHERE id = ?";
                String url = "jdbc:sqlite:database.db"; 
    try{  
            Connection conn = DriverManager.getConnection(url); 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
//            pstmt.setDouble(1, amount);
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
             pstmt.close();
            System.out.println("User data updated succefully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }
   
}  