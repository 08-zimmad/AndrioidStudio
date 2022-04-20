package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Evaluation extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    EditText email;
    AutoCompleteTextView teacherName;
    Button nxtBtn;
    String getTeacherName, getCourseName;
    String getEmail;
    Spinner spinner;
    ArrayList<String> names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email =(EditText) findViewById(R.id.emailView);
        teacherName=(AutoCompleteTextView) findViewById(R.id.tname);
        nxtBtn=(Button) findViewById(R.id.btn);
        setTeacherName();

        spinner=(Spinner) findViewById(R.id.spin);
        ArrayAdapter<CharSequence> cNameAdaptr=ArrayAdapter.createFromResource(this, R.array.courseName, android.R.layout.simple_spinner_dropdown_item);
        cNameAdaptr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(cNameAdaptr);
        spinner.setOnItemSelectedListener(this);
        //Button
        nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEmail=email.getText().toString();
                getTeacherName=teacherName.getText().toString();
                getCourseName=spinner.getSelectedItem().toString();

                Intent intent= getIntent();
                String average=intent.getStringExtra("Average");

                Bundle extras=new Bundle();
                extras.putString("Average",average);
                extras.putString("Email",getEmail);
                extras.putString("TeacherName",getTeacherName);
                extras.putString("CourseName",getCourseName);

                intent=new Intent(Evaluation.this, output.class);
                intent.putExtras(extras);
                startActivity(intent);

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


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    getCourseName=adapterView.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}