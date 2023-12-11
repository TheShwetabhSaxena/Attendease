package com.example.attendance_management.Student;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import com.example.attendance_management.LoginActivity;
import com.example.attendance_management.R;

public class LogAttendance extends AppCompatActivity {
    Button button;
    EditText editText;
    int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_attendance);
        button = findViewById(R.id.loginButton);
        editText = findViewById(R.id.editTextText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().toString().equals("2317") || editText.getText().toString().equals("6435")){

                    Dialog dialog = new Dialog(LogAttendance.this);
                    dialog.setContentView(R.layout.alertdialogbox);
                    TextView title_text = dialog.findViewById(R.id.textViewA);
                    title_text.setText("Confirm logging attendance!");
                    title_text.setBackgroundColor(Color.GREEN);
                    TextView whitespace_text = dialog.findViewById(R.id.textViewA2);
                    whitespace_text.setText("Are you sure you want to log attendance?");
                    Button b1 = dialog.findViewById(R.id.buttonA1);
                    b1.setText("Yes");
                    Button b2 = dialog.findViewById(R.id.buttonA2);
                    b2.setText("No");
                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            flag = 1;
                        }
                    });
                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                    if(flag==1){
                        Toast.makeText(LogAttendance.this, "Attendance logged", Toast.LENGTH_SHORT).show();
                        Intent fIntent = new Intent(LogAttendance.this, StudentMain.class);
                        startActivity(fIntent);
                        finish();
                    }

                }
                else{
                    Dialog dialog = new Dialog(LogAttendance.this);
                    dialog.setContentView(R.layout.alertdialogbox);
                    TextView title_text = dialog.findViewById(R.id.textViewA);
                    title_text.setText("Wrong attendance code!");
                    title_text.setBackgroundColor(Color.GREEN);
                    TextView whitespace_text = dialog.findViewById(R.id.textViewA2);
                    whitespace_text.setText("Please confirm the correct code or verify if you are connected to the internet!");
                    Button b1 = dialog.findViewById(R.id.buttonA1);
                    b1.setText("Yes I have a valid code");
                    Button b2 = dialog.findViewById(R.id.buttonA2);
                    b2.setText("I want to exit");
                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            Toast.makeText(LogAttendance.this, "Enter the code again or check internet connection!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            Toast.makeText(LogAttendance.this, "Exiting attendance page...", Toast.LENGTH_SHORT).show();
                            Intent fIntent = new Intent(LogAttendance.this, StudentMain.class);
                            startActivity(fIntent);
                            finish();
                        }
                    });
                    dialog.show();
                }
            }
        });
    }
}