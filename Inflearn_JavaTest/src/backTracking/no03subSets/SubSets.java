package backTracking.no03subSets;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		
		if(nums == null || nums.length == 0) {
			return result;
		}
		
		dfs(result, list, nums, 0);
		
		return result;
	}

	private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
		// 1 담는 부분
		List<Integer> newList = new ArrayList<Integer>(list);
		result.add(newList);
		
		// 2 for
		for(int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			dfs(result, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
		
	}
}

public class SubSets {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		
		Solution s = new Solution();
		System.out.println(s.subsets(nums));
	}
}
