package no4_MapSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class TypesOfSales {
	public List<Integer> solution (int n, int k, int[] arr){
		List<Integer> answer = new ArrayList<Integer>();
		
		for(int i = 0; i <= n - k; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			for(int j = i; j < i + k; j++) {
				map.put(arr[j], map.getOrDefault(arr[j], 0)+1);
			}
			answer.add(map.size());
		}
		
		return answer;
	}
	
	public List<Integer> solution2 (int n, int k, int[] arr){
		List<Integer> answer = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < k - 1; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		int lt = 0;
		for(int rt = k - 1; rt < n; rt++) {
			map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
			answer.add(map.size());
			map.put(arr[lt], map.get(arr[lt]) - 1);
			if(map.get(arr[lt]) == 0) {
				map.remove(arr[lt]);
			}
			lt++;
		}
		return answer;
	}
}

public class N03_TypesOfSales {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int k = sc.nextInt();
//		int[] arr = new int[n];
//		for(int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
		
		int n = 7;
		int k = 4;
		int[] arr = {20, 12, 20, 10, 23, 17, 10};
		TypesOfSales sol = new TypesOfSales();
		for(int x : sol.solution(n, k, arr)) {
			System.out.print(x + " ");
		}
		System.out.println();
		for(int x : sol.solution2(n, k, arr)) {
			System.out.print(x + " ");
		}
	}
}
