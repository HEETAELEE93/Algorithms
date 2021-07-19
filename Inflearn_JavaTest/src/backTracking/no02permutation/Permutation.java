package backTracking.no02permutation;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<List<Integer>> permute_dfs(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		List<Integer> list = new ArrayList<Integer>();

		if (nums == null || nums.length == 0) {
			return result;
		}

		dfs(nums, result, list);

		return result;
	}

	private void dfs(int[] nums, List<List<Integer>> result, List<Integer> list) {
		// 1 담는거
		if (list.size() == nums.length) {
			List<Integer> newList = new ArrayList<Integer>(list);
			result.add(newList);
		}

		// 2 for문에서 담고 탈출
		for (int i = 0; i < nums.length; i++) {

//			if (list.size() == nums.length) {
//				//continue;
//				break;
//			}
			
			if(list.contains(nums[i])) {
				continue;
			}
			
			list.add(nums[i]);
			dfs(nums, result, list);
			list.remove(list.size() - 1);
		}
	}
}

public class Permutation {
	public static void main(String[] args) {
		int[] arr = { 1, 2};
		Solution s = new Solution();
		System.out.println(s.permute_dfs(arr));
	}
}
