/*
 * @Author: Ziting Zhao
 * @Date: 2021-04-25 
 * @FilePath: /COM3529_Assignment1/src/condition_coverage/Test_Class.java
 */

package condition_coverage;

public class Test_Class {
    public static final String TEXT_GREEN = "\u001B[32m";
    int myAbs(int x) {
    if (x > 0) { 
        return x;
    }
    else {
        return x;
    }
   }
    

  static double getRandomweight(int max,int min) {
       double weight= (double) ((Math.random() * (max - min)) + min);
       return weight;
    
  }
  
   static double getRandomheight(int min,int max)
    {
      double height=(double) ((Math.random() * (max - min)) + min);
      return height;
    }
   static void testcalculator(int n,double x, double y) {
       try {
           
        double result =Body_Mass_Calc.BM_Calculator(x, y);
        assert(x / (x * y) == result);
        System.out.println(TEXT_GREEN+"There is no Exception means passed"+" Value is: "+result);
    }
      
    catch(Exception e) {
      System.out.println("Filed Should not have thrown any exception");
   }
} 

}
