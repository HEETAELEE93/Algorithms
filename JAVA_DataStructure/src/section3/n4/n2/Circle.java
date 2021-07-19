package section3.n4.n2;

public class Circle extends Shape{
	public int radius;

	public Circle(int radius) {
		super("Circle");
		this.radius = radius;
	}

	@Override
	public double computeArea() {
		return Math.PI * radius;
	}

	@Override
	public double computePerimeter() {
		return 2.0 * Math.PI * radius;
	}

	@Override
	public String toString() {
		return "Circle [radius= " + radius + " ]";
	}
	
}
