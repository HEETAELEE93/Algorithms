/*
 * 최대공약수와 최소공배수
문제 설명
두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 
배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 
예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 
solution(3, 12)는 [3, 12]를 반환해야 합니다.

제한 사항
두 수는 1이상 1000000이하의 자연수입니다.
입출력 예
n	m	return
3	12	[3, 12]
2	5	[1, 10]

입출력 예 설명

입출력 예 #1
위의 설명과 같습니다.

입출력 예 #2
자연수 2와 5의 최대공약수는 1, 최소공배수는 10이므로 [1, 10]을 리턴해야 합니다.
 */

package lv1_11_Divisor_Multiple;

import java.util.Arrays;
import java.lang.Math;

class Solution{
	public int[] solution(int n, int m) {
		int[] answer = new int[2];
		
		// n, m 중 작은 수
		int range = Math.min(n, m);
		
		// 최대공약수
		for(int i=1; i <= range; i++) {
			// 두 수 모두 약수이면
			if(n % i == 0 && m % i == 0) {
				answer[0] = i;
			}
		}
		// 최소공배수
		int a = n / answer[0];
		int b = m / answer[0];
		answer[1] = answer[0] * a * b;
 
		return answer;
	}
}

/* 유클리드 알고리즘  ^ Euclidean Algorithm */
class Solution1{
	public int[] solution(int n, int m) {
		int[] answer = new int[2];
		answer[0] = gcd(n,m);
		// answer[1] = (n / gcd(n,m)) * (m / gcd(n,m));
		answer[1] = (n*m) / gcd(n,m);
		return answer;
	}
	// Euclidean Algorithm 사용하여 재귀함수를 이용한 최대공약수 
	public static int gcd(int p, int q) {
		if(q == 0) 
			return p;
		return gcd(q, p%q);
	}
}

public class CommonDivisorMultiple {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		System.out.println(Arrays.toString(s.solution(60, 48)));
	}
}