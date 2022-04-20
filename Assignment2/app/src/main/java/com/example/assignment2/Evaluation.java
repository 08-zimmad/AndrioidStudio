package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Evaluation extends AppCompatActivity {
    RadioGroup rGroup1, rGroup2, rGroup3, rGroup4, rGroup5, rGroup6;
    RadioButton rbtn1, rbtn2, rbtn3, rbtn4, rbtn5, rbtn6;
    Button bttn;
    int rbtn1Eval, rbtn2Eval, rbtn3Eval, rbtn4Eval, rbtn5Eval, rbtn6Eval;
    float total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);

        rGroup1 = (RadioGroup) findViewById(R.id.radio);
        rGroup2 = (RadioGroup) findViewById(R.id.radio2);
        rGroup3 = (RadioGroup) findViewById(R.id.radio3);
        rGroup4 = (RadioGroup) findViewById(R.id.radio4);
        rGroup5 = (RadioGroup) findViewById(R.id.radio5);
        rGroup6 = (RadioGroup) findViewById(R.id.radio6);

        bttn = (Button) findViewById(R.id.btn);
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rId1, rId2, rId3, rId4, rId5, rId6;
                rId1 = rGroup1.getCheckedRadioButtonId();
                rId2 = rGroup2.getCheckedRadioButtonId();
                rId3 = rGroup3.getCheckedRadioButtonId();
                rId4 = rGroup4.getCheckedRadioButtonId();
                rId5 = rGroup5.getCheckedRadioButtonId();
                rId6 = rGroup6.getCheckedRadioButtonId();
                rbtn1 = (RadioButton) findViewById(rId1);
                rbtn2 = (RadioButton) findViewById(rId2);
                rbtn3 = (RadioButton) findViewById(rId3);
                rbtn4 = (RadioButton) findViewById(rId4);
                rbtn5 = (RadioButton) findViewById(rId5);
                rbtn6 = (RadioButton) findViewById(rId6);

                if (rbtn1 == null || rbtn2 == null || rbtn3 == null || rbtn4 == null || rbtn5 == null || rbtn6 == null) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Complete Survey", Toast.LENGTH_LONG);
                    toast.show();
                } else {

                    R_Group1Eval(rbtn1.getText().toString());
                    R_Group2Eval(rbtn2.getText().toString());
                    R_Group3Eval(rbtn3.getText().toString());
                    R_Group4Eval(rbtn4.getText().toString());
                    R_Group5Eval(rbtn5.getText().toString());
                    R_Group6Eval(rbtn6.getText().toString());
                    getAverage(rbtn1Eval,rbtn2Eval,rbtn3Eval,rbtn4Eval,rbtn5Eval,rbtn6Eval);
                    Intent intent=getIntent();
                    Bundle extras =intent.getExtras();
                    String campusName=extras.getString("campusName");
                    extras.putString("campusName",campusName);
                    extras.putString("Average", Float.toString(total));
                    intent = new Intent(Evaluation.this,NextActivity.class);
                    intent.putExtras(extras);
                    startActivity(intent);


                }
            }
        });


    }

    public void R_Group1Eval(String a) {
        if (a.equals("Excellent")) {
            rbtn1Eval = 90;
        } else if (a.equals("Good") ) {
            rbtn1Eval = 70;
        } else if (a.equals("Average")) {
            rbtn1Eval = 55;
        } else if (a.equals("Not Satisfactory")) {
            rbtn1Eval = 40;
        }

    }

    public void R_Group2Eval(String a) {
        if (a.equals("Excellent")) {
            rbtn2Eval = 90;
        } else if (a.equals("Good")) {
            rbtn2Eval = 70;
        } else if (a.equals("Average")) {
            rbtn2Eval = 55;
        } else if (a.equals("Not Satisfactory")) {
            rbtn2Eval = 40;
        }

    }

    public void R_Group3Eval(String a) {
        if (a.equals("Excellent") ) {
            rbtn3Eval = 90;
        } else if (a.equals("Good")) {
            rbtn3Eval = 70;
        } else if (a.equals("Average") ) {
            rbtn3Eval = 55;
        } else if (a.equals("Not Satisfactory") ) {
            rbtn3Eval = 40;
        }

    }

    public void R_Group4Eval(String a) {
        if (a.equals("Excellent")) {
            rbtn4Eval = 90;
        } else if (a.equals("Good")) {
            rbtn4Eval = 70;
        } else if (a.equals("Average")) {
            rbtn4Eval = 55;
        } else if (a.equals("Not Satisfactory")) {
            rbtn4Eval = 40;
        }


    }

    public void R_Group5Eval(String a) {
        if (a.equals("Excellent")) {
            rbtn5Eval = 90;
        } else if (a.equals("Good")) {
            rbtn5Eval = 70;
        } else if (a.equals("Average") ) {
            rbtn5Eval = 55;
        } else if (a.equals("Not Satisfactory") ) {
            rbtn5Eval = 40;
        }

    }

    public void R_Group6Eval(String a) {
        if (a.equals("Excellent")) {
            rbtn6Eval = 90;
        } else if (a.equals("Good") ) {
            rbtn6Eval = 70;
        } else if (a.equals("Average")) {
            rbtn6Eval = 55;
        } else if (a.equals("Not Satisfactory")) {
            rbtn6Eval = 40;
        }
    }

    public void getAverage(int a,int b,int c,int d,int e,int f)
    {
        total=a+b+c+d+e+f;
        total=total/6;
    }
    }
