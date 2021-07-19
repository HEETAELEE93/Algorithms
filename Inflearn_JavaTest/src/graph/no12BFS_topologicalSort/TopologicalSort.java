package graph.no12BFS_topologicalSort;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public boolean solve(int course, int[][] nums) {
		if (course <= 0) {
			return false;
		}

		// 1. inDegree 배열, Queue 만들기
		Queue<Integer> que = new LinkedList<Integer>();
		int[] inDegree = new int[course];

		// 1-1. inDegree
		int numsLen = nums.length;
		for (int i = 0; i < numsLen; i++) {
			inDegree[nums[i][1]]++;
		}

		// 1-2 inDgree 값이 0인걸 찾아서 que에 삽입
		int inDegreeLen = inDegree.length;
		for (int i = 0; i < inDegreeLen; i++) {
			if (inDegree[i] == 0) {
				que.offer(i);
			}

		}
		while (!que.isEmpty()) {
			int firstZeroVal = que.poll();

			for (int i = 0; i < numsLen; i++) {
				if (firstZeroVal == nums[i][0]) {
					inDegree[nums[i][1]]--;
					if (inDegree[nums[i][1]] == 0) {
						que.offer(nums[i][1]);
					}
				}
			}
		}

		for (int i = 0; i < inDegreeLen; i++) {
			if (inDegree[i] != 0) {
				return false;
			}

		}

		return true;
	}
}

public class TopologicalSort {
	public static void main(String[] args) {
		int course = 4;
		int[][] nums = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
		int[][] nums2 = { { 1, 0 }, { 0, 1 } };

		Solution s = new Solution();
		System.out.println(s.solve(course, nums));
		
		int course2 = 4;
		System.out.println(s.solve(course2, nums2));
	}
}
