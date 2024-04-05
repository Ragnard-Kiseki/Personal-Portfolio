package com.tip.studentinformationsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditStudent extends AppCompatActivity {

    EditText studNo, firstName, lastName;
    TextView viewstudNo, viewfirstName, viewlastName, viewspinner;
    Spinner spinner;
    Button update,again;

    FirebaseDatabase student_firebase;
    DatabaseReference student_database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

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

        update = findViewById(R.id.btn_EditStudentFinal);
        again = findViewById(R.id.btn_getListEdit);

        student_firebase = FirebaseDatabase.getInstance("https://information-system-75e7b-default-rtdb.asia-southeast1.firebasedatabase.app/");
        student_database = student_firebase.getReference("Students");

        update.setOnClickListener(v -> {
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

            student_database.addListenerForSingleValueEvent(new ValueEventListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.hasChild(students.getStudent_Number())){
                        student_database.child(students.getStudent_Number()).setValue(students);
                        Toast.makeText(EditStudent.this, "Student has been updated!", Toast.LENGTH_SHORT).show();
                        firstName.setText("");
                        lastName.setText("");
                        spinner.setSelection(0);
                        viewfirstName.setVisibility(View.GONE);
                        firstName.setVisibility(View.GONE);
                        viewlastName.setVisibility(View.GONE);
                        lastName.setVisibility(View.GONE);
                        viewspinner.setVisibility(View.GONE);
                        spinner.setVisibility(View.GONE);
                        update.setVisibility(View.GONE);
                    }
                    else{
                        firstName.setText("");
                        lastName.setText("");
                        spinner.setSelection(0);
                        viewfirstName.setVisibility(View.GONE);
                        firstName.setVisibility(View.GONE);
                        viewlastName.setVisibility(View.GONE);
                        lastName.setVisibility(View.GONE);
                        viewspinner.setVisibility(View.GONE);
                        spinner.setVisibility(View.GONE);
                        update.setVisibility(View.GONE);
                        Toast.makeText(EditStudent.this, "Student does not exist!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(EditStudent.this, "Check your student number!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        });
    }

    public static class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
            parent.getItemAtPosition(pos);
        }

        public void onNothingSelected(AdapterView<?> parent) {
            Spinner spinner = (Spinner) findViewById(R.id.spinner_year_level);
            spinner.setOnItemSelectedListener(this);
        }
    }

    public void edit_get_list(View view) {
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
                @SuppressLint("SetTextI18n")
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.hasChild(students.getStudent_Number())){
                        viewfirstName.setVisibility(View.VISIBLE);
                        firstName.setVisibility(View.VISIBLE);
                        viewlastName.setVisibility(View.VISIBLE);
                        lastName.setVisibility(View.VISIBLE);
                        viewspinner.setVisibility(View.VISIBLE);
                        spinner.setVisibility(View.VISIBLE);
                        update.setVisibility(View.VISIBLE);
                        Toast.makeText(EditStudent.this, "Student Exist!", Toast.LENGTH_SHORT).show();
                        student_database.child(students.getStudent_Number()).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                Students studentProfile = snapshot.getValue(Students.class);

                                String firstname = studentProfile.Firstname;
                                String lastname = studentProfile.Lastname;
                                String yearlevel_ = studentProfile.Year_Level;
                                int yearlevel = Integer.parseInt(yearlevel_);

                                firstName.setHint(firstname);
                                lastName.setHint(lastname);
                                spinner.setSelection((yearlevel-1));
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                    else{
                        viewfirstName.setVisibility(View.GONE);
                        firstName.setVisibility(View.GONE);
                        viewlastName.setVisibility(View.GONE);
                        lastName.setVisibility(View.GONE);
                        viewspinner.setVisibility(View.GONE);
                        spinner.setVisibility(View.GONE);
                        update.setVisibility(View.GONE);
                        Toast.makeText(EditStudent.this, "Student Does Not Exist!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }


}