import java.util.Scanner;

public class JavaLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input Engineer information
        System.out.println("Enter Engineer Information:");
        System.out.print("Name: ");
        String engineerName = scanner.nextLine();
        System.out.print("Staff ID: ");
        String engineerStaffId = scanner.nextLine();
        System.out.print("Age: ");
        int engineerAge = Integer.parseInt(scanner.nextLine());
        System.out.print("Work Hours Per Day: ");
        int workHoursPerDay = Integer.parseInt(scanner.nextLine());
        System.out.print("Overtime Hours: ");
        int overtimeHours = Integer.parseInt(scanner.nextLine());

        // Input Sales information
        System.out.println("Enter Sales Information:");
        System.out.print("Name: ");
        String salesName = scanner.nextLine();
        System.out.print("Staff ID: ");
        String salesStaffId = scanner.nextLine();
        System.out.print("Age: ");
        int salesAge = Integer.parseInt(scanner.next());
        System.out.print("Number of Products Sold: ");
        int numberOfProducts = Integer.parseInt(scanner.nextLine());
        System.out.print("Price per Product: ");
        int pricePerProduct = Integer.parseInt(scanner.nextLine());
        System.out.print("Interest (as a percentage): ");
        double interest = Double.parseDouble(scanner.nextLine());

        // Close the scanner
        scanner.close();

        // Engineer Salary Calculation
        double baseSalary = 1000; // Set the base salary as an example
        double salaryPerHour = (baseSalary / 4) / (5 * workHoursPerDay);
        double weeklySalary = baseSalary / 4;
        double dailySalary = baseSalary / 20; // 5 workdays in a week
        double overtimeSalary = overtimeHours * salaryPerHour * 2;
        double engineerSalary = baseSalary + overtimeSalary;

        // Sales Salary Calculation
        double salesSalary = baseSalary + (numberOfProducts * pricePerProduct * (interest / 100));

        // Output Engineer Information
        System.out.println("Engineer Information:");
        System.out.println("Engineer Name: " + engineerName);
        System.out.println("Staff ID: " + engineerStaffId);
        System.out.println("Age: " + engineerAge);
        System.out.println("Salary: " + String.format("%.2f", engineerSalary));
        System.out.println("Weekly Salary: " + String.format("%.2f", weeklySalary));
        System.out.println("Work Hours Per Day: " + workHoursPerDay);
        System.out.println("Salary per Hour: " + String.format("%.2f", salaryPerHour));

        // Output Sales Information
        System.out.println("Sales Information:");
        System.out.println("Sales Name: " + salesName);
        System.out.println("Staff ID: " + salesStaffId);
        System.out.println("Age: " + salesAge);
        System.out.println("Salary: " + String.format("%.2f", salesSalary));
    }
}

