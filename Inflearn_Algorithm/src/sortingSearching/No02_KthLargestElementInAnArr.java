package sortingSearching;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class KthLargestElementInAnArray {
	public int solve (int[] nums, int k) {
		Arrays.sort(nums);
		int n = nums.length;
		
		return nums[n-k];
	}
	
	public int solve_que(int[] nums, int k) {
		
		Queue<Integer> pq = new PriorityQueue<Integer>(); // min heap
		
		for(int i : nums) {
			pq.offer(i);
			if(pq.size() > k) {
				pq.poll();
			}
		}
		
		return pq.peek();
	}
}

public class No02_KthLargestElementInAnArr {
	public static void main(String[] args) {
		int[] nums = {3,2,3,1,2,4,5,5,6};
		int k = 4;
		KthLargestElementInAnArray sol = new KthLargestElementInAnArray();
		System.out.println(sol.solve(nums, k));
		System.out.println(sol.solve_que(nums, k));
	}
}
