package no6_SortingSearching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class DuplicateCheck{
	public String solution(int n, int[] arr) {
		String answer = "U";
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i : arr) {
			set.add(i);
		}
		if(set.size() != n) {
			return "D";
		}
		
		return answer;
	}
	
	public String solution2(int n, int[] arr) {
		String answer = "U";
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i : arr) {
			map.put(i, map.getOrDefault(i, 0)+1);
			if(map.get(i) > 1) {
				return "D";
			}
		}
		
		return answer;
	}
	
	public String solution3(int n, int[] arr) {
		String answer = "U";
		Arrays.sort(arr);
		for(int i = 1; i < n; i++) {
			if(arr[i-1] == arr[i]) {
				return "D";
			}
		}
		
		return answer;
	}
}
public class N05_DuplicateCheck {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] arr = new int[n];
//		for(int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
		
		int n = 8;
		int[] arr = { 20, 25, 52, 30, 39, 33, 43, 33 };
		DuplicateCheck sol = new DuplicateCheck();
		System.out.println(sol.solution(n, arr));
		System.out.println(sol.solution2(n, arr));
		System.out.println(sol.solution3(n, arr));
	}
}
