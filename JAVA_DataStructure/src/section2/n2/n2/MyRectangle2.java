package section2.n2.n2;

public class MyRectangle2 {
	public MyPoint2 lu; // 왼쪽 위
	public int width;
	public int height;

	public MyRectangle2(int x, int y, int width, int height) {
		this.lu = new MyPoint2(x, y);
		this.width = width;
		this.height = height;
	}
	
	public MyRectangle2(MyPoint2 p, int width, int height) {
		this.lu = p;
		this.width = width;
		this.height = height;
	}
	
	public int calcArea() {
		return width * height;
	}

	@Override
	public String toString() {
		return "[lu=" + lu.x + " " + lu.y + "], width=" + width + ", height=" + height;
	}
	
}
