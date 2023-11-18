// Lớp trừu tượng Teacher
abstract class Teacher {
    private String name;
    private String email;
    private String address;
    private int hoursTaught;

    public Teacher(String name, String email, String address, int hoursTaught) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.hoursTaught = hoursTaught;
    }

    // Phương thức trừu tượng để tính lương hàng tháng
    public abstract double calculateMonthlySalary();

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getHoursTaught() {
        return hoursTaught;
    }
}

// Lớp con FullTimeTeacher kế thừa từ Teacher : cơ hữu
class FullTimeTeacher extends Teacher {
    private double baseSalary;
    private int standardHours;

    public FullTimeTeacher(String name, String email, String address, int hoursTaught, double baseSalary, int standardHours) {
        super(name, email, address, hoursTaught);
        this.baseSalary = baseSalary;
        this.standardHours = standardHours;
    }

    // Ghi đè phương thức để tính lương hàng tháng cho giảng viên cơ hữu
    @Override
    public double calculateMonthlySalary() {
        int extraHours = Math.max(getHoursTaught() - standardHours, 0);
        return baseSalary * getHoursTaught()  + (extraHours * 200000);
    }

    public int getStandardHours() {
        return standardHours;
    }
}

// Lớp con PartTimeTeacher kế thừa từ Teacher : thỉnh giảng
class PartTimeTeacher extends Teacher {
    private double hourlyRate;
    private String phoneNumber;
    private String workplace;

    public PartTimeTeacher(String name, String email, String address, int hoursTaught, double hourlyRate, String phoneNumber, String workplace) {
        super(name, email, address, hoursTaught);
        this.setHourlyRate(hourlyRate);
        this.phoneNumber = phoneNumber;
        this.workplace = workplace;
    }

    // Ghi đè phương thức để tính lương hàng tháng cho giảng viên thỉnh giảng
    @Override
    public double calculateMonthlySalary() {
        return getHoursTaught() * 20000;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWorkplace() {
        return workplace;
    }

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
}


