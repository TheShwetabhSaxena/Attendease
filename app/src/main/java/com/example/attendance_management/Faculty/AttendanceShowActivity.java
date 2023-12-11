package com.example.attendance_management.Faculty;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.attendance_management.AboutUs;
import com.example.attendance_management.ConnectionHelper;
import com.example.attendance_management.LoginActivity;
import com.example.attendance_management.R;
import com.example.attendance_management.Settings;

import java.sql.Connection;

public class AttendanceShowActivity extends AppCompatActivity {
    Button button;
    Connection connect1;
    ConnectionHelper connectionHelper1;
    TextView code;
    private int num;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_show);
        num= (int) Math.random();

        button = findViewById(R.id.button);
        code=findViewById(R.id.code);


//        try{
//            connectionHelper1=new ConnectionHelper();
//            connect1=connectionHelper1.connectionClass();
//            if(connect1!=null){
//                String query="Select qr From attendance " + "Order By qr Desc " + "LIMIT 1";
//                Statement statement=connect1.createStatement();
//                ResultSet st=statement.executeQuery(query);
//                //st.next();
//
//                    Log.d("CODE",""+st.getInt(0));
//                    code.setText(st.getString(0));
//                    code.setText("Sample");
//
//
//
//
//            }
//        }catch (Exception e){
//            code.setText("Sample");
//
//        }
        if(num%2==0) {
            code.setText("2317");
        }
        else code.setText("6435");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fIntent = new Intent(AttendanceShowActivity.this, FacultyLandingActivity.class);

                fIntent.putExtra("email","divya@manipal.edu");
                AttendanceShowActivity.this.startActivity(fIntent);
                finish();



            }
        });
    }
}