package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSumOn2{
	public int[] solve(int[] nums, int target) {
		int len = nums.length;
		
		for(int i = 0; i < len; i++) {
			for(int j = i+1; j < len; j++) {
				if(target == nums[i] + nums[j]) {
					return new int[] {i, j};
				}
			}
		}
		return new int[] {0, 0};
	}
}

class TwoSumOn{
	public int[] solve(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				int val = map.get(nums[i]);
				result[0] = val;
				result[1] = i;
				return result;
			} else {
				map.put(target - nums[i], i);
			}
		}
		return result;
	}
}

public class No01_TwoSum {
	public static void main(String[] args) {
		int[] nums = {2,8,11,14};
		int target = 16;
		TwoSumOn2 sol = new TwoSumOn2();
		System.out.println(Arrays.toString(sol.solve(nums, target)));
		TwoSumOn sol2 = new TwoSumOn();
		System.out.println(Arrays.toString(sol2.solve(nums, target)));
	}
}
