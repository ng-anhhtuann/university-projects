
public class ResizeableCircle extends Circle implements Resizeable {

	public ResizeableCircle(double radius) {
		super(radius);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double resize(int percent) {
		return radius * percent / 100;
	}

}
