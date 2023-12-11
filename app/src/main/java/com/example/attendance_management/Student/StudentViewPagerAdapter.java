package com.example.attendance_management.Student;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class StudentViewPagerAdapter extends FragmentStateAdapter {
    public StudentViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new StudentTimetableFragment();
            case 1:
                return new StudentAttendanceFragment();
            case 2:
                return new StudentStatisticsFragment();
            default:
                return new StudentAttendanceFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}