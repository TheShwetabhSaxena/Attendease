package com.example.attendance_management.Faculty.Modal;

public class LoginFacultyModal {
    private String email;
    private String password;


    // Getter Methods

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Setter Methods

    public void setEmail(String email) {
        this.email = email;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public LoginFacultyModal(String email, String password) {
        this.email = email;
        this.password = password;
    }
}