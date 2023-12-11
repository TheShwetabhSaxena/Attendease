package com.example.attendance_management.Faculty.Modal;

public class AttendanceFacultyModalRequest {
    private String p_id;
    private String day;


    // Getter Methods

    public String getP_id() {
        return p_id;
    }

    public String getDay() {
        return day;
    }

    // Setter Methods

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public AttendanceFacultyModalRequest(String p_id, String day) {
        this.p_id = p_id;
        this.day = day;
    }
}