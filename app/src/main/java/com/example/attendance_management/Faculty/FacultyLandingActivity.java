package com.example.attendance_management.Faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.attendance_management.AboutUs;
import com.example.attendance_management.ApiInterface;
import com.example.attendance_management.ConnectionHelper;
import com.example.attendance_management.Faculty.Modal.AttendanceFacultyModalRequest;
import com.example.attendance_management.HelpPage;
import com.example.attendance_management.LoginActivity;
import com.example.attendance_management.R;
import com.example.attendance_management.RetrofitInstance;
import com.example.attendance_management.Settings;
import com.example.attendance_management.Student.StudentMain;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FacultyLandingActivity extends AppCompatActivity {
    ListView listView1, listView2;
    Button button, button1;
    private ConnectionHelper connectionHelper1,connectionHelper2;
    Connection connect1,connect2;


    private ApiInterface apiInterface;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menuItem1){
            Toast.makeText(this, "Show profile", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.menuItem2){
            Intent fIntent = new Intent(FacultyLandingActivity.this, AboutUs.class);
            FacultyLandingActivity.this.startActivity(fIntent);
        }
        else if (id == R.id.menuItem4){
            Intent fIntent = new Intent(FacultyLandingActivity.this, Settings.class);
            FacultyLandingActivity.this.startActivity(fIntent);
        }
        else if (id == R.id.menuItem5){
            Intent fIntent = new Intent(FacultyLandingActivity.this, HelpPage.class);
            FacultyLandingActivity.this.startActivity(fIntent);
        }
        else if (id == R.id.menuItem6){
            Intent fIntent = new Intent(FacultyLandingActivity.this, Settings.class);
            FacultyLandingActivity.this.startActivity(fIntent);
        }
        else if (id == R.id.menuItem3){
            Dialog dialog = new Dialog(FacultyLandingActivity.this);
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
                    Toast.makeText(FacultyLandingActivity.this, "Logging out...", Toast.LENGTH_SHORT).show();
                    Intent fIntent = new Intent(FacultyLandingActivity.this, LoginActivity.class);
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_landing);
        apiInterface= RetrofitInstance.getRetrofit().create(ApiInterface.class);
        listView1 = findViewById(R.id.listViewf1);
        listView2 = findViewById(R.id.listViewf2);
        String email=getIntent().getStringExtra("email");
        //Connection connection=createConnection();
        button = findViewById(R.id.button3);
        button1 = findViewById(R.id.button2);
        ArrayList<FacultyTimetableList> facultyTimetableList = new ArrayList<>();
        if(email.equals("faculty")){
            facultyTimetableList.add(new FacultyTimetableList("8:30 AM", "LAB","DAA"));
            facultyTimetableList.add(new FacultyTimetableList("1:00 PM", "Theory","DBS"));
        }
        else if(email.equals("vibha@manipal.edu")){
            facultyTimetableList.add(new FacultyTimetableList("9:30 AM", "Theory","DMPA"));
            facultyTimetableList.add(new FacultyTimetableList("2:00 PM", "Lab","ES"));
        }
        FacultyTimetableAdapter facultyTimetableAdapter = new FacultyTimetableAdapter(this, R.layout.template_faculty_landing, facultyTimetableList);
        listView1.setAdapter(facultyTimetableAdapter);

//        try{
//            connectionHelper1=new ConnectionHelper();
//            connect1=connectionHelper1.connectionClass();
//            if(connect1!=null){
//                String query="SELECT slots.slot_time, slots.slot_type, course.course_name FROM faculty JOIN instructor ON instructor.inst_id = faculty.p_id JOIN course ON instructor.inst_code = course.course_code JOIN timetable  ON timetable.tt_code = course.course_code JOIN slots  ON timetable.tt_id = slots.slot_id WHERE slots.slot_day = Monday AND faculty.p_id = 67891234";
//                Statement statement=connect1.createStatement();
//                ResultSet st=statement.executeQuery(query);
//                while ((st.next())){
//                    facultyTimetableList.add(new FacultyTimetableList(st.getString(1),st.getFloat(2),st.getString(3)));
//                    facultyTimetableAdapter.notifyDataSetChanged();
//                }
//                connect1.close();
//
//
//            }
//        }catch (Exception ex){
//
//
//        }


        //facultyTimetableList1.add(new FacultyTimetableList("Lab", "ICT", "DAA"));
        //facultyTimetableList1.add(new FacultyTimetableList("Theory", "ICT", "DBS"));


//        AttendanceFacultyModalRequest attendanceModalRequest=new AttendanceFacultyModalRequest("67891234","Monday");
//        Call<List<FacultyTimetableList>> call= apiInterface.getFacultySlots(attendanceModalRequest);
//
//
//       call.enqueue(new Callback<List<FacultyTimetableList>>() {
//           @Override
//           public void onResponse(Call<List<FacultyTimetableList>> call, Response<List<FacultyTimetableList>> response) {
//               if (response.isSuccessful() && response.body() != null) {
//                   List<FacultyTimetableList> list = response.body();
//                   for (int i = 0; i < list.size(); i++) {
//                       FacultyTimetableList row = new FacultyTimetableList(list.get(i).getCourse_name(), list.get(i).getSlot_type(), list.get(i).getCourse_name());
//                       facultyTimetableList.add(row);
//                       Log.d("ITEM",list.get(i).getCourse_name());
//                       facultyTimetableAdapter.notifyDataSetChanged();
//                   }
//               } else {
//                   Toast.makeText(FacultyLandingActivity.this, "Error: " + response.message(), Toast.LENGTH_SHORT).show();
//               }
//           }
//
//           @Override
//           public void onFailure(Call<List<FacultyTimetableList>> call, Throwable t) {
//               Toast.makeText(FacultyLandingActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//
//           }
//       });
//
//        if(connection!=null){
//            try{
//                Statement statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery("SELECT slots.slot_time, slots.slot_type, course.course_name FROM faculty JOIN instructor ON instructor.inst_id = faculty.p_id JOIN course ON instructor.inst_code = course.course_code JOIN timetable  ON timetable.tt_code = course.course_code JOIN slots  ON timetable.tt_id = slots.slot_id WHERE slots.slot_day = ? AND faculty.p_id =67891234;");
//                ArrayList<String> data = new ArrayList<>();
//                while (resultSet.next()) {
//                    String item = resultSet.getString("column_name");
//                    data.add(item);
//                }
//
//                resultSet.close();
//                statement.close();
//                connection.close();
//
//                // Step 5: Set up an adapter for the ListView
//
//
//                // Step 6: Bind the adapter to the ListView
//                ListView listView = findViewById(R.id.listView);
//                listView.setAdapter(adapter);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            }
//        }




        ArrayList<FacultyTimetableList> facultyTimetableList1 = new ArrayList<>();
        if(email.equals("faculty")){
            facultyTimetableList1.add(new FacultyTimetableList("Theory", "IOS","CSE"));
            facultyTimetableList1.add(new FacultyTimetableList("Theory", "DBS","ICT"));
            facultyTimetableList1.add(new FacultyTimetableList("LAB", "DAA","ICT"));
            facultyTimetableList1.add(new FacultyTimetableList("Theory", "WCC","ICT"));
        } else if (email.equals("vibha@manipal.edu")) {
            facultyTimetableList1.add(new FacultyTimetableList("Theory", "DMPA","CSE"));
            facultyTimetableList1.add(new FacultyTimetableList("Theory", "NS","CSE"));

            facultyTimetableList1.add(new FacultyTimetableList("LAB", "ES","ICT"));


        }
        FacultyTimetableAdapter facultyTimetableAdapter1 = new FacultyTimetableAdapter(this, R.layout.template_faculty_landing, facultyTimetableList1);


        listView2.setAdapter(facultyTimetableAdapter1);
//
//        try{
//            connectionHelper2=new ConnectionHelper();
//            connect2=connectionHelper2.connectionClass();
//            if(connect2!=null){
//                String query="SELECT slots.slot_time, slots.slot_type, course.course_name FROM faculty JOIN instructor ON instructor.inst_id = faculty.p_id JOIN course ON instructor.inst_code = course.course_code JOIN timetable  ON timetable.tt_code = course.course_code JOIN slots  ON timetable.tt_id = slots.slot_id WHERE faculty.p_id = 67891234";
//                Statement statement2=connect2.createStatement();
//                ResultSet st2=statement2.executeQuery(query);
//                while ((st2.next())){
//                    facultyTimetableList1.add(new FacultyTimetableList(st2.getString(1),st2.getFloat(2),st2.getString(3)));
//                    facultyTimetableAdapter1.notifyDataSetChanged();
//                }
//
//
//            }
//        }catch (Exception ex){
//
//
//        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fIntent = new Intent(FacultyLandingActivity.this, CreateAttendanceActivity.class);
                fIntent.putExtra("email",email);
                FacultyLandingActivity.this.startActivity(fIntent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fIntent = new Intent(FacultyLandingActivity.this, AttendanceStatsActivity.class);
                FacultyLandingActivity.this.startActivity(fIntent);
            }
        });
    }
    public void onBackPressed(){
        Dialog dialog = new Dialog(FacultyLandingActivity.this);
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
                Toast.makeText(FacultyLandingActivity.this, "Logging out...", Toast.LENGTH_SHORT).show();
                Intent fIntent = new Intent(FacultyLandingActivity.this, LoginActivity.class);
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