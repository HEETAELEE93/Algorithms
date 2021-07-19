package section2.n3.n1;

public class Test {
	static int s = 0;
	int t = 0;
	
	public static void print1() {
		System.out.println("s= " + s);
//		System.out.println("t= " + t);
	}
	
	public void print2() {
		System.out.println("s= " + s);
		System.out.println("t= " + t);
	}
	
	public static void main(String[] args) {
		Test a = new Test();
		s = 100;
		a.t = 20;
		print1();
		a.print2();
		
	}
}