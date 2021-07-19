package sortingSearching;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class MeetingRoomPriority{
	public int solve (int[][] intervals) {
		Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
		Queue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[1] - b[1]);
		
		for(int[] arr : intervals) {
			if(pq.isEmpty()){
				pq.offer(arr);
			} else {
				if(pq.peek()[1] <= arr[0]) {
					pq.poll();
				}
				pq.offer(arr);
			}
		}
		return pq.size();
	}
}

public class No05_MeetingRoom_PriorityQ {
	public static void main(String[] args) {
		int[][] intervals = {
				{5,10}, {16,20},{0,30}	
		};
		MeetingRoomPriority sol = new MeetingRoomPriority();
		System.out.println(sol.solve(intervals));
	}
}
