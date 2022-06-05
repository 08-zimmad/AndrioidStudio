package com.example.myfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class User extends AppCompatActivity {
    private Button logout;
    TextView name,age;
    FirebaseAuth fireAuth;
    private FirebaseAuth.AuthStateListener authListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        name=(TextView) findViewById(R.id.namefield);
        age=(TextView) findViewById(R.id.agefield);
        logout=(Button) findViewById(R.id.logbtn);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fireAuth.getInstance().signOut();
                Intent intent=new Intent(User.this,LoginPage.class);
                startActivity(intent);
            }
        });

    }
}