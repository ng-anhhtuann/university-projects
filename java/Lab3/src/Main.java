import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Teacher> teachers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Chọn một tùy chọn:");
            System.out.println("1. Nhập thông tin giáo viên");
            System.out.println("2. Xuất danh sách toàn bộ giáo viên");
            System.out.println("3. Tính tổng số tiền lương");
            System.out.println("4. Tìm giảng viên có tổng lương cao nhất");
            System.out.println("5. Thoát");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice == 1) {
                System.out.println("Loại giáo viên (1: Giảng viên cơ hữu(fulltime) , 2: Giảng viên thỉnh giảng( parttime) ): ");
                int teacherType = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Tên giáo viên: ");
                String name = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Địa chỉ: ");
                String address = scanner.nextLine();
                System.out.print("Số giờ giảng dạy trong tháng: ");
                int hoursTaught = scanner.nextInt();
                scanner.nextLine();

                if (teacherType == 1) {
                    System.out.print("Lương cơ bản: ");
                    double baseSalary = scanner.nextDouble();
                    scanner.nextLine();
    //                System.out.print("Số giờ quy định chung: ");
                    int standardHours = 40;
                    //scanner.nextLine();
                    teachers.add(new FullTimeTeacher(name, email, address, hoursTaught, baseSalary, standardHours));
                } else if (teacherType == 2) {
                    //System.out.print("Mức lương theo giờ: ");
                    //double hourlyRate = scanner.nextDouble();
                    //scanner.nextLine();
                    System.out.print("Số điện thoại: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Cơ quan làm việc: ");
                    String workplace = scanner.nextLine();
                    teachers.add(new PartTimeTeacher(name, email, address, hoursTaught, 20000, phoneNumber, workplace));
                }
                System.out.println("Thông tin giáo viên đã được thêm.");
            } else if (choice == 2) {
                System.out.println("Danh sách giáo viên:");
                for (Teacher teacher : teachers) {
                    System.out.println("Tên giảng viên: " + teacher.getName());
                    System.out.println("Email: " + teacher.getEmail());
                    System.out.println("Địa chỉ: " + teacher.getAddress());
                    System.out.println("Số giờ giảng dạy trong tháng: " + teacher.getHoursTaught());
                    if (teacher instanceof FullTimeTeacher) {
                        System.out.println("Số giờ quy định chung: " + ((FullTimeTeacher) teacher).getStandardHours());
                        System.out.println("Lương cơ bản: " + (teacher instanceof FullTimeTeacher ? ((FullTimeTeacher) teacher).calculateMonthlySalary() : "N/A"));
                    } else if (teacher instanceof PartTimeTeacher) {
                        System.out.println("Số điện thoại: " + ((PartTimeTeacher) teacher).getPhoneNumber());
                        System.out.println("Cơ quan làm việc: " + ((PartTimeTeacher) teacher).getWorkplace());
                        System.out.println("Lương cơ bản: " + ((PartTimeTeacher) teacher).calculateMonthlySalary());
                    }
                    System.out.println();
                }
            } else if (choice == 3) {
                double totalSalary = 0;
                for (Teacher teacher : teachers) {
                    totalSalary += teacher.calculateMonthlySalary();
                }
                System.out.println("Tổng số tiền lương: " + totalSalary);
            } else if (choice == 4) {
                Teacher highestPaidTeacher = null;
                double highestSalary = 0;

                for (Teacher teacher : teachers) {
                    double salary = teacher.calculateMonthlySalary();
                    if (salary > highestSalary) {
                        highestSalary = salary;
                        highestPaidTeacher = teacher;
                    }
                }

                if (highestPaidTeacher != null) {
                    System.out.println("Giảng viên có tổng lương cao nhất là: " + highestPaidTeacher.getName());
                    System.out.println("Với tổng lương: " + highestSalary);
                }
            } else if (choice == 5) {
                break;
            }
        }
	}
}
