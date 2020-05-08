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

public class LevelTest {
    
    public LevelTest() {
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
     * Test of playerLevel method, of class Level.
     */
    @Test
    public void testPlayerLevel() {
        System.out.println("playerLevel");
        int player = 0;
        int expResult = 0;
        int result = Level.playerLevel(player);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateLevel method, of class Level.
     */
    @Test
    public void testUpdateLevel() {
        System.out.println("updateLevel");
        int level = 0;
        int player = 0;
        Level.updateLevel(level, player);
    }

    /**
     * Test of insert method, of class Level.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        int level = 0;
        int player = 0;
        Level.insert(level, player);
    }

    /**
     * Test of check method, of class Level.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        int id = 0;
        boolean expResult = false;
        boolean result = Level.check(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of init method, of class Level.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        Level.init();
    }
    
}
