package sortingSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeInterval {
	public int[][] solve(int[][] intervals){
		
		List<int[]> res = new ArrayList<int[]>();
		
		if(intervals.length == 0 || intervals == null) {
			return res.toArray(new int[0][]);
		}
		
		Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
		
		int start = intervals[0][0];
		int end = intervals[0][1];
		
		for(int[] i : intervals) {
			if(end >= i[0]) {
				end = Math.max(end, i[1]);
			} else {
				res.add(new int[] {start, end});
				start = i[0];
				end = i[1];
			}
		}
		res.add(new int[] {start, end});
		
		return res.toArray(new int[0][]);
	}
}

public class No06_MergeInterval {
	public static void main(String[] args) {
		int[][] intervals = {
				{1,4},{2,6},{8,10},{15,18}
		};
		MergeInterval sol = new MergeInterval();
		System.out.println(Arrays.deepToString(sol.solve(intervals)));
	}
}
