public class Engineer extends Employee {
    private int WorkHoursPerDay;
    private int OverTimeHoursPerDay;

    public Engineer(String name, String staffId, int age, int workHoursPerDay, int overTimeHoursPerDay) {
        super(name, staffId, age);
        this.WorkHoursPerDay = workHoursPerDay;
        this.OverTimeHoursPerDay = overTimeHoursPerDay;
    }

    public int getWorkHoursPerDay() {
        return WorkHoursPerDay;
    }

    public void setWorkHoursPerDay(int workHoursPerDay) {
        WorkHoursPerDay = workHoursPerDay;
    }

    public int getOverTimeHoursPerDay() {
        return OverTimeHoursPerDay;
    }

    public void setOverTimeHoursPerDay(int overTimeHoursPerDay) {
        OverTimeHoursPerDay = overTimeHoursPerDay;
    }
}
