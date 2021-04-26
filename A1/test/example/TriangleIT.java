
package example;

import CodeCoverage.Triangle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TriangleIT {
    
    public TriangleIT() {
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

    
    @Test
    public void testClassify() {
        System.out.println("classify");
        int side1 = 0;
        int side2 = 0;
        int side3 = 0;
        Triangle.Type expResult = null;
        Triangle.Type result = Triangle.classify(side1, side2, side3);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
