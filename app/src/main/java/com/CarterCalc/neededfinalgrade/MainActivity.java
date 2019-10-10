/** MainActivity.java
 * Last edited: Oct. 9th, 2019
 * @Author Carter Mooring
 */

package com.CarterCalc.neededfinalgrade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculateButton = (Button) findViewById(R.id.calculateButton);   //make the button addressable
        final EditText desiredGradeEdit = (EditText) findViewById(R.id.desiredGradeEdit);
        final EditText minAvgEdit = (EditText) findViewById(R.id.minAvgEdit);
        final EditText currentAvgEdit = (EditText) findViewById(R.id.currentAvgEdit);
        final EditText finalPercentageEdit = (EditText) findViewById(R.id.finalPercentageEdit);
        final TextView requiredScoreText = (TextView) findViewById(R.id.requiredScoreText);
        final TextView desiredGradeDisplay = (TextView) findViewById(R.id.desiredGradeDisplay);

        calculateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            //This function brings all the components together and helps the app run smoothly like it is supposed to
            public void onClick(View view){
                String desiredGrade = desiredGradeEdit.getText().toString();
                float minAvg = Float.parseFloat(minAvgEdit.getText().toString());
                float currentAvg = Float.parseFloat(currentAvgEdit.getText().toString());
                float finalPercentage = Float.parseFloat(finalPercentageEdit.getText().toString());

                GradeCalculator gradeCalculator = new GradeCalculator(minAvg, currentAvg, finalPercentage);

                DecimalFormat df = new DecimalFormat("####0.00");
                double test = gradeCalculator.calculateGradeFinal();

                if(test > 100){
                    requiredScoreText.setText("Maybe try for a lower grade because you need a score of over 100 percent to get a");
                } else if (test < 0){
                    requiredScoreText.setText("You don't need to take the final to get a");
                } else {
                    requiredScoreText.setText("You need a score of " + df.format(gradeCalculator.calculateGradeFinal()) + " on the final to earn a");
                }

                desiredGradeDisplay.setText(desiredGrade);
            }
        });
    }
}