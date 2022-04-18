package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Evaluation extends AppCompatActivity {
    RadioGroup rGroup1,rGroup2,rGroup3;
    RadioButton rbtn1,rbtn2,rbtn3;
    Button bttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);

        rGroup1= (RadioGroup) findViewById(R.id.radio);
        rGroup2= (RadioGroup) findViewById(R.id.radio2);
        rGroup3= (RadioGroup) findViewById(R.id.radio3);

        bttn=(Button) findViewById(R.id.btn);
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            int rId1,rId2,rId3;
            rId1=rGroup1.getCheckedRadioButtonId();
            rId2=rGroup2.getCheckedRadioButtonId();
            rId3=rGroup3.getCheckedRadioButtonId();
            rbtn1=(RadioButton) findViewById(rId1);
            rbtn2=(RadioButton) findViewById(rId2);
            rbtn3=(RadioButton) findViewById(rId3);

            rbtn2.getText();
            rbtn3.getText();
                Toast.makeText(Evaluation.this, rbtn1.getText()+" "+rbtn2.getText()+" "+rbtn3.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}