package Resize;

public class Circle implements GeometricObject {
	double radius = 1.0;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double getPerimeter() {
		return 2.0 * 3.14 * radius;
	}

	@Override
	public double getArea() {
		return radius * radius * 3.14;
	}

}
