package cylinder;
import java.util.Scanner;

public class TestCylinder {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("Nhap thong so cua cylinder:");
			System.out.print("height: ");
			double height = scanner.nextDouble();
			
			System.out.print("radius: ");
			double radius = scanner.nextDouble();
			
			System.out.print("color: ");
			String color = scanner.next();
			
			Cylinder cy3 = new Cylinder(color, radius, height);
			Cylinder cy0 = new Cylinder();
			Cylinder cy1 = new Cylinder(radius);
			Cylinder cy2 = new Cylinder(radius, height);
			
			System.out.println(cy0.toString());
			System.out.println(cy1.toString());
			System.out.println(cy2.toString());
			System.out.println(cy3.toString());
			
		} catch (Exception e) {
			System.out.println("Sai kieu du lieu");
		}
		scanner.close();

	}
}
