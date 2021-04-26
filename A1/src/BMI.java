/*
 * @Author: your name
 * @Date: 2021-04-26 14:03:18
 * @LastEditTime: 2021-04-26 14:13:00
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /COM3529Assignment/A1/src/BMI.java
 */

public class BMI {
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
}
