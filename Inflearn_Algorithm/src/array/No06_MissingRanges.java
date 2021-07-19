package array;

import java.util.ArrayList;
import java.util.List;

/*
 * 범위 lower, upper 안에 포함하지 않는
 * 정수 배열 nums 외의 값 구하기
 */

class MissingRanges {
	public List<String> solve(int[] nums, int lower, int upper){
		List<String> result = new ArrayList<String>();
		
		if(nums == null || nums.length == 0) {
			return result;
		}
		
		// 1. 0 -> 2
		if(lower < nums[0]) {
			result.add(makeRange(lower, nums[0] - 1));
		}
		// 2. 4, 6 -> 49, 51->74
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i] != nums[i+1] && nums[i] + 1 < nums[i+1]) { 
				result.add(makeRange(nums[i] + 1, nums[i+1] - 1));
			}
		}
		// 3. 76 -> 99
		if(nums[nums.length - 1] < upper) {
			result.add(makeRange(nums[nums.length - 1] + 1, upper));
		}
		
		return result;
	}

	private String makeRange(int lower, int high) {
		return lower == high ? String.valueOf(lower) : (lower + "->" + high);
	}
}

public class No06_MissingRanges {
	public static void main(String[] args) {
		int[] nums = { 2, 3, 5, 50, 75 };
		int lower = 0;
		int upper = 99;
		MissingRanges sol = new MissingRanges();
		System.out.println(sol.solve(nums, lower, upper));
	}
}
