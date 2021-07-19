package stringArray.no19kthLargestElementInAnArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
// Use Priority Queue
class Solution {
	public int solve(int[] nums, int k) {
		Queue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		for(int val : nums) {
			pq.add(val);
			if(pq.size() > k) {
				pq.poll();
			}
		}
		
		return pq.peek();
	}
}

class MySolution {
	public int solve(int[] nums, int k) {
		Arrays.sort(nums);
		
		return nums[nums.length-k];
	}
}

public class KthLargestElementInAnArray {
	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		int[] nums2 = {3,2,3,1,2,4,5,5,6}; 
		int k =2;
		Solution s = new Solution();
		System.out.println(s.solve(nums, k));
		
		System.out.println("=====");
		MySolution ms = new MySolution();
		System.out.println(ms.solve(nums, k));
	}
}
