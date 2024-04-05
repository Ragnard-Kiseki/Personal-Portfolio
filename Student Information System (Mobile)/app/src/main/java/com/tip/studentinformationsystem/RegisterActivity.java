package com.tip.studentinformationsystem;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity{

    EditText email, password;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.editTextRegisterEmail);
        password = findViewById(R.id.editTextRegisterPassword);
        Button register = findViewById(R.id.btn_register);
        mAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(view -> createUser());
    }

    private void createUser(){
        String email_ = email.getText().toString();
        String password_ = password.getText().toString();
        if (TextUtils.isEmpty(email_)){
            email.setError("Please provide field");
            email.requestFocus();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email_).matches()){
            email.setError("The inputted string is not a valid email address");
            email.requestFocus();
        }
        else if (TextUtils.isEmpty(password_)){
            password.setError("Please provide field");
            password.requestFocus();
        }
       else if(password.length() < 6){
            password.setError("Password should be more than 6 characters");
            password.requestFocus();
        }

        else{
            mAuth.createUserWithEmailAndPassword(email_,password_).addOnCompleteListener(task -> {
                if (task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                }else{
                    Toast.makeText(RegisterActivity.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}