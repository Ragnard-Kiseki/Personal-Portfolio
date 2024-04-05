package com.tip.studentinformationsystem;

public class Students {
    String Student_Number,Firstname,Lastname,Year_Level;

    public Students() {

    }

    public Students(String student_Number, String firstname, String lastname, String year_Level) {
        Student_Number = student_Number;
        Firstname = firstname;
        Lastname = lastname;
        Year_Level = year_Level;
    }

    public String getStudent_Number() {
        return Student_Number;
    }

    public void setStudent_Number(String student_Number) {
        Student_Number = student_Number;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getYear_Level() {
        return Year_Level;
    }

    public void setYear_Level(String year_Level) {
        Year_Level = year_Level;
    }
}
