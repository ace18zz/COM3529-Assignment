/*
 * @Author: Ziting Zhao
 * @Date: 2021-04-25 
 * @FilePath: /COM3529_Assignment1/src/condition_coverage/MCDC.java
 */

package condition_coverage;


public class MCDC {
    static void MultipleConditionDecisionCoverage(double height ,double weight)
    {
       if(height>=1&&height<=2&&weight>=70&&weight<=100)//it is not necessary evary condition to execute atleast once.
       {
         System.out.println("BMI is normal");
       }
       else  if(height>2&&height<=3&&weight>100)
       {
         System.out.println("BMI is normal");
       }
       else if(height<=1&&weight<70||height>3&&weight>150)
       {
         System.out.println("BMI is not  normal");
       
       }
       else
       {
            System.out.println("BMI is not  normal");
       
       }
    }
    
}
