package com.example.attendance_management.Student;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.attendance_management.AboutUs;
import com.example.attendance_management.HelpPage;
import com.example.attendance_management.LoginActivity;
import com.example.attendance_management.R;
import com.example.attendance_management.Settings;
import com.google.android.material.tabs.TabLayout;

public class StudentMain extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    StudentViewPagerAdapter studentViewPagerAdapter;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);
        email=getIntent().getStringExtra("email");
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);
        studentViewPagerAdapter = new StudentViewPagerAdapter(this);
        viewPager2.setAdapter(studentViewPagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                
                viewPager2.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menuItem1){
            Toast.makeText(this, "Show profile", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.menuItem2){
            Intent fIntent = new Intent(StudentMain.this, AboutUs.class);
            StudentMain.this.startActivity(fIntent);
        }
        else if (id == R.id.menuItem4){
            Intent fIntent = new Intent(StudentMain.this, Settings.class);
            StudentMain.this.startActivity(fIntent);
        }
        else if (id == R.id.menuItem5){
            Intent fIntent = new Intent(StudentMain.this, HelpPage.class);
            StudentMain.this.startActivity(fIntent);
        }
        else if (id == R.id.menuItem6){
            Intent fIntent = new Intent(StudentMain.this, Settings.class);
            StudentMain.this.startActivity(fIntent);
        }
        else if (id == R.id.menuItem3){
            Dialog dialog = new Dialog(StudentMain.this);
            dialog.setContentView(R.layout.alertdialogbox);
            TextView title_text = dialog.findViewById(R.id.textViewA);
            title_text.setText("Are you sure want to exit?");
            title_text.setBackgroundColor(Color.GREEN);
            TextView whitespace_text = dialog.findViewById(R.id.textViewA2);
            whitespace_text.setText("Press 'Yes' to exit, 'No' to stay");
            Button b1 = dialog.findViewById(R.id.buttonA1);
            b1.setText("Yes");
            Button b2 = dialog.findViewById(R.id.buttonA2);
            b2.setText("No");
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                    Toast.makeText(StudentMain.this, "Logging out...", Toast.LENGTH_SHORT).show();
                    Intent fIntent = new Intent(StudentMain.this, LoginActivity.class);
                    startActivity(fIntent);
                    finish();
                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();
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
    public void onBackPressed(){
        Dialog dialog = new Dialog(StudentMain.this);
        dialog.setContentView(R.layout.alertdialogbox);
        TextView title_text = dialog.findViewById(R.id.textViewA);
        title_text.setText("Are you sure want to exit?");
        title_text.setBackgroundColor(Color.GREEN);
        TextView whitespace_text = dialog.findViewById(R.id.textViewA2);
        whitespace_text.setText("Press 'Yes' to exit, 'No' to stay");
        Button b1 = dialog.findViewById(R.id.buttonA1);
        b1.setText("Yes");
        Button b2 = dialog.findViewById(R.id.buttonA2);
        b2.setText("No");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(StudentMain.this, "Logging out...", Toast.LENGTH_SHORT).show();
                Intent fIntent = new Intent(StudentMain.this, LoginActivity.class);
                startActivity(fIntent);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}