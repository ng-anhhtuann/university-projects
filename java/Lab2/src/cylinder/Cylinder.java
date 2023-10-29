package cylinder;

public class Cylinder extends Circle {

	private double height = 1.0;

	public Cylinder() {
	}

	public Cylinder(double radius) {
		this.radius = radius;
	}

	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}

	public Cylinder(String color, double radius, double height) {
		super(color, radius);
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getVolumn() {
		return this.height * this.radius *  2 * 3.14;
	}

	public String toString() {
		return "Cylinder[ radius=" + this.radius + ", color=" + this.color + ", height=" + this.height + ", volumn="
				+ getVolumn() + " ]";
	}

}
