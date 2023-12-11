package com.example.attendance_management.Student;

public class StudentAttendanceModal {
    private String slot_time;
    private float slot_type;
    private String course_name;
    private String department;


    // Getter Methods

    public String getSlot_time() {
        return slot_time;
    }

    public float getSlot_type() {
        return slot_type;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getDepartment() {
        return department;
    }

    // Setter Methods

    public void setSlot_time(String slot_time) {
        this.slot_time = slot_time;
    }

    public void setSlot_type(float slot_type) {
        this.slot_type = slot_type;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public StudentAttendanceModal(String slot_time, float slot_type, String course_name, String department) {
        this.slot_time = slot_time;
        this.slot_type = slot_type;
        this.course_name = course_name;
        this.department = department;
    }
}