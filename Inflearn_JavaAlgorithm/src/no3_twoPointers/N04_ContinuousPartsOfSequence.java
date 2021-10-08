package no3_twoPointers;

import java.util.Scanner;

class ContinuousPartsOfSequence {
	public int solution(int n, int m, int[] arr) {
		int answer = 0;
		
		loop:for(int i = 0; i < n; i++) {
			int sum = 0, j = i;
			while(sum < m) {
				if(j >= n) {
					break loop;
				}
				sum += arr[j];
				j++;
			}
			if(sum == m) {
				answer++;
			}
		}
		return answer;
	}
	
	public int solution2(int n, int m, int[] arr) {
		int answer = 0;
		int lt = 0, sum = 0;
		
		for(int rt = 0; rt < n; rt++) {
			sum += arr[rt];
			if(sum == m) {
				answer++;
			}
			while(sum >= m) {
				sum -= arr[lt++];
				if(sum == m) {
					answer++;
				}
			}
		}
		return answer;
	}
}

public class N04_ContinuousPartsOfSequence {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		int[] arr = new int[n];
//		for(int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}

		int n = 8;
		int m = 6;
		int[] arr = { 1, 2, 1, 3, 1, 1, 1, 2 };

		ContinuousPartsOfSequence sol = new ContinuousPartsOfSequence();
		System.out.println(sol.solution(n, m, arr));
		System.out.println(sol.solution2(n, m, arr));
	}
}
