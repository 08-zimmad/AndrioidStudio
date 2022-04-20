package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class output extends AppCompatActivity {
    TextView email_id,total_id,teacher_id,course_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        email_id=(TextView) findViewById(R.id.getEmail);
        total_id=(TextView) findViewById(R.id.result);
        teacher_id=(TextView) findViewById(R.id.getTeacher);
        course_id=(TextView) findViewById(R.id.getCourse);


        Intent intent=getIntent();
        Bundle extras =intent.getExtras();
        String Average=extras.getString("Average");
        String getEmail=extras.getString("Email");
        String getTeacher=extras.getString("TeacherName");
        String getCourse=extras.getString("CourseName");

        email_id.setText(getEmail);
        total_id.setText(Average);
        teacher_id.setText(getTeacher);
        course_id.setText(getCourse);

    }
}