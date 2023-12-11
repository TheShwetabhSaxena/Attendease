package com.example.attendance_management.Student;

public class StudentStatisticsList {
    private String cName, totalClass, daysPresent, daysAbsent, attendance;

    public StudentStatisticsList(String cName, String totalClass, String daysPresent, String daysAbsent, String attendance) {
        this.cName = cName;
        this.totalClass = totalClass;
        this.daysPresent = daysPresent;
        this.daysAbsent = daysAbsent;
        this.attendance = attendance;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
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
