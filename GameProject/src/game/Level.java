/**
 *
 * @author Carl and GuoHao
 * @version 1.0
 */
package game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Level {
    
    static int playerLevel(int player) {
        String cars = null;
        int level = 0;
        String sql = "SELECT * FROM level WHERE player = "+ player;  
          
        try {  
            Connection conn = Connect.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql); 
//            System.out.println(rs.getString("name"));
//            loop through the result set 
            while (rs.next()) {  
                 level += rs.getInt("level");
            }  
            rs.close();
            stmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } 
         
        return level;
    }
    
    static void updateLevel(int level, int player) {
        String sql = "UPDATE level SET level = ?  "
                + "WHERE player = ?";
        try {  
            Connection conn = Connect.connect(); 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, level);
            pstmt.setInt(2, player);
            
            pstmt.executeUpdate();
            System.out.println("Level updated succefully");
             pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());   
        }
    }
    
    public static void insert(int level, int player) {  
        String sql = "INSERT INTO level(level, player) VALUES(?,?)"; 
        
        try{  
            Connection conn = Connect.connect(); 
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setInt(1, level);  
            pstmt.setDouble(2, player);  
            pstmt.executeUpdate(); 
            pstmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }
         
    /**
      * Return status of id
      * @param id the id of the player
      * @return true if it is owned, otherwise false
      */
    public static boolean check(int id){
        boolean status = false;
        int count = 0;
        String sql = "SELECT COUNT (*) FROM level WHERE player=" + id;  
          
        try {  
            Connection conn = Connect.connect();  
            Statement stmt = conn.createStatement();  
            ResultSet rs = stmt.executeQuery(sql);   
              rs.next();
              count += rs.getInt(1);
            // loop through the result set 
             rs.close();
//            item = rs;
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        if(count >= 1){
            status = true;
        }
      
        return status;
    }

    /**
      * init the database
      */
    static void init() {
        // SQLite connection string
        String url = "jdbc:sqlite:database.db";  
        // SQL statement for creating a new table  
        String sql1 = "DROP TABLE IF EXISTS level";  
        
        String sql = "CREATE TABLE IF NOT EXISTS level (\n"  
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"  
                + " level INTEGER DEFAULT 0,\n"  
                + " payongo INTEGER DEFAULT 200, \n"
                + " player INTEGER NOT NULL \n"  
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
}
