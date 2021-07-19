package lv2_01_dfs_targetNumber;

import java.util.stream.IntStream;

class Solution {
	int answer = 0;
	public int solution(int[] numbers, int target) {
		int sum = IntStream.of(numbers).sum();

		if (sum < target) {
			return 0;
		} else if (sum == target) {
			return 1;
		}
		dfs(numbers, target, 0, 0);
		return answer;
	}

	private void dfs(int[] numbers, int target, int sum, int idx) {
		if (idx == numbers.length && sum == target) {
			answer++;
			return;
		}
		if (idx >= numbers.length) {
			return;
		}
		dfs(numbers, target, sum + numbers[idx], idx + 1);
		dfs(numbers, target, sum - numbers[idx], idx + 1);
	}
}

public class TargetNumber {
	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		Solution s = new Solution();
		System.out.println(s.solution(numbers, target));
	}
}
