package no4_MapSet;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class KthBiggestNumber {
	public int solution(int[] arr, int n, int k) {
		// 문제가 연속된 3자리를 더하고 더한 값들 중 k번째를 뽑아야함
		int answer = 0;
		
		TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
		
		for(int x : arr) {
			set.add(x);
		}
		for(int i = 0; i < k; i++) {
			answer += set.pollFirst();
		}
		return answer;
	}
	
	public int solution2(int[] arr, int n, int k) {
		int answer = -1;
		TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				for(int l = j + 1; l < n; l++) {
					set.add(arr[i] + arr[j] + arr[l]);
				}
			}
		}
		int cnt = 0;
		for(int x : set) {
			cnt++;
			if(cnt == k) {
				return x;
			}
		}
		return answer;
	}
}
public class N05_KthBiggestNumber {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int k = sc.nextInt();
//		int[] arr = new int[n];
//		for(int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
		
		int n = 10;
		int k = 3;
		int[] arr = {13, 15, 34, 23, 45, 65, 33, 11, 26, 42};
		KthBiggestNumber sol = new KthBiggestNumber();
		System.out.println(sol.solution(arr, n, k));
		System.out.println(sol.solution2(arr, n, k));
	}
}
