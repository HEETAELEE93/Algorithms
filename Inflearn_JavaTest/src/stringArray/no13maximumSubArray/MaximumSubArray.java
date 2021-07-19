package stringArray.no13maximumSubArray;

class Solution {
	public int maxSubArr(int[] nums) {
		// 1. 그릇
		int newSum = nums[0];
		int maxSum = nums[0];

		// 2. for
		for (int i = 1; i < nums.length; i++) {
			newSum = Math.max(nums[i], newSum + nums[i]);
			maxSum = Math.max(newSum, maxSum);
		}

		return maxSum;
	}
}

public class MaximumSubArray {
	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		Solution s = new Solution();
		System.out.println(s.maxSubArr(nums));
	}
}
