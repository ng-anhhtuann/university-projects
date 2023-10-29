package employee;
public class Employee extends Human {
    private double salary;
    private int overTimeHour;

    // Constructors
    public Employee(String name, int id, String sex, String nation, double salary, int overTimeHour) {
        super(name, id, sex, nation);
        this.salary = salary;
        this.overTimeHour = overTimeHour;
    }

    public Employee() {
        // No-args constructor
    }

    // Getter and Setter methods
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getOverTimeHour() {
        return overTimeHour;
    }

    public void setOverTimeHour(int overTimeHour) {
        this.overTimeHour = overTimeHour;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + '\'' +
                ", id='" + getId() + '\'' +
				", sex=" + isSex() +
                ", nation='" + getNation() + '\'' +
                ", salary=" + salary +
                ", overTimeHour=" + overTimeHour +
                '}';
    }
}

