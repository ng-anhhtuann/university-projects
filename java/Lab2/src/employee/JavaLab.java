package employee;

import java.util.Scanner;

public class JavaLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập thông tin cho Student
        System.out.println("Nhập thông tin Student:");
        System.out.print("Tên: ");
        String studentName = scanner.nextLine();
        System.out.print("ID (7 ký tự số): ");
        String studentId = scanner.nextLine();
        System.out.print("Giới tính (Female hoặc Male): ");
        String studentSex = scanner.nextLine();
        System.out.print("Quốc gia: ");
        String studentNation = scanner.nextLine();
        System.out.print("Mã sinh viên: ");
        String studentIdNumber = scanner.nextLine();

        // Kiểm tra ràng buộc cho ID
        if (!studentIdNumber.matches(".*[0-9].*")) {
            System.out.println("Lỗi: Student Invalid StudentID");
            return;
        }
        
        // Kiểm tra ràng buộc cho ID
        if (studentId.length() != 7 || !studentId.matches(".*[0-9].*")) {
            System.out.println("Lỗi: Student Invalid CitizenID");
            return;
        }

        // Kiểm tra ràng buộc cho giới tính
        if (!studentSex.equalsIgnoreCase("Female") && !studentSex.equalsIgnoreCase("Male")) {
            System.out.println("Lỗi: Student Giới tính phải là Female hoặc Male");
            return;
        }

        System.out.print("Số lượng môn học (1-5): ");
        int numberOfSubjects = Integer.parseInt(scanner.nextLine());

        // Kiểm tra ràng buộc cho số lượng môn học
        if (numberOfSubjects < 1 || numberOfSubjects > 5) {
            System.out.println("Lỗi: Student Invalid number of subjects");
            return;
        }

        double gpa = 0;
        
        Subject[] subjects = new Subject[numberOfSubjects];
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Tên môn học #" + (i + 1) + ": ");
            String subjectName = scanner.nextLine();
            System.out.print("Điểm môn học #" + (i + 1) + " (0-10): ");
            double subjectMark = Double.parseDouble(scanner.nextLine());

            // Kiểm tra ràng buộc cho điểm môn học
            if (subjectMark < 0 || subjectMark > 10) {
                System.out.println("Lỗi: Student Invalid mark of subject");
                return;
            }

            subjects[i] = new Subject(subjectName, subjectMark);
            gpa += subjectMark;
        }
        gpa /= numberOfSubjects;

        Student student = new Student(studentName, Integer.parseInt(studentId), studentSex, studentNation, Integer.parseInt(studentIdNumber), subjects);
        
        // Nhập thông tin cho Employee
        System.out.println("Nhập thông tin Employee:");
        System.out.print("Tên: ");
        String employeeName = scanner.nextLine();
        System.out.print("ID (7 ký tự số): ");
        String employeeId = scanner.nextLine();
        System.out.print("Giới tính (Female hoặc Male): ");
        String employeeSex = scanner.nextLine();
        System.out.print("Quốc gia: ");
        String employeeNation = scanner.nextLine();
        System.out.print("Lương cơ bản: ");
        double baseSalary = Double.parseDouble(scanner.nextLine());
        System.out.print("Số giờ làm thêm: ");
        int overtimeHours = Integer.parseInt(scanner.nextLine());

        // Kiểm tra ràng buộc cho ID
        if (employeeId.length() != 7 || !employeeId.matches(".*[0-9].*")) {
            System.out.println("Lỗi: Employee Invalid CitizenID");
            return;
        }

        // Kiểm tra ràng buộc cho giới tính
        if (!employeeSex.equalsIgnoreCase("Female") && !employeeSex.equalsIgnoreCase("Male")) {
            System.out.println("Lỗi: Employee Giới tính phải là Female hoặc Male");
            return;
        }

        // Kiểm tra ràng buộc cho lương cơ bản
        if (baseSalary < 1000) {
            System.out.println("Lỗi: Employee Lương cơ bản tối thiểu là 1000");
            return;
        }

        // Tính totalSalary cho Employee
        double totalSalary = baseSalary + (baseSalary / 160 * 2 * overtimeHours);

        Employee employee = new Employee(employeeName, Integer.parseInt(employeeId), employeeSex, employeeNation, baseSalary, overtimeHours);
        
        // Xuất thông tin
        System.out.println("\nThông tin Student:");
        System.out.println("Tên: " + student.getName());
        System.out.println("ID: " + student.getId());
        System.out.println("Giới tính: " + student.isSex());
        System.out.println("Quốc gia: " + student.getNation());
        System.out.println("Mã sinh viên: " + student.getStudentId());
        System.out.println("Môn học:");
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.println("  " + subjects[i].getNameOfSubject() + ": " + subjects[i].getMarkOfSubject());
        }
        System.out.println("GPA : " + gpa);

        System.out.println("\nThông tin Employee:");
        System.out.println("Tên: " + employee.getName());
        System.out.println("ID: " + employee.getId());
        System.out.println("Giới tính: " + employee.isSex());
        System.out.println("Quốc gia: " + employee.getNation());
        System.out.printf("Lương cơ bản: %.2f%n", employee.getSalary());
        System.out.println("Số giờ làm thêm: " + employee.getOverTimeHour());
        System.out.printf("Total Salary: %.2f%n", totalSalary);

        scanner.close();
    }
}
