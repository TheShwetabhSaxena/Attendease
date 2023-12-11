package project.attendease;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentStatisticsAdapter extends ArrayAdapter<StudentStatisticsList> {
    Context mContext;
    int mResource;
    public StudentStatisticsAdapter(@NonNull Context context, int resource, @NonNull List<StudentStatisticsList> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String cName = getItem(position).getcName();
        String totalClass = getItem(position).getTotalClass();
        String daysPresent = getItem(position).getDaysPresent();
        String daysAbsent = getItem(position).getDaysAbsent();
        String attendance = getItem(position).getAttendance();

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);

        TextView textView5 = convertView.findViewById(R.id.textView5);
        TextView textView10 = convertView.findViewById(R.id.textView10);
        TextView textView11 = convertView.findViewById(R.id.textView11);
        TextView textView12 = convertView.findViewById(R.id.textView12);
        TextView textView13 = convertView.findViewById(R.id.textView13);

        textView5.setText(cName);
        textView10.setText(totalClass);
        textView11.setText(daysPresent);
        textView12.setText(daysAbsent);
        textView13.setText(attendance);

        return convertView;
    }
}
