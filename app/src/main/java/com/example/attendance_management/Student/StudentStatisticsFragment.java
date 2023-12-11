package com.example.attendance_management.Student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;

import com.example.attendance_management.R;

import java.util.ArrayList;

public class StudentStatisticsFragment extends Fragment {
    ListView listView;
    ToggleButton toggleButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_student_statistics, container, false);
        listView = view.findViewById(R.id.listView2);
        toggleButton = view.findViewById(R.id.toggleButton);
        toggleButton.setVisibility(View.INVISIBLE);
        ArrayList<StudentStatisticsList> studentStatisticsList = new ArrayList<>();
        //studentStatisticsList.add(new StudentStatisticsList("Class", "Total Class", "Days Present", "Days Absent", "Attendance %"));
        studentStatisticsList.add(new StudentStatisticsList("DAA", "10", "5", "5", "50 %"));
        studentStatisticsList.add(new StudentStatisticsList("IOS", "4", "3", "1", "75 %"));
        StudentStatisticsAdapter studentStatisticsAdapter = new StudentStatisticsAdapter(this.requireActivity(), R.layout.template_student_statistics, studentStatisticsList);
        listView.setAdapter(studentStatisticsAdapter);
        return view;
    }
}