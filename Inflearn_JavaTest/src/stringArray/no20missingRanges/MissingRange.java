package stringArray.no20missingRanges;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<String> solve(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<String>();

		if (nums == null || nums.length == 0) {
			return result;
		}

		if (lower < nums[0]) {
			result.add(makeRange(lower, nums[0] - 1));
		}

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != nums[i + 1] && nums[i] + 1 < nums[i + 1]) {
				result.add(makeRange(nums[i] + 1, nums[i+1] -1));
			}
		}
		
		if(nums[nums.length - 1] < upper) {
			result.add(makeRange(nums[nums.length-1] + 1, upper));
		}

		return result;
	}

	private String makeRange(int low, int high) {
		return low == high ? String.valueOf(low) : (low + "->" + high);
	}
}

public class MissingRange {
	public static void main(String[] args) {
		int[] nums = { 2, 3, 5, 50, 75 };
		int lower = 0, upper = 99;
		Solution s = new Solution();
		System.out.println(s.solve(nums, lower, upper));
	}
}
