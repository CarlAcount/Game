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

public class PropertiesTest {
    
    public PropertiesTest() {
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
     * Test of init method, of class Properties.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        boolean expResult = true;
        boolean result = Properties.init();
        assertEquals(expResult, result);
    }


    /**
     * Test of property method, of class Properties.
     */
    @Test
    public void testProperty() {
        System.out.println("property");
        int id = 0;
        String expResult = "";
        String result = Properties.property(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of isBuyable method, of class Properties.
     */
    @Test
    public void testIsBuyable() {
        System.out.println("isBuyable");
        int id = 0;
        Boolean expResult = false;
        Boolean result = Properties.isBuyable(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of price method, of class Properties.
     */
    @Test
    public void testPrice() {
        System.out.println("price");
        int id = 0;
        double expResult = 0.0;
        double result = Properties.price(id);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of rentAmount method, of class Properties.
     */
    @Test
    public void testRentAmount() {
        System.out.println("rentAmount");
        int id = 0;
        double expResult = 0.0;
        double result = Properties.rentAmount(id);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getOwner method, of class Properties.
     */
    @Test
    public void testGetOwner() {
        System.out.println("getOwner");
        int id = 0;
        int expResult = 0;
        int result = Properties.getOwner(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of check method, of class Properties.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        int id = 0;
        boolean expResult = false;
        boolean result = Properties.check(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of rent method, of class Properties.
     */
    @Test
    public void testRent() {
        System.out.println("rent");
        int player = 0;
        int property = 0;
        boolean expResult = true;
        boolean result = Properties.rent(player, property);
        assertEquals(expResult, result);
    }

    /**
     * Test of buy method, of class Properties.
     */
    @Test
    public void testBuy() {
        System.out.println("buy");
        int owner = 0;
        int property = 0;
        boolean expResult = true;
        boolean result = Properties.buy(owner, property);
        assertEquals(expResult, result);
    }

    /**
     * Test of sell method, of class Properties.
     */
    @Test
    public void testSell() {
        System.out.println("sell");
        int buyer = 0;
        int property = 0;
        boolean expResult = true;
        boolean result = Properties.sell(buyer, property);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class Properties.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        int id = 0;
        double amount = 0.0;
        Properties.update(id, amount);
    }
    
}
