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

public class NewOkCancelDialogTest {
    
    public NewOkCancelDialogTest() {
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
     * Test of getReturnStatus method, of class NewOkCancelDialog.
     */
    @Test
    public void testGetReturnStatus() {
        System.out.println("getReturnStatus");
        NewOkCancelDialog instance = null;
        int expResult = 0;
        int result = instance.getReturnStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of main method, of class NewOkCancelDialog.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        NewOkCancelDialog.main(args);
    }
    
}
