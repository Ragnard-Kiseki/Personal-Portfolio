package com.tip.studentinformationsystem;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText email_ad, password_ad;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView register = findViewById(R.id.textViewRegister);
        register.setOnClickListener(this);

        TextView reset = findViewById(R.id.textViewForgotPassword);
        reset.setOnClickListener(this);

        Button login = findViewById(R.id.btn_login);
        login.setOnClickListener(this);

        email_ad = findViewById(R.id.editTextLogInEmail);
        password_ad = findViewById(R.id.editTextLogInPassword);
        mAuth = FirebaseAuth.getInstance();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textViewRegister:
                startActivity(new Intent(this, RegisterActivity.class));
                break;

            case R.id.btn_login:
                userLogin();
                break;

            case R.id.textViewForgotPassword:
                startActivity(new Intent(this, ForgotPassword.class));
                break;

        }
    }

    private void userLogin() {
        String email_ = email_ad.getText().toString().trim();
        String password_ = password_ad.getText().toString().trim();

        if(email_.isEmpty()){
            email_ad.setError("Please provide field");
            email_ad.requestFocus();
            return;
        }

        if(password_.isEmpty()){
            password_ad.setError("Please provide field");
            password_ad.requestFocus();
            return;
        }

        if(password_.length() < 6){
            password_ad.setError("Password length is 6 above");
            password_ad.requestFocus();
            return;
        }

        //progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email_,password_)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            if (user.isEmailVerified()){
                                startActivity(new Intent(MainActivity.this, StudentInformation.class));
                                Toast.makeText(MainActivity.this, "Successful Login", Toast.LENGTH_LONG).show();
                            }
                            else{
                                user.sendEmailVerification();
                                Toast.makeText(MainActivity.this, "Check email to get verified!", Toast.LENGTH_LONG).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Failed to Login", Toast.LENGTH_LONG).show();
                        }

                    }
                });
    }
}