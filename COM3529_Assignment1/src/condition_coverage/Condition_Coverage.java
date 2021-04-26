/*
 * @Author: Ziting Zhao
 * @Date: 2021-04-25 
 * @FilePath: /COM3529_Assignment1/src/condition_coverage/Condition_Coverage.java
 */

package condition_coverage;
import java.util.Scanner;
public class Condition_Coverage {

   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter how many iterations you want to test: ");
          int iteration = sc.nextInt();
          for(int i=0 ;i<iteration;i++){
          double height=Test_Class.getRandomheight(1, 3);//Max and Min Height
          double weight=Test_Class.getRandomweight(1, 150);//Max and  and min weight
           Test_Class.testcalculator(iteration, weight,height);
           MCC.MultipleConditionCoverage(height, weight);
           MCDC.MultipleConditionDecisionCoverage(height, weight);
          }   //hence it is proved from various test values MCC is more accurate than MCDC
    }
    
}
