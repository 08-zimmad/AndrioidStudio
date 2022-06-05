package com.example.myfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private EditText emailfield,passwordfield;
    private Button signUpBtn,signInBtn;
    FirebaseAuth firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebase = FirebaseAuth.getInstance();
        emailfield=(EditText) findViewById(R.id.emailtext);
        passwordfield=(EditText) findViewById(R.id.pwdfield);

        signUpBtn=(Button) findViewById(R.id.btnUp);
        signInBtn=(Button) findViewById(R.id.btnIn);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email,pwd;
                email=emailfield.getText().toString();
                pwd=passwordfield.getText().toString();
                if(email.isEmpty())
                {
                    emailfield.setError("Email is missing");
                    emailfield.requestFocus();
                }
                else if(pwd.isEmpty())
                {
                    passwordfield.setError("Password is missing");
                    passwordfield.requestFocus();
                }
                else if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please Enter the credentials",Toast.LENGTH_SHORT).show();
                }
                else{
                    firebase.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(MainActivity.this.getApplicationContext(),"Sign Up Failed"
                                        +task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Intent intent=new Intent(MainActivity.this,User.class);
                                startActivity(intent);
                            }
                        }
                    });
                }


            }
        });

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LoginPage.class));
            }
        });
    }
}