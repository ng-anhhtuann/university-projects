package employee;

import java.util.Arrays;

public class Student extends Human {
    private int studentId;
    private Subject[] subjects;

    // Constructors
    public Student(String name, int id, String sex, String nation, int studentId, Subject[] subjects) {
        super(name, id, sex, nation);
        this.studentId = studentId;
        this.subjects = subjects;
    }

    public Student() {
        // No-args constructor
    }

    // Getter and Setter methods
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", id='" + getId() + '\'' +
                ", sex=" + isSex() +
                ", nation='" + getNation() + '\'' +
                ", studentId=" + studentId +
                ", subjects=" + Arrays.toString(subjects) +
                '}';
    }
}
