package com.example.attendance_management.Student;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.attendance_management.ApiInterface;
import com.example.attendance_management.R;
import com.example.attendance_management.RetrofitInstance;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentTimetableFragment extends Fragment {

    Spinner spinner;
    String email;
    private ApiInterface apiInterface;
    ListView listView;
    String[] days= {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_student_timetable, container, false);
        apiInterface= RetrofitInstance.getRetrofit().create(ApiInterface.class);
        spinner = view.findViewById(R.id.spinner3);

        listView = view.findViewById(R.id.listView1);
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.addAll(Arrays.asList(days));
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, stringArrayList);


        stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(stringArrayAdapter);

        ArrayList<StudentTimetableList> studentTimetableList = new ArrayList<>();
//        StudentTimetableList row1 = new StudentTimetableList("8:00AM", "Theory", "DAA", "ICT");
//        studentTimetableList.add(row1);
//        StudentTimetableList row2 = new StudentTimetableList("1:30PM", "LAB", "DBS", "ICT");
//        studentTimetableList.add(row2);

        StudentTimetableAdapter studentTimetableAdapter = new StudentTimetableAdapter(this.requireActivity(), R.layout.template_student_timetable, studentTimetableList);
        listView.setAdapter(studentTimetableAdapter);
        studentTimetableAdapter.notifyDataSetChanged();

//        StudentTimetableList row = new StudentTimetableList("Slot", "Type", "Class", "Department");
//        studentTimetableList.add(row);

       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               if(spinner.getSelectedItem()=="Monday"||spinner.getSelectedItem()=="Wednesday"||spinner.getSelectedItem()=="Friday"){
                   studentTimetableList.clear();
                   StudentTimetableList row1 = new StudentTimetableList("8:00AM", "CRA", "HCI", "ICT");
                   studentTimetableList.add(row1);
                   StudentTimetableList row3 = new StudentTimetableList("9:00AM", "CRA", "PE4", "ICT");
                   studentTimetableList.add(row3);
                   StudentTimetableList row4 = new StudentTimetableList("8:00AM", "CRA", "OE", "ICT");
                   studentTimetableList.add(row4);
                   StudentTimetableList row2 = new StudentTimetableList("2:30PM", "LAB", "DBS", "ICT");
                   studentTimetableList.add(row2);
                   studentTimetableAdapter.notifyDataSetChanged();


               }
               else{
                   studentTimetableList.clear();
                   StudentTimetableList row2 = new StudentTimetableList("9:00AM", "LAB", "NPS", "ICT");
                   studentTimetableList.add(row2);
                   StudentTimetableList row1 = new StudentTimetableList("1:00PM", "CRA", "PE5", "ICT");
                   studentTimetableList.add(row1);
                   StudentTimetableList row3 = new StudentTimetableList("2:00PM", "CRA", "PE6", "ICT");
                   studentTimetableList.add(row3);
                   StudentTimetableList row4 = new StudentTimetableList("3:30PM", "CRA", "PE3", "ICT");
                   studentTimetableList.add(row4);

                   studentTimetableAdapter.notifyDataSetChanged();

               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });

//        AttendanceModalRequest attendanceModalRequest=new AttendanceModalRequest("200953172","Monday");
//        Call<List<StudentTimetableList>> call= apiInterface.getSlots(attendanceModalRequest);
//        StudentTimetableAdapter studentTimetableAdapter = new StudentTimetableAdapter(this.requireActivity(), R.layout.template_student_timetable, studentTimetableList);
//        listView.setAdapter(studentTimetableAdapter);
//        call.enqueue(new Callback <List<StudentTimetableList>>() {
//            @Override
//            public void onResponse(Call<List<StudentTimetableList>> call, Response<List<StudentTimetableList>> response) {
//                List<StudentTimetableList> list=new ArrayList<>();
//                list=response.body();
//                for(int i=0;i<list.size();i++){
//                    StudentTimetableList row=new StudentTimetableList(list.get(i).getSlot_time(),""+list.get(i).getSlot_type(),list.get(i).getCourse_name(),list.get(i).getDepartment());
//                    studentTimetableList.add(row);
//                    studentTimetableAdapter.notifyDataSetChanged();
//                    //Log.d("Element",studentTimetableList.get(i+1).getCourse_name().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<StudentTimetableList>> call, Throwable t) {
//                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//
//
//        });





        return view;
    }
}