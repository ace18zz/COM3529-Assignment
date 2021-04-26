
package example;

import CodeCoverage.BMI;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class BMIIT {
    
    public BMIIT() {
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
    public void testCalculate() {
        System.out.println("calculate");
        double weightInPounds = 130;
        int heightFeet = 5;
        int heightInches = 9;
        BMI.Type expResult = BMI.Type.NORMAL;
        BMI.Type result = BMI.calculate(weightInPounds, heightFeet, heightInches);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("test passed");
    }
    
}
