/**
 *
 * @author Carl and GuoHao
 * @version 1.0
 */
package game;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConnectTest {
    
    public ConnectTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class Connect.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        String name = "";
        double amount = 0.0;
        Connect.insert(name, amount);
    }

    /**
     * Test of createNewTable method, of class Connect.
     */
    @Test
    public void testCreateNewTable() {
        System.out.println("createNewTable");
        Connect.createNewTable();
    }

    /**
     * Test of update method, of class Connect.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        int id = 0;
        double amount = 0.0;
        Connect.update(id, amount);
    }

    /**
     * Test of getMydata method, of class Connect.
     */
    @Test
    public void testGetMydata() {
        System.out.println("getMydata");
        int id = 0;
        Connect instance = new Connect();
        instance.getMydata(id);
    }
    
}
