package com.example.attendance_management.Faculty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.attendance_management.R;

public class F_main extends AppCompatActivity {
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fmain);
        email=getIntent().getStringExtra("email");
        Toast.makeText(this, email, Toast.LENGTH_SHORT).show();
        Intent i= new Intent(F_main.this,FacultyLandingActivity.class);
        i.putExtra("email",email);
        startActivity(i);
    }
}