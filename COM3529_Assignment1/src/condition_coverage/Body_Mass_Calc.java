/*
 * @Author: Ziting Zhao
 * @Date: 2021-04-25 
 * @FilePath: /COM3529_Assignment1/src/condition_coverage/Body_Mass_Calc.java
 */

package condition_coverage;

public class Body_Mass_Calc {
    //set up the BMI calculator
      static double  BM_Calculator(double weight,double height){  
      double BMI = weight / (height * height);
      if(BMI<18.5)
          System.out.println("This is thiness");
      else if(BMI>=18.5&&BMI<25)
          System.out.println("This is Normal");
      else if(BMI>=25&&BMI<30)
          System.out.println("This is overweight");
      else if(BMI>30)
          System.out.println("This is Obese");
      return BMI; 
      }
  }


