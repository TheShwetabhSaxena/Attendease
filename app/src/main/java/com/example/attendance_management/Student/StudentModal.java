package com.example.attendance_management.Student;

public class StudentModal {
    private float regno;
    private String name;
    private String course;
    private String branch;
    private String DOB;
    private float batch;
    private String email;
    private float Blocked;
    private String password;


    // Getter Methods

    public float getRegno() {
        return regno;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getBranch() {
        return branch;
    }

    public String getDOB() {
        return DOB;
    }

    public float getBatch() {
        return batch;
    }

    public String getEmail() {
        return email;
    }

    public float getBlocked() {
        return Blocked;
    }

    public String getPassword() {
        return password;
    }

    // Setter Methods

    public void setRegno(float regno) {
        this.regno = regno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setBatch(float batch) {
        this.batch = batch;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBlocked(float Blocked) {
        this.Blocked = Blocked;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public StudentModal(float regno, String name, String course, String branch, String DOB, float batch, String email, float blocked, String password) {
        this.regno = regno;
        this.name = name;
        this.course = course;
        this.branch = branch;
        this.DOB = DOB;
        this.batch = batch;
        this.email = email;
        Blocked = blocked;
        this.password = password;
    }
}
