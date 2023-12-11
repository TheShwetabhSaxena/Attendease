package com.example.attendance_management.Student;

public class AttendanceModalRequest {
    private String regno;
    private String day;


    // Getter Methods

    public String getRegno() {
        return regno;
    }

    public String getDay() {
        return day;
    }

    // Setter Methods

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public AttendanceModalRequest(String regno, String day) {
        this.regno = regno;
        this.day = day;
    }
}