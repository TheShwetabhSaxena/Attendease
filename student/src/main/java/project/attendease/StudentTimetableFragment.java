package project.attendease;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentTimetableFragment extends Fragment {
    Spinner spinner;
    ListView listView;
    String[] days= {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_student_timetable, container, false);
        spinner = view.findViewById(R.id.spinner);
        listView = view.findViewById(R.id.listView1);
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.addAll(Arrays.asList(days));
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, stringArrayList);
        stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(stringArrayAdapter);
        ArrayList<StudentTimetableList> studentTimetableList = new ArrayList<>();
        StudentTimetableList row1 = new StudentTimetableList("Slot", "Type", "Class", "Department");
        studentTimetableList.add(row1);
        StudentTimetableAdapter studentTimetableAdapter = new StudentTimetableAdapter(this.requireActivity(), R.layout.template_student_timetable, studentTimetableList);
        listView.setAdapter(studentTimetableAdapter);
        return view;
    }
}