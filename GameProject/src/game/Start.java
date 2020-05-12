/**
 *
 * @author Carl and GuoHao
 * @version 1.0
 */
package game;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Start {
    public Start(){
    }
    
    @SuppressWarnings("empty-statement")
    /**
     * Returns all players participating in the game
     * @return all players participating in the game
     */
    public static String Users(){
        String item = "Player List \t";
        String sql = "SELECT * FROM players";  
          
        try {  
            Connection conn = Connect.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql); 
//            System.out.println(rs.getString("name"));
              
            // loop through the result set 
            
            while (rs.next()) {  
                item += "\t" + rs.getString("name");
            }  
            rs.close();
            stmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        return item;
    }
  
  /**
   * Returns the player's name
   * @param id the player id
   * @return the name of player
   */
    public static String User(int id){
        String item = "";
        String sql = "SELECT * FROM players WHERE id = "+ id;  
          
        try {  
            Connection conn = Connect.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql); 
//            System.out.println(rs.getString("name"));
              
            // loop through the result set 
            
            while (rs.next()) {  
                item += rs.getString("name");
            }  
            rs.close();
            stmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        return item;
    }
    
    /**
     * Deletes the player when the player account has no balance
     */
    public static void removeUser(){
        String sql = "DELETE FROM players WHERE amount <= 0";  
          
        try {  
            Connection conn = Connect.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql); 
//     
            rs.close();
            stmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
    }
    
    /**
     * Returns the player's account by the player's id
     * @param id the player id
     * @return Player account money
     */
    public static Double amount(int id){
        double amount = 0;
        String sql = "SELECT * FROM players WHERE id = "+ id;  
          
        try {  
            Connection conn = Connect.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql); 
//            System.out.println(rs.getString("name"));
              
            // loop through the result set 
            
            while (rs.next()) {  
                amount += rs.getDouble("amount");
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        return amount;
    }
    
    /**
     * Returns the player's account information
     * @return the message of player's name and player's amount
     */
    public static String Amount(){
        String item =  "Player \t Amount \n";
        String sql = "SELECT * FROM players";  
          
        try {  
            Connection conn = Connect.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql); 
//            System.out.println(rs.getString("name"));
              
            // loop through the result set 
            while (rs.next()) {  
                item += rs.getString("name") + "\t" + rs.getString("amount") +"\n";
            }  
            rs.close();
            stmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        return item;
    }
    
    /**
     * Records the number of players
     * @return the number of players
     */
    public static int Count(){
      int count = 0;
       String sql = "SELECT COUNT (*) FROM players";  
          
        try {  
            Connection conn = Connect.connect();  
            Statement stmt = conn.createStatement();  
            ResultSet rs = stmt.executeQuery(sql);   
              rs.next();
              count += rs.getInt(1);
            // loop through the result set 
            
//            item = rs;
        rs.close();
        stmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } 
    return count;
  }
  
  
}



