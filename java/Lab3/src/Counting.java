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

	/*
	 * 3 trường hợp
	 * + Ngoại lệ NegativeArraySizeException khi n nhập vào < 0 -> size của mảng ko đc bé hơn 0
	 * + Ngoại lệ ArithmeticException khi tổng sum bằng 0: Nếu tổng sum của các phần tử trong mảng value bằng 0, 
	 * phép chia (double) value[i] / sum sẽ gây ra một lỗi chia cho 0 và ném ra một ngoại lệ ArithmeticException.
	 * + Ngoại lệ NullPointerException khi tham số value là null: Nếu tham số value được truyền vào là null, việc 
	 * truy cập value.length trong câu lệnh int n = value.length sẽ gây ra một ngoại lệ NullPointerException.
	 * + Ngoại lệ ArrayIndexOutOfBoundsException khi truy cập vượt quá chỉ số của mảng: Nếu chỉ số i trong vòng lặp
	 * for (int i = 0; i < n; i++) vượt quá phạm vi chỉ số của mảng value, ví dụ như i = n hoặc hơn, thì việc truy cập value[i] sẽ gây ra ngoại lệ ArrayIndexOutOfBoundsException.
	 */
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
            } catch (Exception e) {
				System.out.println("Exception happen");
				return;
			}
//            } catch (NumberFormatException e) {
//                System.out.println("NumberFormatException");
//                return;
//            } catch (NegativeArraySizeException e) {
//                System.out.println("NegativeArraySizeException");
//                return;
//            }
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
