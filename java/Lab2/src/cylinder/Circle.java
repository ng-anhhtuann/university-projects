package cylinder;

public class Circle {
	protected double radius = 1.0;
	protected String color = "red";

	public Circle() {}
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public Circle(String color, double radius) {
		this.radius = radius;
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String toString() {
		return "Circle[radius=" + this.radius + ",color=" + this.color + "]";
	}
}
