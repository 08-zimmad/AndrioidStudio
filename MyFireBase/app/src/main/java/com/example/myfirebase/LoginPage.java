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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;

public class LoginPage extends AppCompatActivity {
    private EditText emailfield,passwordfield;
    private Button signUpBtn,signInBtn;
    FirebaseAuth firebase;
    private FirebaseAuth.AuthStateListener authListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        firebase = FirebaseAuth.getInstance();
        emailfield=(EditText) findViewById(R.id.emailtext);
        passwordfield=(EditText) findViewById(R.id.pwdfield);
        signUpBtn=(Button) findViewById(R.id.btnUp);
        signInBtn=(Button) findViewById(R.id.btnIn);
        authListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if(user!=null){
                    Toast.makeText(LoginPage.this,"Already Logged In", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginPage.this,User.class));
                }
                else{
                    Toast.makeText(LoginPage.this,"Login To Continue", Toast.LENGTH_SHORT).show();
                }
            }
        };
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginPage.this,MainActivity.class));
            }
        });
        signInBtn.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(LoginPage.this,"Please Enter the credentials",Toast.LENGTH_SHORT).show();
                }
                else if(!email.isEmpty() && !pwd.isEmpty()) {
                    firebase.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(LoginPage.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(LoginPage.this.getApplicationContext(),"Sign In Failed"
                                        +task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent intent = new Intent(LoginPage.this, User.class);
                                startActivity(intent);
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(LoginPage.this,"Error",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        firebase.addAuthStateListener(authListener);
    }
}