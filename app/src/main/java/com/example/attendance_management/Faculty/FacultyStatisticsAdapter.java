package com.example.attendance_management.Faculty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.attendance_management.Faculty.Modal.FacultyStatisticsList;
import com.example.attendance_management.R;

import java.util.List;

public class FacultyStatisticsAdapter extends ArrayAdapter<FacultyStatisticsList> {
    Context mContext;
    int mResource;
    public FacultyStatisticsAdapter(@NonNull Context context, int resource, @NonNull List<FacultyStatisticsList> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String sID = getItem(position).getsID();
        String sName = getItem(position).getsName();
        String totalClass = getItem(position).getTotalClass();
        String daysPresent = getItem(position).getDaysPresent();
        String daysAbsent = getItem(position).getDaysAbsent();
        String attendance = getItem(position).getAttendance();

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);

        TextView textView30 = convertView.findViewById(R.id.textView30);
        TextView textView31 = convertView.findViewById(R.id.textView31);
        TextView textView32 = convertView.findViewById(R.id.textView32);
        TextView textView33 = convertView.findViewById(R.id.textView33);
        TextView textView34 = convertView.findViewById(R.id.textView34);
        TextView textView35 = convertView.findViewById(R.id.textView35);

        textView30.setText(sID);
        textView31.setText(sName);
        textView32.setText(totalClass);
        textView33.setText(daysPresent);
        textView34.setText(daysAbsent);
        textView35.setText(attendance);

        return convertView;
    }
}
