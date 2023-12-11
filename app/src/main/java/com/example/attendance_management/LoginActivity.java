package com.example.attendance_management;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.attendance_management.Faculty.FacultyLandingActivity;
import com.example.attendance_management.Faculty.Modal.FacultyModal;
import com.example.attendance_management.Student.StudentMain;
import com.example.attendance_management.Student.StudentModal;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button loginButton;
    private ApiInterface apiInterface;
    private ProgressBar loadingPB;
    private ArrayList<StudentModal> studentList;
    private ArrayList<FacultyModal> facultyList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        loadingPB = findViewById(R.id.idLoadingPB);
        apiInterface=RetrofitInstance.getRetrofit().create(ApiInterface.class);
        studentList=new ArrayList<>();
        facultyList=new ArrayList<>();

        studentList.add(new StudentModal(200953214,"Ankit","ICT","CCE","2002/08/12",2,"ankit.mishra@learner.manipal.edu",0,"student1_123"));
        studentList.add( new StudentModal(200953262,"Shwetabh","CSE","CSE","2002/09/12",1,"shwetabh.saxena@learner.manipal.edu",0,"student2_123"));

        facultyList.add(new FacultyModal(12345678,"Divya Rao","ICT","CCE","1975/04/14","divya.rao@manipal.edu","faculty1_123"));
        facultyList.add(new FacultyModal(56782312,"Vibha Prabhu","ICT","IT","1975/03/14","vibha.prabhu@manipal.edu","faculty2_123"));




        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((username.getText().toString().equals("student"))&&(password.getText().toString().equals("student"))){
                    Intent i=new Intent(LoginActivity.this, StudentMain.class);
                    i.putExtra("email",username.getText().toString());
                    startActivity(i);
                    finish();
                } else if ((username.getText().toString().equals("faculty"))&&(password.getText().toString().equals("faculty"))) {
                    Intent i=new Intent(LoginActivity.this, FacultyLandingActivity.class);
                    i.putExtra("email",username.getText().toString());
                    startActivity(i);
                    finish();
                }
                else{
                    Dialog dialog = new Dialog(LoginActivity.this);
                    dialog.setContentView(R.layout.alertdialogbox);
                    TextView title_text = dialog.findViewById(R.id.textViewA);
                    title_text.setText("Login details error!");
                    title_text.setBackgroundColor(Color.RED);
                    TextView whitespace_text = dialog.findViewById(R.id.textViewA2);
                    whitespace_text.setText("Please enter correct details or exit the app!");
                    Button b1 = dialog.findViewById(R.id.buttonA1);
                    b1.setText("Okay");
                    Button b2 = dialog.findViewById(R.id.buttonA2);
                    b2.setText("Exit");
                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            Toast.makeText(LoginActivity.this, "Please enter correct details!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            Toast.makeText(LoginActivity.this, "Exit the app by pressing back button again!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    dialog.show();
                }


            }
        });


    }


    public void postData(String email,String pass){



    }
}