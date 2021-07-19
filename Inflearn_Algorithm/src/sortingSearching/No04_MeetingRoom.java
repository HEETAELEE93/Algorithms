package sortingSearching;

import java.util.Arrays;

class MeetingRoom{
	public boolean solve(int[][] intervals) {
		if(intervals == null || intervals.length == 0) {
			return true;
		}
		Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
		int end = intervals[0][1];
		for(int i = 1; i < intervals.length; i++) {
			if(intervals[i][0] < end) {
				return false;
			}
			end = intervals[i][1];
		}
		return true;
	}
}

public class No04_MeetingRoom {
	public static void main(String[] args) {
		int[][] intervals = {
				{5,10}, {16,20},{0,30}	
		};
		MeetingRoom sol = new MeetingRoom();
		System.out.println(sol.solve(intervals));
	}
}
