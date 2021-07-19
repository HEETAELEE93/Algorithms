package stringArray.no09kClosestPointsToOrigin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public int[][] kClosest(int[][] points, int k) {
		int[][] result = new int[k][2];
		Queue<int[]> que = new PriorityQueue<>(points.length, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return (o1[0] * o1[0] + o1[1] * o1[1]) 
						- (o2[0] * o2[0] + o2[1] * o2[1]);
			}
		});
		
//		Queue<int[]> que = new PriorityQueue<>((o1,o2)->(o1[0] * o1[0] + o1[1] * o1[1]) - (o2[0] * o2[0] + o2[1] * o2[1]));
		
		int idx = 0;
		for(int[] p : points) {
			que.offer(p);
		}
		while(idx < k) {
			result[idx] = que.poll();
			idx++;
		}

		return result;
	}
}

class MySolution{
	public int[][] kClosestPoint(int[][] points, int k){
		int[][] result = new int[k][2];
		
		
		
		return result;
	}
}

public class KClosestPoint {
	public static void main(String[] args) {
		//int[][] points = { { 1, 3 }, { -2, 2 } };
		int[][] points = { {3,3}, {5,-1}, {-2,4} };  
		
		int k = 1;
		Solution s = new Solution();
		System.out.println(Arrays.deepToString(s.kClosest(points, k)));
		
		MySolution ms = new MySolution();
		System.out.println(Arrays.deepToString(ms.kClosestPoint(points, k)));
	}
}
