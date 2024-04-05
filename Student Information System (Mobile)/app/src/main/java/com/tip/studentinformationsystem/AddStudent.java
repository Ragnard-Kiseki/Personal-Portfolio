package com.tip.studentinformationsystem;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddStudent extends AppCompatActivity {
    EditText studNo, firstName, lastName;
    Spinner spinner;

    FirebaseDatabase student_firebase;
    DatabaseReference student_database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        studNo = findViewById(R.id.editTextStudentNumber);
        firstName = findViewById(R.id.editTextFirstName);
        lastName = findViewById(R.id.editTextLastName);
        spinner = findViewById(R.id.spinner_year_level);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.year_level, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        student_firebase = FirebaseDatabase.getInstance("https://information-system-75e7b-default-rtdb.asia-southeast1.firebasedatabase.app/");
        student_database = student_firebase.getReference("Students");

    }

    public static class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            parent.getItemAtPosition(pos);
        }

        public void onNothingSelected(AdapterView<?> parent) {
            Spinner spinner = (Spinner) findViewById(R.id.spinner_year_level);
            spinner.setOnItemSelectedListener(this);
        }
    }

    public void add_student(View view) {
        String studNo_, firstName_, lastName_, spinner_;
        studNo_ = studNo.getText().toString().trim();
        firstName_ = firstName.getText().toString().trim();
        lastName_ = lastName.getText().toString().trim();
        spinner_ = spinner.getSelectedItem().toString().trim();

        Students students = new Students();
        students.setStudent_Number(studNo_);
        students.setFirstname(firstName_);
        students.setLastname(lastName_);
        students.setYear_Level(spinner_);
        student_database.child(students.getStudent_Number()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.getValue() == null) {
                    student_database.child(students.getStudent_Number()).setValue(students);
                    Toast.makeText(AddStudent.this, "Student has been added!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddStudent.this, "Student already exist!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}