package array;

/*
 * 정수 배열 nums에서 합계가 가장 큰 연속 하위 배열(최소한 한개 포함)을 찾아서 합계 리턴
 * O(n) 이하로 구현
 * 1 <= nums.length <= 3 * 10^4
 * -10^5 < nums[i] < 10^5
 */

class MaximumSubArr{
	public int solve(int[] nums) {
		int curMax = nums[0];	// 현재까지 Max
		int allMax = nums[0];	
		
		for(int i = 1; i < nums.length; i++) {
			curMax = Math.max(nums[i], nums[i] + curMax);
			allMax = Math.max(allMax, curMax);
		}
		
		return allMax;
	}
}

public class No03_MaximumSubarray {
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		MaximumSubArr sol = new MaximumSubArr();
		System.out.println(sol.solve(nums));
	}
}
