/*
 * 소수찾기 Find Prime Number
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 */
/*
문제 설명
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 
흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 
종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

입출력 예
numbers	return
17		3
011		2

입출력 예 설명

예제 #1
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

예제 #2
[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.

11과 011은 같은 숫자로 취급합니다.
 */

package lv2_02_FindPrimeNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Solution {

	private Set<String> numSet = new TreeSet<>();
	private int answer = 0;

	public int solution(String numbers) {

		List<Character> list = new ArrayList<Character>();
		for (char i : numbers.toCharArray()) {
			list.add(i);
		}

		List<Character> res = new ArrayList<Character>();

		for (int i = 0; i < numbers.length(); i++) {
			permutation(list, res, numbers.length(), i + 1);
		}

		return answer;
	}

	private void permutation(List<Character> list, List<Character> res, int n, int r) {
		if (r == 0) {
			if (res.get(0) != '0') {
				String str = "";
				int size = res.size();
				for (int i = 0; i < size; i++) {
					str += res.get(i);
				}
				int num = 0;

				if (!numSet.contains(str)) {
					num = Integer.parseInt(str);
					numSet.add(str);

					if (isPrime(num)) {
						answer++;
					}
				}
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			res.add(list.remove(i));
			permutation(list, res, n - 1, r - 1);
			list.add(i, res.remove(res.size() - 1));
		}
	}

	boolean isPrime(int n) {
		int i;
		int sqrt = (int) Math.sqrt(n);

		// 1, 2일때
		if (n == 1) {
			return false;
		}
		if (n == 2 || n == 3 || n == 5 || n == 7) {
			return true;
		}

		// 맨 끝 2의 배수일때
		if (n % 2 == 0) {
			return false;
		}

		// 다 합해서 3의 배수
		int sum = 0;
		int imsi = n;
		while (imsi >= 1) {
			sum += (imsi % 10);
			imsi /= 10;
		}
		if (sum % 3 == 0) {
			return false;
		}

		// 맨 끝 5일때
		if (n % 5 == 0) {
			return false;
		}

		// 루트해서 나온 수까지 나누기
		for (i = 3; i <= sqrt; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	private boolean isPrime2(int n) {

		int i;
		int sqrt = (int) Math.sqrt(n);

		// 2는 유일한 짝수 소수
		if (n == 2)
			return true;

		// 짝수와 1은 소수가 아님
		if (n % 2 == 0 || n == 1)
			return false;

		// 제곱근까지만 홀수로 나눠보면 됨
		for (i = 3; i <= sqrt; i += 2) {
			if (n % i == 0)
				return false;
		}

		return true;
	}
}

public class FindPrimeNumber {
	public static void main(String[] args) {
		String numbers = "17"; // 7,17,71 3
		String numbers1 = "011"; // 11,101 2
		Solution s = new Solution();
//		System.out.println(s.solution(numbers));
		System.out.println(s.solution(numbers1));
		
		System.out.println(s.isPrime(333));
	}
}
