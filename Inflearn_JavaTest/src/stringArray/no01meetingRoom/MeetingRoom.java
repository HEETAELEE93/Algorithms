package stringArray.no01meetingRoom;

import java.util.Arrays;
import java.util.Comparator;

class Interval {
	int start;
	int end;

	public Interval() {
		this.start = 0;
		this.end = 0;
	}

	public Interval(int s, int e) {
		this.start = s;
		this.end = e;
	}
}

public class MeetingRoom {
	public static void main(String[] args) {
		MeetingRoom m = new MeetingRoom();
		Interval i1 = new Interval(15, 20);
		Interval i2 = new Interval(5, 10);
		Interval i3 = new Interval(0, 30);
		Interval[] intervals = {i1, i2, i3};
		
//		Interval i1 = new Interval(7, 10);
//		Interval i2 = new Interval(2, 4);
//		Interval[] intervals = {i1, i2};
		
		m.print(intervals);
		System.out.println("=========");
		System.out.println(m.solve(intervals));
		m.print(intervals);
		
	}

	public boolean solve(Interval[] intervals) {
		if(intervals == null) {
			return false;
		}
		Arrays.sort(intervals, comp);
		
		for(int i = 1; i < intervals.length; i++) {
			if(intervals[i-1].end > intervals[i].start) {
				return false;
			}
		}
		
		return true;
	}
	
	public static Comparator<Interval> comp = new Comparator<Interval>() {
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
		
	};
	
	public void print(Interval[] intervals) {
		for(Interval i : intervals) {
			System.out.println(i.start + " " + i.end);
		}
	}
}
