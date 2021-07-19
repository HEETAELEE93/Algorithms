package stringArray.no06meetingRoom2_PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

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

class MyMeetingRoom {
	public int solve(Interval[] intervals) {
		
		if(intervals == null || intervals.length == 0) {
			return 0;
		}
		print(intervals);
		System.out.println("=====");
		Arrays.sort(intervals, comp);
		
		print(intervals);
		System.out.println("=====");
		Queue<Interval> heap = new PriorityQueue<Interval>(intervals.length, comp2);
		
		heap.offer(intervals[0]);
		
		for(int i = 1; i < intervals.length; i++) {
			Interval interval = heap.poll();
			
			if(interval.end > intervals[i].start) {
				heap.offer(intervals[i]);
			}
			heap.offer(interval);
		}
		
		return heap.size();
	}
	
	public Comparator<Interval> comp = new Comparator<Interval>() {
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
	};
	
	public Comparator<Interval> comp2 = new Comparator<Interval>() {
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.end - o2.end;
		}
		
	};
	
	public void print(Interval[] intervals) {
		for(Interval i : intervals) {
			System.out.println(i.start + " " + i.end);
		}
	}
}

public class MeetingRoom2 {
	public static void main(String[] args) {
		MyMeetingRoom m = new MyMeetingRoom();
		Interval i1 = new Interval(15,20);
		Interval i2 = new Interval(5, 10);
		Interval i3 = new Interval(0,30);
		Interval[] intervals = {i1, i2, i3};
		
		System.out.println(m.solve(intervals));
	}
}
