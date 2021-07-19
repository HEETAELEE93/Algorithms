/*
 * Stock Price 주식 가격
 * 
 * 문제 설명
초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

제한사항
prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
prices의 길이는 2 이상 100,000 이하입니다.

입출력 예
prices			return
[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]

입출력 예 설명
1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
 */

package lv2_01_stockPrice;

import java.util.Arrays;
import java.util.Stack;

class Solution {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		int count = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (j != prices.length - 1 && prices[i] <= prices[j]) {
					continue;
				} else if (j == prices.length - 1) {
					answer[i] = j - i;
				} else {
					answer[i] = j - i;
					break;
				}
			}
		}
		return answer;
	}
}

class UseStackSolution {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		Stack<Integer> beginIdxs = new Stack<Integer>();
		int i = 0;

		beginIdxs.push(i);

		for (i = 1; i < prices.length; i++) {
			while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
				int beginIdx = beginIdxs.pop();
				answer[beginIdx] = i - beginIdx;
			}
			beginIdxs.push(i);
		}

		while (!beginIdxs.empty()) {
			int beginIdx = beginIdxs.pop();
			answer[beginIdx] = i - beginIdx - 1;
		}

		return answer;
	}
}

public class StockPrice {
	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3 };
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.solution(prices)));
		// return 4, 3, 1, 1, 0

		UseStackSolution stSol = new UseStackSolution();
		System.out.println(Arrays.toString(stSol.solution(prices)));
	}
}
