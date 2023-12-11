package com.example.attendance_management.Faculty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.attendance_management.R;

import java.util.List;

public class FacultyTimetableAdapter extends ArrayAdapter<FacultyTimetableList> {
    Context mContext;
    int mResource;
    public FacultyTimetableAdapter(@NonNull Context context, int resource, @NonNull List<FacultyTimetableList> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String slot = getItem(position).getCourse_name();
        String type = ""+getItem(position).getSlot_type();
        String cName = getItem(position).getSlot_time();

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);

        TextView textViewf1 = convertView.findViewById(R.id.textViewf1);
        TextView textViewf2 = convertView.findViewById(R.id.textViewf6);
        TextView textViewf3 = convertView.findViewById(R.id.textViewf3);

        textViewf1.setText(slot);
        textViewf2.setText(type);
        textViewf3.setText(cName);

        return convertView;
    }
}
