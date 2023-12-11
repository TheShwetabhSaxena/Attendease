package com.example.attendance_management.Faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.attendance_management.AboutUs;
import com.example.attendance_management.Faculty.Modal.FacultyStatisticsList;
import com.example.attendance_management.LoginActivity;
import com.example.attendance_management.R;
import com.example.attendance_management.Settings;

import java.util.ArrayList;

public class AttendanceStatsActivity extends AppCompatActivity {
    Spinner spinner;
    ListView listView;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menuItem1){
            Toast.makeText(this, "Show profile", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.menuItem2){
            Intent fIntent = new Intent(AttendanceStatsActivity.this, AboutUs.class);
            AttendanceStatsActivity.this.startActivity(fIntent);
        }
        else if (id == R.id.menuItem2){
            AlertDialog.Builder builder = new AlertDialog.Builder(AttendanceStatsActivity.this);
            builder.setMessage("Are you sure you want to logout?");
            builder.setTitle("Alert!");
            builder.setCancelable(true);
            builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which )->{
                Intent fIntent = new Intent(AttendanceStatsActivity.this, LoginActivity.class);
                AttendanceStatsActivity.this.startActivity(fIntent);
            });
            builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which )->{
                dialog.cancel();
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            Toast.makeText(this, "Logged out!", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.menuItem4) {
            Intent fIntent = new Intent(AttendanceStatsActivity.this, Settings.class);
            AttendanceStatsActivity.this.startActivity(fIntent);

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
        setContentView(R.layout.activity_attendance_stats);
        spinner = findViewById(R.id.sf3);
        listView = findViewById(R.id.listView3);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("DAA");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        ArrayList<FacultyStatisticsList> facultyStatisticsList = new ArrayList<>();
        facultyStatisticsList.add(new FacultyStatisticsList("200953262", "Shwetabh", "16", "10", "6", "75%"));
        facultyStatisticsList.add(new FacultyStatisticsList("200953172", "Ankit", "16", "11", "5", "78.54%"));
        facultyStatisticsList.add(new FacultyStatisticsList("200953264", "Rohan", "16", "12", "4", "75%"));
        facultyStatisticsList.add(new FacultyStatisticsList("200953174", "Soham", "16", "12", "4", "78.54%"));
        facultyStatisticsList.add(new FacultyStatisticsList("200953265", "Tanvee", "16", "14", "2", "75%"));
        facultyStatisticsList.add(new FacultyStatisticsList("200953175", "Tinku", "16", "11", "5", "78.54%"));
        FacultyStatisticsAdapter facultyStatisticsAdapter = new FacultyStatisticsAdapter(this, R.layout.template_faculty_statistics, facultyStatisticsList);
        listView.setAdapter(facultyStatisticsAdapter);
    }
}