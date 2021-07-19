package lv2_01_IntactSquare;

class Solution {
	public long solution(long w, long h) {
		long answer = w * h - (w + h - gcd(w, h));
		
		// 최대공약수
		// BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();
		
		return answer;
	}
	// 최대 공약수
	private long gcd(long w, long h) {
		if (h == 0) {
			return w;
		}
		return gcd(h, w % h);
	}
}

public class IntactSquare {
	public static void main(String[] args) {
		int w = 8;
		int h = 12;

		Solution s = new Solution();
		System.out.println(s.solution(w, h));
	}
}
