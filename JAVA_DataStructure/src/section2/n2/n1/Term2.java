package section2.n2.n1;
// 항 클래스
public class Term2 {
	public int coef; // 계수
	public int expo; // 차수
	
	public int calcTerm(int x) {
		// 지수 함수 계산 함수
		return (int) (coef * Math.pow(x, expo));
	}
	
	public void printTerm() {
		if (coef == 1) {
			System.out.print("x^" + expo);
		} else if(coef == -1) {
			System.out.print("-x^" + expo);
		} else if(expo == 0) {
			System.out.print(coef);
		}
		
		else {
			System.out.print(coef + "x^" + expo);
		}
	}
}
