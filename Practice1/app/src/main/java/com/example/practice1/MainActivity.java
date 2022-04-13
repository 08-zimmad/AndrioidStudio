package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText email;
    AutoCompleteTextView teacherName;
    Button nxtBtn;
    String getTeacherName;
    String getEmail;
    Intent intent;
    ArrayList <String> names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email =(EditText) findViewById(R.id.emailView);
        teacherName=(AutoCompleteTextView) findViewById(R.id.tname);
        nxtBtn=(Button) findViewById(R.id.btn);
        setTeacherName();
        nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEmail=email.getText().toString();
                getTeacherName=teacherName.getText().toString();
                Toast toast=Toast.makeText(getApplicationContext(),getEmail,Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }
    protected void setTeacherName()
    {
        names=new ArrayList<String>();
        names.add("Teacher A");
        names.add("Teacher B");
        names.add("Teacher C");
        ArrayAdapter<String>tNameAdaptr=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,names );
        teacherName.setAdapter(tNameAdaptr);
        teacherName.setThreshold(1);
    }

    protected void SurveyForm(){



//        return intent;
    }

}