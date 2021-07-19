package section2.n2.n3;

public class OrthoLine {
	public MyPoint2 u;
	public MyPoint2 v;
	
	public OrthoLine(MyPoint2 u, MyPoint2 v) {
		this.u = u;
		this.v = v;
		
		if(u.x > v.x || u.x == v.x && u.y > v.y) {
			swap();
		}
	}
	
	public void swap() {
		MyPoint2 tmp = u;
		u = v;
		v = tmp;
	}

	public OrthoLine(int x1, int y1, int x2, int y2) {
		this.u = new MyPoint2(x1, y1);
		this.v = new MyPoint2(x2, y2);
	}
	
	public boolean isVertical() {
		
		return (u.x == v.x);
	}
	
	public boolean intersects(OrthoLine other) {
		// 내가 수직선이고 other가 수평이면
		if(isVertical() && !other.isVertical()) {
			return true;
		} // 내가 수평이고 other가  수직이면
		else if(!isVertical() && other.isVertical()) {
			return true;
		} // 둘 다 수직선이거나 수평선인경우
		else {
			return false;
		}
	}
}
