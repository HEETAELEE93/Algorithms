package BigONotation;

class sum1{
	public int sum(int n) {
		int sum = 0;
		// 1~n 까지의 합
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}

}

public class baekjoon_8393 {
	public static void main(String[] args) {
		sum1 s = new sum1();
		System.out.println(s.sum(3));
	}
}
