package com.example.attendance_management.Faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.attendance_management.AboutUs;
import com.example.attendance_management.LoginActivity;
import com.example.attendance_management.R;
import com.example.attendance_management.Settings;

import java.util.ArrayList;

public class CreateAttendanceActivity extends AppCompatActivity {
    Spinner spinner, spinner1;
    ArrayList<String> courses = new ArrayList<>();
    ArrayList<String> slots = new ArrayList<>();
    Button button;
    String email;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menuItem1){
            Toast.makeText(this, "Show profile", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.menuItem2){
            Intent fIntent = new Intent(CreateAttendanceActivity.this, AboutUs.class);
            CreateAttendanceActivity.this.startActivity(fIntent);
        }
        else if (id == R.id.menuItem2){
            AlertDialog.Builder builder = new AlertDialog.Builder(CreateAttendanceActivity.this);
            builder.setMessage("Are you sure you want to logout?");
            builder.setTitle("Alert!");
            builder.setCancelable(true);
            builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which )->{
                Intent fIntent = new Intent(CreateAttendanceActivity.this, LoginActivity.class);
                CreateAttendanceActivity.this.startActivity(fIntent);
            });
            builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which )->{
                dialog.cancel();
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            Toast.makeText(this, "Logged out!", Toast.LENGTH_SHORT).show();
        } else if (id==R.id.menuItem4) {
            Intent fIntent = new Intent(CreateAttendanceActivity.this, Settings.class);
            CreateAttendanceActivity.this.startActivity(fIntent);

        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.app_bar_options, menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_attendance);
        spinner = findViewById(R.id.sf1);
        spinner1 = findViewById(R.id.sf2);
        button = findViewById(R.id.loginButton);
        email=getIntent().getStringExtra("email");

        if(email.equals("faculty")){
            courses.add("DAA");
            courses.add("DBS");


        } else if (email.equals("vibha@manipal.edu")) {
            courses.add("ES");
            courses.add("DMPA");
            courses.add("NS");
            courses.add("WCC");

        }

        slots.add("8:30 AM, Friday");
        slots.add("1:00 PM, Friday");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, slots);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        spinner1.setAdapter(adapter1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fIntent = new Intent(CreateAttendanceActivity.this, AttendanceShowActivity.class);
                CreateAttendanceActivity.this.startActivity(fIntent);
            }
        });
    }
}