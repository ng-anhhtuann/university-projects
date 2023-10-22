
public class Rectangle {

	private float length = 1.0f;

	private float width = 1.0f;

	public Rectangle() {
	}

	public Rectangle(float length, float width) {
		this.length = length;
		this.width = width;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public double getArea() {
		return (double) this.length * this.width;
	}

	public double getPerimeter() {
		return (double) (this.length + this.width) * 2;
	}

	public String toString() {
		return "Rectangle[length= " + this.length + ",width= " + this.width + "]";
	}

}
