package com.tip.studentinformationsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DeleteStudent extends AppCompatActivity {
    EditText studNo;
    Button delete;

    FirebaseDatabase student_firebase;
    DatabaseReference student_database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);

        studNo = findViewById(R.id.editTextStudentNumber);

        student_firebase = FirebaseDatabase.getInstance("https://information-system-75e7b-default-rtdb.asia-southeast1.firebasedatabase.app/");
        student_database = student_firebase.getReference("Students");
    }

    public void delete_student (View view){
        String studNo_;
        studNo_ = studNo.getText().toString().trim();

        Students students = new Students();
        students.setStudent_Number(studNo_);

        if (TextUtils.isEmpty(studNo_)){
            studNo.setError("Please provide field");
            studNo.requestFocus();
        }

        else{
            student_database.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.hasChild(students.getStudent_Number())){
                        student_database.child(students.getStudent_Number()).removeValue();
                        Toast.makeText(DeleteStudent.this, "Student Deleted!", Toast.LENGTH_SHORT).show();
                        studNo.setText("");
                    }
                    else{
                        Toast.makeText(DeleteStudent.this, "Student Does Not Exist!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
}