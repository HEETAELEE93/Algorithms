package sortingSearching;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class KClosestPointsToOrigin{
	public int[][] solve (int[][] points, int k){
		Queue<int[]> que = new PriorityQueue<int[]>((a,b) ->
		(a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));
		
		int[][] result = new int[k][2];
		
		for(int[] i : points) {
			que.offer(i);
		}
		
		int idx = 0;
		while(idx < k) {
			result[idx] = que.poll();
			idx++;
		}
		return result;
	}
}

public class No03_KClosestPointsToOrigin {
	public static void main(String[] args) {
		KClosestPointsToOrigin sol = new KClosestPointsToOrigin();
		int[][] points = {
				{3,3}, {5,-1}, {-2,4}
		};
		int k = 2;
		System.out.println(Arrays.deepToString(sol.solve(points, k)));
	}
}
