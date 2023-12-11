package project.attendease;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentTimetableAdapter extends ArrayAdapter<StudentTimetableList> {
    private Context mContext;
    int mResource;
    public StudentTimetableAdapter(@NonNull Context context, int resource, @NonNull List<StudentTimetableList> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String slot = getItem(position).getSlot();
        String type = getItem(position).getType();
        String cName = getItem(position).getcName();
        String department = getItem(position).getDepartment();

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView =layoutInflater.inflate(mResource, parent, false);

        TextView textView6 = convertView.findViewById(R.id.textView6);
        TextView textView7 = convertView.findViewById(R.id.textView7);
        TextView textView8 = convertView.findViewById(R.id.textView8);
        TextView textView9 = convertView.findViewById(R.id.textView9);

        textView6.setText(slot);
        textView7.setText(type);
        textView8.setText(cName);
        textView9.setText(department);

        return convertView;
    }
}
