import java.util.InputMismatchException;
import java.util.Scanner;

public class Counting {

	private static double[] tinhPhanTram(int[] value) {
		int sum = 0;
		int n = value.length;
		double[] a = new double[n];
		for (int i : value) {
			if (i < 0) {
				throw new IllegalArgumentException("Số " + i + " không phải là số nguyên dương.");
			}
			sum += i;
		}
		for (int i = 0; i < n; i++) {
			a[i] = (double) value[i] / sum;
		}
		return a;
	}

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử: ");
        int n;
        while (true) {
            try {
                if (scanner.hasNextInt()) {
                    n = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Không phải là số. Vui lòng nhập lại: ");
                    scanner.next();
                }
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException");
                return;
            }
        }

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập giá trị phần tử số " + (i + 1));
            while (true) {
                try {
                    if (scanner.hasNextInt()) {
                        a[i] = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("Không phải là số. Vui lòng nhập lại: ");
                        scanner.next();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("InputMismatchException");
                    return;
                }
            }
        }

        double[] res;
        try {
            res = tinhPhanTram(a);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
            return;
        }

        System.out.println("Mảng phần trăm:");
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }

        scanner.close();
    }
}
