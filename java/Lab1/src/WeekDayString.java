import java.util.Scanner;

public class WeekDayString {

	public void DayNumberToWeekDay() {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ngày theo format (dd/mm/yyyy): ");
        String dateInput = scanner.nextLine();
        scanner.close();

        String[] dv = dateInput.split("/");
        if (dv.length != 3) {
            System.out.println("INVALID");
            return;
        }

        int day = Integer.parseInt(dv[0]);
        int month = Integer.parseInt(dv[1]);
        int year = Integer.parseInt(dv[2]);

        if (checkDate(day, month, year)) {
            int dayOfWeek = tinhNgay(day, month, year);
            System.out.println(getDayOfWeekName(dayOfWeek));
        } else {
            System.out.println("INVALID");
        }
	}
	
	private static boolean checkDate(int day, int month, int year) {
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        } else if (month == 2) {
            if (year % 4 == 0) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        }

        return true;
    }

    private static int tinhNgay(int day, int month, int year) {
        if (month < 3) {
            month += 12;
            year -= 1;
        }
        int k = year % 100;
        int j = year / 100;

        int dayOfWeek = (day + 13 * (month + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;
        return dayOfWeek;
    }

    private static String getDayOfWeekName(int dayOfWeek) {
        switch (dayOfWeek) {
            case 0:
                return "Thứ bảy";
            case 1:
                return "Chủ nhật";
            case 2:
                return "Thứ 2";
            case 3:
                return "Thứ 3";
            case 4:
                return "Thứ 4";
            case 5:
                return "Thứ 5";
            case 6:
                return "Thứ 6";
            default:
                return "INVALID";
        }
    }
	
}
