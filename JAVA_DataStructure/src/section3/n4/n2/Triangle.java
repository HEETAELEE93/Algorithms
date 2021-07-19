package section3.n4.n2;

public class Triangle extends Shape{
	public int width;
	public int height;
	
	public Triangle(int width, int height) {
		super("Triangle");
		this.width = width;
		this.height = height;
	}
	@Override
	public double computeArea() {
		return 1/2 * (width * height);
	}
	
	// 직각삼각형만
	@Override
	public double computePerimeter() {
		return Math.sqrt(width * width + height * height) + width + height;
	}
	
}
