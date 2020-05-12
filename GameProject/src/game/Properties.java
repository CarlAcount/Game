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

public class Properties {
    /**
     * Init the database
     * @return true
     */
    public static boolean init(){
        // SQLite connection string  
        String url = "jdbc:sqlite:database.db"; 
        // SQL statement for creating a new table  
        // String sql1 = "DROP TABLE IF EXISTS properties";  
        String sql4 = "DROP TABLE IF EXISTS rent_property";  
        String sql5 = "DROP TABLE IF EXISTS owner";  

        String sql = "CREATE TABLE IF NOT EXISTS properties (\n"  
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"  
                + " name text NOT NULL,\n"
                + " worth REAL, \n"
                + "actions text,\n "
                + " buyable INTEGER DEFAULT 0\n"  
                + ");";  
        
        String sql2 = "CREATE TABLE IF NOT EXISTS rent_property (\n"  
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"  
                + " propertyid interger NOT NULL,\n"
                + " player integer NOT NULL \n"
                + ");";   
                
        String sql3 = "CREATE TABLE IF NOT EXISTS owner (\n"  
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"  
                + " owner interger NOT NULL,\n"
                + " property integer NOT NULL \n"
                + ");"; 
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            //new game ? wipe alldata and create new table
//            stmt.execute(sql1);
//             stmt.execute(sql);
            stmt.execute(sql4);
            stmt.execute(sql5);
            stmt.execute(sql2);
            stmt.execute(sql3);
            stmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
      return true;
    }
    
    /**
     * Returns the id and name of all properties on the map
     * @return the id and name of all properties on the map
     */
    public static String properties(){
        String cars = null;
        String item = "property List \n";
        String sql = "SELECT * FROM properties";  
          
        try {  
            Connection conn = Connect.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql); 
            while (rs.next()) {  
                item += "\t" + rs.getString("id")+ "\t" + rs.getString("name") + "\t" + rs.getString("buyable") + "\n";
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } 
        return item;
    }
  
    /**
     * Returns property attribute on Property Tycoon
     * @param id the property id
     * @return property attribute
     */
    public static String property(int id){
        String message = "";
        String sql = "SELECT * FROM properties where id=" +id;  
          
        try {  
            Connection conn = Connect.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql); 
            while (rs.next()) {  
                message += "name : " + rs.getString("name")+ "\n" ;
                if(rs.getDouble("buyable") == 1 && rs.getDouble("house1") >1 ){
                    message += "price : " + rs.getString("worth") + "\n"  
                            + "Rent : " + rs.getString("rent") + "\n"
                        + "Action : "  +rs.getString("actions") + "\n"
                        + "1 house : "  +rs.getString("house1") + "\n"
                        + "2 houses : " +rs.getString("house2") + "\n"
                        + "3 houses : " +rs.getString("house3") + "\n"
                        + "4 houses : " +rs.getString("house4") + "\n"
                        + "1 hotel : " +rs.getString("hotel1") + "\n";
                 }
                         
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        return message;
    }
    
    /**
     * Tests whether property can be purchased
     * @param id the property id
     * @return true If the property can be purchased, 
     * otherwise false.
     */
    public static Boolean isBuyable(int id){
        Boolean status = false;
        String item = "property List \n";
        String sql = "SELECT * FROM properties WHERE id = "+ id;  
          
        try {  
            Connection conn = Connect.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql); 
            while (rs.next()) {
                item += rs.getString("buyable");
                if(rs.getInt("buyable") == 1){
                    status = true;
                }
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        
        return status;
    }
    
    /**
     * Returns the value of property
     * @param id the property id
     * @return properties price
     */
    public static double price(int id){
        double price = 0;
        String item = "property List \n";
        String sql = "SELECT * FROM properties WHERE id ="+ id;  
          
        try {  
            Connection conn = Connect.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql); 
            while (rs.next()) {  
                price += rs.getDouble("worth");
                
            } 
            rs.close();
            stmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } 
        return price;
    }
    
    /**
     * Returns the rent of the property by the id of the property
     * @param id the property id
     * @return the price of property rent
     */
    public static double rentAmount(int id){
        double price = 0;
        String item = "property List \n";
        String sql = "SELECT * FROM properties WHERE id ="+ id;  
          
        try {  
            Connection conn = Connect.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql); 
            while (rs.next()) {  
                price += rs.getDouble("rent");
                
            } 
            rs.close();
            stmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        return price;
    }
    
    
    /**
     * Gets Player id of property owner
     * @param id the player id
     * @return Player id of property owner
     */
    public static int getOwner(int id){
        int owner = 0;
        String item = "property List \n";
        String sql = "SELECT * FROM owner WHERE property ="+ id;  
          
        try {  
            Connection conn = Connect.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql); 
            while (rs.next()) {  
                owner += rs.getInt("owner");
                
            } 
            rs.close();
            stmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        return owner;
    }
   
    /**
     * check if property is owned
     * @param id the player id
     * @return returns true if it is owned, otherwise false
     */
    public static boolean check(int id){
        boolean status = false;
        int count = 0;
        String sql = "SELECT COUNT (*) FROM owner WHERE property=" + id;  
          
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
        if(count > 0){
            status = true;
        }
        return status;
    }
    
    /**
     * Rents the property
     * @param player the player
     * @param property property on the Property Tycoon map
     * @return true
     */
    public static boolean rent(int player, int property){
         String sql = "INSERT INTO rent_property(propertyid, player) VALUES(?,?)";  
        try{  
            Connection conn = Connect.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setInt(1, property);  
            pstmt.setInt(2, player); 
            pstmt.executeUpdate();
             pstmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
      
      return true;
    }
    
    /**
     * Buys the property
     * @param owner the player who owns the property
     * @param property Property on the Property Tycoon map
     * @return true
     */
     public static boolean buy(int owner, int property){
       String sql = "INSERT INTO owner(owner, property) VALUES(?,?)";  
        try{  
            Connection conn = Connect.connect(); 
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setInt(1, owner);  
            pstmt.setInt(2, property);  
            pstmt.executeUpdate();
             pstmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
      return true;
  }
    
    /**
     * Sells the property
     * @param buyer Players who want to buy property
     * @param property Property on the Property Tycoon map
     * @return true
     */
    public static boolean sell(int buyer, int property){
        String sql = "UPDATE players SET owner = ?"
                        + "WHERE property = ?";
//       String sql = "INSERT INTO owner(owner, property) VALUES(?,?)";  
        try{  
            Connection conn = Connect.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setInt(1, property);  
            pstmt.setInt(2, buyer);  
            pstmt.executeUpdate(); 
             pstmt.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        return true;
    }
    
      /**
       * Updates the amount of player
       * @param id the player id
       * @param amount the amount of player
       */
    public static void update(int id, double amount) { 
        String sql = "UPDATE players SET amount = ?  "
                        + "WHERE id = ?";
            try{  
            Connection conn = Connect.connect(); 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, id);
            
            pstmt.executeUpdate();
            System.out.println("User data updated succefully");
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
  

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
////        double amount = Start.amount(1);
////        double price = price(1);
//        System.out.println(check(0));
//        // TODO code application logic here
//    }
//    
    
}
