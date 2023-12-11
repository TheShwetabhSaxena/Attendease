package com.example.attendance_management.Faculty.Modal;

public class FacultyStatisticsList {
    private String sID, sName, totalClass, daysPresent, daysAbsent, attendance;

    public FacultyStatisticsList(String sID, String sName, String totalClass, String daysPresent, String daysAbsent, String attendance) {
        this.sID = sID;
        this.sName = sName;
        this.totalClass = totalClass;
        this.daysPresent = daysPresent;
        this.daysAbsent = daysAbsent;
        this.attendance = attendance;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getTotalClass() {
        return totalClass;
    }

    public void setTotalClass(String totalClass) {
        this.totalClass = totalClass;
    }

    public String getDaysPresent() {
        return daysPresent;
    }

    public void setDaysPresent(String daysPresent) {
        this.daysPresent = daysPresent;
    }

    public String getDaysAbsent() {
        return daysAbsent;
    }

    public void setDaysAbsent(String daysAbsent) {
        this.daysAbsent = daysAbsent;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
}
