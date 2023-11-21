
public class MovableCircle implements Movable {
	private int radius;
	private MovablePoint center;

	// Constructor
	public MovableCircle(int radius, int x, int y, int xSpeed, int ySpeed) {
		this.radius = radius;
		center = new MovablePoint(x, y, xSpeed, ySpeed);
	}

	// Getters and setters
	public MovablePoint getCenter() {
		return center;
	}

	public void setCenter(MovablePoint center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	// toString method for representing object state
	@Override
	public String toString() {
		return "MovableCircle{" + "radius=" + radius + ", center=" + center + '}';
	}

	@Override
	public void moveUp() {
		center.y += center.ySpeed;
	}

	@Override
	public void moveDown() {
		center.y -= center.ySpeed;
	}

	@Override
	public void moveLeft() {
		center.x -= center.xSpeed;
	}

	@Override
	public void moveRight() {
		center.x += center.xSpeed;
	}
}
