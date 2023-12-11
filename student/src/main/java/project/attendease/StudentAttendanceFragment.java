package project.attendease;

import static android.widget.Toast.LENGTH_SHORT;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentAttendanceFragment extends Fragment {
    ListView listView;
    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_student_attendance, container, false);
        listView = view.findViewById(R.id.listView1);
        button = view.findViewById(R.id.attendance);
        ArrayList<StudentTimetableList> studentTimetableList = new ArrayList<>();
        studentTimetableList.add(new StudentTimetableList("Slot", "Type", "Class", "Department"));
        StudentTimetableAdapter studentTimetableAdapter = new StudentTimetableAdapter(this.requireActivity(), R.layout.template_student_timetable, studentTimetableList);
        listView.setAdapter(studentTimetableAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Attended", LENGTH_SHORT).show();
            }
        });
        return view;
    }
}