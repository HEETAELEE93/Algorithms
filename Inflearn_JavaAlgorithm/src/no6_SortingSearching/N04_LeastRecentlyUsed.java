package no6_SortingSearching;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class LeastRecntlyUsed {
	public int[] solution(int s, int n, int[] arr) {
		int[] cache = new int[s];
		
		List<Integer> list = new LinkedList<>();
		
		for(int i : arr) {
			int j;
			for(j = 0; j < list.size(); j++) {
				if(list.get(j) == i) {
					break;
				}
			}
			if(!list.isEmpty() && j <= list.size() - 1) { //contains
				list.remove(j);
			} else {
				if(list.size() >= s) {
					list.remove(0);
				} 
			}
			list.add(i);
		}
		int cnt = s - 1;
		for(int i = 0; i < s; i++) {
			cache[i] = list.get(cnt--);
		}
		return cache;
	}
	public int[] solution2(int s, int n, int[] arr) {
		int[] cache = new int[s];
		
		for(int x : arr) {
			int pos = -1;
			for(int i = 0; i < s; i++) {
				if(x == cache[i]) {
					pos = i;
					break;
				}
			}
			if(pos == -1) {
				for(int i = s - 1; i >= 1; i--) {
					cache[i] = cache[i-1];
				}
			} else {
				for(int i = pos; i >= 1; i--) {
					cache[i] = cache[i-1];
				}
			}
			cache[0] = x;
		}
		
		return cache;
	}
}
public class N04_LeastRecentlyUsed {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int S = sc.nextInt();
//		int N = sc.nextInt();
//		int[] arr = new int[N];
//		for(int i = 0; i < N; i++) {
//			arr[i] = sc.nextInt();
//		}
		
		int S = 3;
		int N = 10;
		int[] arr = {1,7,3,5,9,10,4,5,6,10};
		
		LeastRecntlyUsed sol = new LeastRecntlyUsed();
		for(int i : sol.solution(S, N, arr)) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i : sol.solution2(S, N, arr)) {
			System.out.print(i + " ");
		}
	}
}
