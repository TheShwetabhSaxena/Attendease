package com.example.attendance_management.Faculty;

public class FacultyTimetableList {
    private String slot_time;
    private String slot_type;
    private String course_name;



    // Getter Methods

    public String getSlot_time() {
        return slot_time;
    }

    public String getSlot_type() {
        return slot_type;
    }

    public String getCourse_name() {
        return course_name;
    }

    // Setter Methods

    public void setSlot_time(String slot_time) {
        this.slot_time = slot_time;
    }

    public void setSlot_type(String slot_type) {
        this.slot_type = slot_type;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public FacultyTimetableList(String slot_time, String slot_type, String course_name) {
        this.slot_time = slot_time;
        this.slot_type = slot_type;
        this.course_name = course_name;
    }
}