package com.tip.studentinformationsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewStudent extends AppCompatActivity {

    EditText studNo, firstName, lastName;
    TextView viewstudNo, viewfirstName, viewlastName, viewspinner;
    Spinner spinner;

    FirebaseDatabase student_firebase;
    DatabaseReference student_database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);

        viewstudNo = findViewById(R.id.textViewEditStudetNumber);
        viewfirstName = findViewById(R.id.textViewEditFirstName);
        viewlastName = findViewById(R.id.textViewEditLastName);
        viewspinner = findViewById(R.id.textViewEditYearLevel);

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


    public void view_student (View view){
        String studNo_;
        studNo_ = studNo.getText().toString().trim();

        Students students = new Students();
        students.setStudent_Number(studNo_);

        student_database.child(students.getStudent_Number()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                firstName.setEnabled(false);
                lastName.setEnabled(false);
                spinner.setEnabled(false);

                viewfirstName.setVisibility(View.VISIBLE);
                firstName.setVisibility(View.VISIBLE);
                viewlastName.setVisibility(View.VISIBLE);
                lastName.setVisibility(View.VISIBLE);
                viewspinner.setVisibility(View.VISIBLE);
                spinner.setVisibility(View.VISIBLE);

                Students viewstudents = snapshot.getValue(Students.class);
                if(viewstudents != null){
                    String firstname = viewstudents.Firstname;
                    String lastname = viewstudents.Lastname;
                    String year_level_ = viewstudents.Year_Level;
                    int year_level = Integer.parseInt(year_level_);

                    firstName.setText(firstname);
                    lastName.setText(lastname);
                    spinner.setSelection((year_level-1));

                    Toast.makeText(ViewStudent.this, "Student has been shown!", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(ViewStudent.this, "Student does not exist!", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}