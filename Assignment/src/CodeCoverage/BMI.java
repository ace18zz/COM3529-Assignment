
package CodeCoverage;


import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class BMI {
    static final int ITERATIONS = 1000;
    static final int MIN_INT1 = 0;
    static final int MAX_INT1 = 10;
     static final int MIN_INT2 = 0;
    static final int MAX_INT2 = 12;
    static final int MIN_INT3 = 0;
    static final int MAX_INT3 = 200;
    public enum Type {
        UNDERWEIGHT,
        NORMAL,
        OVERWEIGHT,
        OBESE;
    }

    public static Type calculate(double weightInPounds, int heightFeet, int heightInches) {
        double weightInKilos = weightInPounds * 0.453592;
        double heightInMeters = ((heightFeet * 12) + heightInches) * .0254;
        double bmi = weightInKilos / Math.pow(heightInMeters, 2.0);
        System.out.println(bmi);
        if (bmi < 18.5) {
            return Type.UNDERWEIGHT;
        } else if (bmi >= 17.5 && bmi < 25) {
            return Type.NORMAL;
        } else if (bmi >= 25 && bmi < 30) {
            return Type.OVERWEIGHT;
        } else {
            return Type.OBESE;
        }
    }
    static void randomlyTestClassify() {
        Random r = new Random();
        Set<Integer> coveredBranches = new TreeSet<>();

        for (int i=0; i < ITERATIONS; i ++) {
            int Heightfeet = randomIntHeightfeet(r);
            int Heightinch= randomIntHeightinch(r);
            int weight = randomIntweight(r);
            System.out.println((i+1) + ": [" + Heightfeet +"Feet"+ ", " + Heightinch+"inch" + ", " + weight+"pounds" + "]");
            BMI.Type result = instrumentedClassify(Heightfeet, Heightinch,weight, coveredBranches);
            System.out.println("-> " + result);

        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Branch Coverage: " + coveredBranches.size() + "/4");
        System.out.println("Covered Branch IDs: " + coveredBranches);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    static int randomIntHeightfeet(Random r) {
        if (MIN_INT1 == Integer.MIN_VALUE && MAX_INT1 == Integer.MAX_VALUE) {
            return r.nextInt();
        } else {
            return r.nextInt((MAX_INT1 - MIN_INT1 + 1)) + MIN_INT1;
        }
    }
static int randomIntHeightinch(Random r) {
        if (MIN_INT2 == Integer.MIN_VALUE && MAX_INT2 == Integer.MAX_VALUE) {
            return r.nextInt();
        } else {
            return r.nextInt((MAX_INT2 - MIN_INT2 + 1)) + MIN_INT2;
        }
    }
static int randomIntweight(Random r) {
        if (MIN_INT3 == Integer.MIN_VALUE && MAX_INT3 == Integer.MAX_VALUE) {
            return r.nextInt();
        } else {
            return r.nextInt((MAX_INT3- MIN_INT3 + 1)) + MIN_INT3;
        }
    }
    static void coveredBranch(int id, Set<Integer> coveredBranches) {
        if (!coveredBranches.contains(id)) {
            System.out.println("* covered new branch: " + id);
            coveredBranches.add(id);
        }
    }

    static BMI.Type instrumentedClassify(int heightfeet, int heightinch, int weight, Set<Integer> coveredBranches) {
        BMI.Type type;
          double bmi=(weight * 0.453592)/Math.pow(((heightfeet * 12) + heightinch) * .0254,2);
        if ( bmi< 17.5) {
            coveredBranch(1, coveredBranches);
            type = BMI.Type.UNDERWEIGHT;
            
        } 
         else   if (bmi >= 17.5 && bmi < 25) {
                coveredBranch(2, coveredBranches);
                    type =BMI.Type.NORMAL;
                } 
         else   if (bmi >= 25 && bmi < 30) {
                coveredBranch(3, coveredBranches);
                    type =BMI.Type.OVERWEIGHT;
                } 
        else{
            
                coveredBranch(4, coveredBranches);
                    type =BMI.Type.OBESE;
                } 
        return type;
    }
}
