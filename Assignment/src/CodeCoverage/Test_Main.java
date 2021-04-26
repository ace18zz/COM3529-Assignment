/*
 * @Author: Ziting zhao
 * @Date: 2021-04-26 
 * @Description: The main function of this tool
 * @FilePath: /COM3529 Software Testing and Analysis/COM3529Assignment/Assignment/src/CodeCoverage/Test_Main.java
 */


package CodeCoverage;
import java.util.Scanner;



public class Test_Main {
    public static final String TEXT_RED= "\\u001B[31m";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Select your choice \n1.Triangle\n2.BMI Calculator\n");
        System.out.println("Enter your choice:");
        int choice=sc.nextInt();
        if(choice==1)
            Triangle.randomlyTestClassify();
        else if(choice==2)
            BMI.randomlyTestClassify();
        else
            System.out.println(TEXT_RED+"Please select right option!!!");
            
    }
      

    
}
