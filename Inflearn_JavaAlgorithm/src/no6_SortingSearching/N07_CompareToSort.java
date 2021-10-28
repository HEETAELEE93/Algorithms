package no6_SortingSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point>{
	public int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Point o) {
		if(this.x == o.x) {
			return this.y - o.y; // 오름차순(음수값 나오게)
		} else {
			return this.x - o.x;
		}
	}
}

public class N07_CompareToSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Point> list = new ArrayList<Point>();
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.add(new Point(x, y));
		}
//		5
//		2 7
//		1 3
//		1 2
//		2 5
//		3 6

		Collections.sort(list);
		for(Point o : list) {
			System.out.println(o.x + " " + o.y);
		}
	}
}
