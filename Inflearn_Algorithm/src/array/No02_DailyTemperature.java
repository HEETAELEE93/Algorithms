package array;

import java.util.Arrays;
import java.util.Stack;

class DailyTemperatureFor2 {
	public int[] solve(int[] nums) {
		int len = nums.length;
		int[] result = new int[len];
		
		int cnt = 0, j;
		
		for (int i = 0; i < len; i++) {
			for(j = i + 1; j < len; j++) {
				if(nums[i] < nums[j]) {
					cnt++;
					break;
				} else {
					cnt++;
				}
			}
			if(j == nums.length) {
				result[i] = 0;
			} else {
				result[i] = cnt;
			}
			cnt = 0;
		}
		return result;
	}
}

class DailyTemperatureStack {
	public int[] solve(int[] nums) {
		int len = nums.length;
		int[] result = new int[len];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < len; i++) {
			while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				int idx = stack.pop();
				result[idx] = i - idx;
			}
			stack.push(i);
		}
		return result;
	}
}

public class No02_DailyTemperature {
	public static void main(String[] args) {
		int[] nums = { 73, 74, 75, 71, 69, 72, 76, 73 };
		DailyTemperatureFor2 sol = new DailyTemperatureFor2();
		System.out.println(Arrays.toString(sol.solve(nums)));
		DailyTemperatureStack sol2 = new DailyTemperatureStack();
		System.out.println(Arrays.toString(sol2.solve(nums)));
	}
}
