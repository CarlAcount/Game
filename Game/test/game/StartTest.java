/**
 *
 * @author Carl and GuoHao
 * @version 1.0
 */
package game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StartTest {
    
    public StartTest() {
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
     * Test of Users method, of class Start.
     */
    @Test
    public void testUsers() {
        System.out.println("Users");
        String expResult = "Player List \t";
        String result = Start.Users();
        assertEquals(expResult, result);
    }

    /**
     * Test of User method, of class Start.
     */
    @Test
    public void testUser() {
        System.out.println("User");
        int id = 0;
        String expResult = "";
        String result = Start.User(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeUser method, of class Start.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        Start.removeUser();
    }

    /**
     * Test of amount method, of class Start.
     */
    @Test
    public void testAmount_int() {
        System.out.println("amount");
        int id = 0;
        Double expResult = 0.0;
        Double result = Start.amount(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of Amount method, of class Start.
     */
    @Test
    public void testAmount_0args() {
        System.out.println("Amount");
        String expResult = "Player \t Amount \n";
        String result = Start.Amount();
        assertEquals(expResult, result);
    }

    /**
     * Test of Count method, of class Start.
     */
    @Test
    public void testCount() {
        System.out.println("Count");
        int expResult = 0;
        int result = Start.Count();
        assertEquals(expResult, result);
    }
    
}
