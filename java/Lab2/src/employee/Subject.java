package employee;

public class Subject {
    private String nameOfSubject;
    private double markOfSubject;

    // Constructors
    public Subject(String nameOfSubject, double markOfSubject) {
        this.nameOfSubject = nameOfSubject;
        this.markOfSubject = markOfSubject;
    }

    public Subject() {
        // No-args constructor
    }

    // Getter and Setter methods
    public String getNameOfSubject() {
        return nameOfSubject;
    }

    public void setNameOfSubject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }

    public double getMarkOfSubject() {
        return markOfSubject;
    }

    public void setMarkOfSubject(double markOfSubject) {
        this.markOfSubject = markOfSubject;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "nameOfSubject='" + nameOfSubject + '\'' +
                ", markOfSubject='" + markOfSubject + '\'' +
                '}';
    }
}

