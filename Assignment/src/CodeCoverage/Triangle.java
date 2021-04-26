
package CodeCoverage;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Triangle {
    static final int ITERATIONS = 1000;
    static final int MIN_INT = 0;
    static final int MAX_INT = 10;
     public enum Type {
        INVALID,
        SCALENE,
        EQUILATERAL,
        ISOSCELES;
    }

    public static Type classify(int side1, int side2, int side3) {
        Type type;

        if (side1 > side2) {
            int temp = side1;
            side1 = side2;
            side2 = temp;
        }
        if (side1 > side3) {
            int temp = side1;
            side1 = side3;
            side3 = temp;
        }
        if (side2 > side3) {
            int temp = side2;
            side2 = side3;
            side3 = temp;
        }

        if (side1 + side2 <= side3) {
            type = Type.INVALID;
        } else {
            type = Type.SCALENE;
            if (side1 == side2) {
                if (side2 == side3) {
                    type = Type.EQUILATERAL;
                }
            } else {
                if (side2 == side3) {
                    type = Type.ISOSCELES;
                }
            }
        }
        return type;
    }
    static void randomlyTestClassify() {
        Random r = new Random();
        Set<Integer> coveredBranches = new TreeSet<>();

        for (int i=0; i < ITERATIONS; i ++) {
            int side1 = randomInt(r);
            int side2 = randomInt(r);
            int side3 = randomInt(r);
            System.out.println((i+1) + ": [" +"Side1:"+ side1 + ", " + "Side2:"+side2 + ", " +"Side3:" +side3 + "]");
            Type result = instrumentedClassify(side1, side2, side3, coveredBranches);
            System.out.println("-> " + result);

        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Branch Coverage: " + coveredBranches.size() + "/14");
        System.out.println("Covered Branch IDs: " + coveredBranches);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    static int randomInt(Random r) {
        if (MIN_INT == Integer.MIN_VALUE && MAX_INT == Integer.MAX_VALUE) {
            return r.nextInt();
        } else {
            return r.nextInt((MAX_INT - MIN_INT + 1)) + MIN_INT;
        }
    }

    static void coveredBranch(int id, Set<Integer> coveredBranches) {
        if (!coveredBranches.contains(id)) {
            System.out.println("* covered new branch: " + id);
            coveredBranches.add(id);
        }
    }

    static Type instrumentedClassify(int side1, int side2, int side3, Set<Integer> coveredBranches) {
        Type type;

        if (side1 > side2) {
            coveredBranch(1, coveredBranches);
            int temp = side1;
            side1 = side2;
            side2 = temp;
        } else {
            coveredBranch(2, coveredBranches);
        }

        if (side1 > side3) {
            coveredBranch(3, coveredBranches);
            int temp = side1;
            side1 = side3;
            side3 = temp;
        } else {
            coveredBranch(4, coveredBranches);
        }

        if (side2 > side3) {
            coveredBranch(5, coveredBranches);
            int temp = side2;
            side2 = side3;
            side3 = temp;
        } else {
            coveredBranch(6, coveredBranches);
        }

        if (side1 + side2 <= side3) {
            coveredBranch(7, coveredBranches);
            type = Type.INVALID;
        } else {
            coveredBranch(8, coveredBranches);
            type = Type.SCALENE;
            if (side1 == side2) {
                coveredBranch(9, coveredBranches);
                if (side2 == side3) {
                    coveredBranch(10, coveredBranches);
                    type = Type.EQUILATERAL;
                } else {
                    coveredBranch(11, coveredBranches);
                }
            } else {
                coveredBranch(12, coveredBranches);
                if (side2 == side3) {
                    coveredBranch(13, coveredBranches);
                    type = Type.ISOSCELES;
                } else {
                    coveredBranch(14, coveredBranches);
                }
            }
        }
        return type;
    }
}
