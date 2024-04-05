package com.tip.studentinformationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class StudentInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_student);

        ToggleButton toggle = findViewById(R.id.toggle_menuOption);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Button AddStudent = findViewById(R.id.btn_addStudent);
                    AddStudent.setVisibility(View.VISIBLE);
                    Button EditStudent = findViewById(R.id.btn_editStudent);
                    EditStudent.setVisibility(View.VISIBLE);
                    Button DeleteStudent = findViewById(R.id.btn_deleteStudent);
                    DeleteStudent.setVisibility(View.VISIBLE);
                    Button ViewStudent = findViewById(R.id.btn_viewStudent);
                    ViewStudent.setVisibility(View.VISIBLE);
                }
                else{
                    Button AddStudent = findViewById(R.id.btn_addStudent);
                    AddStudent.setVisibility(View.GONE);
                    Button EditStudent = findViewById(R.id.btn_editStudent);
                    EditStudent.setVisibility(View.GONE);
                    Button DeleteStudent = findViewById(R.id.btn_deleteStudent);
                    DeleteStudent.setVisibility(View.GONE);
                    Button ViewStudent = findViewById(R.id.btn_viewStudent);
                    ViewStudent.setVisibility(View.GONE);
                }
            }
        });

        Button ButtonAddStudent = findViewById(R.id.btn_addStudent);
        ButtonAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentInformation.this, AddStudent.class));
            }
        });
        Button ButtonEditStudent = findViewById(R.id.btn_editStudent);
        ButtonEditStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentInformation.this, EditStudent.class));
            }
        });
        Button ButtonDeleteStudent = findViewById(R.id.btn_deleteStudent);
        ButtonDeleteStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentInformation.this, DeleteStudent.class));
            }
        });
        Button ButtonViewStudent = findViewById(R.id.btn_viewStudent);
        ButtonViewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentInformation.this, ViewStudent.class));
            }
        });
    }

}