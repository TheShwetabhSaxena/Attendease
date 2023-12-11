package com.example.attendance_management;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.attendance_management.Faculty.AttendanceShowActivity;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menuItem1){
            Toast.makeText(this, "Show profile", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.menuItem2){
            Intent fIntent = new Intent(AboutUs.this, AboutUs.class);
            AboutUs.this.startActivity(fIntent);
        }
        else if (id == R.id.menuItem2){
            AlertDialog.Builder builder = new AlertDialog.Builder(AboutUs.this);
            builder.setMessage("Are you sure you want to logout?");
            builder.setTitle("Alert!");
            builder.setCancelable(true);
            builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which )->{
                Intent fIntent = new Intent(AboutUs.this, LoginActivity.class);
                AboutUs.this.startActivity(fIntent);
                finish();
            });
            builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which )->{
                dialog.cancel();
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            Toast.makeText(this, "Logged out!", Toast.LENGTH_SHORT).show();
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
}