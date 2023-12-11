package com.example.attendance_management;

public class AuthenticationModal{
    private float auth_id;
    private float auth_flag;
    private float auth_perm;


    // Getter Methods

    public float getAuth_id() {
        return auth_id;
    }

    public float getAuth_flag() {
        return auth_flag;
    }

    public float getAuth_perm() {
        return auth_perm;
    }

    // Setter Methods

    public void setAuth_id(float auth_id) {
        this.auth_id = auth_id;
    }

    public void setAuth_flag(float auth_flag) {
        this.auth_flag = auth_flag;
    }

    public void setAuth_perm(float auth_perm) {
        this.auth_perm = auth_perm;
    }
}