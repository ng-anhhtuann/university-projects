public class Employee {
    private String name;
    private String staffId;
    private int age;

    public Employee() {}
    
    public Employee(String name, String staffId, int age) {
        this.name = name;
        this.staffId = staffId;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
