package project.attendease;

public class StudentTimetableList {
    private String slot, type, cName, department;

    public StudentTimetableList(String slot, String type, String cName, String department) {
        this.slot = slot;
        this.type = type;
        this.cName = cName;
        this.department = department;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
