/**GradeCalculator.java
 * Last edited: Oct. 9th, 2019
 * @Author Carter Mooring
 */
package com.CarterCalc.neededfinalgrade;

public class GradeCalculator {
    private float minAvg;
    private float currentAvg;
    private float finalPercentage;

    //This function is the DVC
    public GradeCalculator(){
        minAvg = 0;
        currentAvg = 0;
        finalPercentage  = 0;
    }

    //This function is the EVC
    public GradeCalculator(float minAvg, float currentAvg, float finalPercentage){
        this.minAvg = minAvg;
        this.currentAvg = currentAvg;
        this.finalPercentage = finalPercentage;
    }

    //This function uses the user input to calculate what they need
    double calculateGradeFinal(){
        double finalGrade = ((minAvg - ((1 - (finalPercentage / 100)) * currentAvg)) / (finalPercentage / 100));

        return finalGrade;
    }


}
