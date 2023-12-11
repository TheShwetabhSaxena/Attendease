package com.example.attendance_management;

import com.example.attendance_management.Faculty.FacultyTimetableList;
import com.example.attendance_management.Faculty.Modal.AttendanceFacultyModalRequest;
import com.example.attendance_management.Faculty.Modal.FacultyModal;
import com.example.attendance_management.Faculty.Modal.LoginFacultyModal;
import com.example.attendance_management.Student.AttendanceModalRequest;
import com.example.attendance_management.Student.StudentAttendanceModal;
import com.example.attendance_management.Student.StudentModal;
import com.example.attendance_management.Student.StudentTimetableList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {



    @POST("faculty/login")
    Call<FacultyModal> LoginFaculty(@Body LoginFacultyModal loginFacultyModal);



    @GET("faculty/getallfaculty")
    Call<List<FacultyModal>> getAllFaculty();

    @POST("student/login")
    Call<StudentModal> LoginStudent(@Body LoginFacultyModal loginFacultyModal);

    @POST("slots/statistic")
    Call<List<StudentTimetableList>> getSlots(@Body AttendanceModalRequest attendanceModalRequest);

    @POST("slots/statisticFaculty")
    Call<List<FacultyTimetableList>> getFacultySlots(@Body AttendanceFacultyModalRequest attendanceFacultyModalRequest);

    @POST("faculty/login")
    Call <List<AuthenticationModal>> checkAuthFaculty(@Body LoginFacultyModal loginFacultyModal);

}
