/*
 * 자릿수 더하기
 */

/*
문제 설명
자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.

제한사항
N의 범위 : 100,000,000 이하의 자연수

입출력 예
N	answer
123	6
987	24

입출력 예 설명

입출력 예 #1
문제의 예시와 같습니다.

입출력 예 #2
9 + 8 + 7 = 24이므로 24를 return 하면 됩니다.

 */

package lv1_07_AddNum;

class Solution{
	/* 
	 * String 형변환을 통해 각 자리수를 String형으로 바꾸고 
	 * 다시 int 형변환을 통해 substring 함수를 이용하여 값을 더함
	 */
	public int solution(int n) {
		int answer = 0;
		
		// int값 받아서 String으로 형변환
		String a = Integer.toString(n);
		
		for(int i = 0; i < a.length(); i++) {
			answer += Integer.parseInt(a.substring(i, i+1));
		}
		return answer;
	}
}

class Solution1{
	/*
	 * n을 10으로 나눠서 몫과 나머지를 따로 구해서 나머지를 순차적으로 더해감
	 */
	public int solution(int n) {
		int answer = 0;
		
		int length = (int)(Math.log10(n)+1);
		int a = n;
		int b = a;
		
		for(int i = 0; i < length; i++) {
			b = a % 10;
			a = a / 10;
			answer += b;
		}
		return answer;
	}
}

class Solution2{
	/*
	 * solution1 보다 더 간단하게
	 */
	public int solution(int n) {
		int answer = 0;
		
		while(n>0) {
			answer += n%10;
			n /= 10;
		}
		
		return answer;
	}
}

public class AddNum {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		Solution2 a = new Solution2();
		System.out.println(a.solution(12345));
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);
	}
}