package stringArray.no05mergeInterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

class MergeInterval1 {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		if(intervals.isEmpty()) {
			return intervals;
		}
		// 정렬 방법 두개 똑같
		Collections.sort(intervals, (a,b) -> a.start-b.start);
//		Collections.sort(intervals, new Comparator<Interval>(){
//			@Override
//			public int compare(Interval o1, Interval o2) {
//				return o1.start - o2.start;
//			}
//		});
		print(intervals);
		System.out.println("======");
		Interval before = intervals.get(0);
		for(int i = 1; i < intervals.size(); i++) {
			Interval now = intervals.get(i);
			if(before.end >= now.start) {
				before.end = Math.max(before.end, now.end);
			} else {
				result.add(before);
				before = now;
			}
		}
		if(!result.contains(before)) {
			result.add(before);
		}
		
		return result;
	}
	
	void print(List<Interval> list) {
		for(int i = 0; i < list.size(); i++) {
			Interval in = list.get(i);
			System.out.println(in.start + " " + in.end);
		}
	}
}

public class MergeInterval {
	public static void main(String[] args) {
		
		MergeInterval1 mI = new MergeInterval1();
		List<Interval> intervals = new ArrayList<Interval>();
		
		Interval in1 = new Interval(2,6);
		Interval in2 = new Interval(1,3);
		Interval in3 = new Interval(8,10);
		Interval in4 = new Interval(15,18);
		
		intervals.add(in1);
		intervals.add(in2);
		intervals.add(in3);
		intervals.add(in4);
		
		List<Interval> result = mI.merge(intervals);
		mI.print(result);
	}
}
