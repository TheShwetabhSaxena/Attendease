package com.example.attendance_management.Faculty.Modal;

public class FacultyModal {
    private float p_id;
    private String name;
    private String course;
    private String dept;
    private String DOB;
    private String email;
    private String password;
    private float blocked;


    // Getter Methods

    public float getP_id() {
        return p_id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getDept() {
        return dept;
    }

    public String getDOB() {
        return DOB;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public float getBlocked() {
        return blocked;
    }

    // Setter Methods

    public void setP_id(float p_id) {
        this.p_id = p_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public FacultyModal(float p_id, String name, String course, String dept, String DOB, String email, String password) {
        this.p_id = p_id;
        this.name = name;
        this.course = course;
        this.dept = dept;
        this.DOB = DOB;
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBlocked(float blocked) {
        this.blocked = blocked;
    }
}