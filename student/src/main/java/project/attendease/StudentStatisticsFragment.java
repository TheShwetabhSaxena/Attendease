package project.attendease;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class StudentStatisticsFragment extends Fragment {
    ListView listView;
    ToggleButton toggleButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_student_statistics, container, false);
        listView = view.findViewById(R.id.listView2);
        toggleButton = view.findViewById(R.id.toggleButton);
        ArrayList<StudentStatisticsList> studentStatisticsList = new ArrayList<>();
        studentStatisticsList.add(new StudentStatisticsList("Class", "Total Class", "Days Present", "Days Absent", "Attendance %"));
        StudentStatisticsAdapter studentStatisticsAdapter = new StudentStatisticsAdapter(this.requireActivity(), R.layout.template_student_statistics, studentStatisticsList);
        listView.setAdapter(studentStatisticsAdapter);
        return view;
    }
}