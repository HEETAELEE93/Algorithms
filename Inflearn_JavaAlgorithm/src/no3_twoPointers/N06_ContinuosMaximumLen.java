package no3_twoPointers;

import java.util.Scanner;

class ContinuousMaximumLen {
	public int solution(int n, int k, int[] arr) {
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			int cnt = 0, max = 0, j = i;
			while(cnt <= k) {
				if(j >= n) {
					break;
				}
				if(arr[j] == 0) {
					cnt++;
					if(cnt > k) {
						break;
					}
				}
				max++;
				j++;
			}
			if(answer < max) {
				answer = max;
				if(j == n) {
					break;
				}
			}
		}
		return answer;
	}
	
	public int solution2(int n, int k, int[] arr) {
		int answer = 0;
		int lt = 0, cnt = 0, sum = 0;
		
		for(int rt = 0; rt < n; rt++) {
			if(arr[rt] == 1) {
				sum++;
			} else {
				cnt++;
				sum++;
				while(cnt > k) {
					if(arr[lt] == 1) {
						lt++;
						sum--;
					} else {
						sum--;
						lt++;
						cnt--;
					}
				}
			}
			answer = Math.max(answer, sum);
		}
		return answer;
	}
	
	public int solution3(int n, int k, int[] arr) {
		int answer = 0;
		int cnt = 0, lt = 0;
		
		for(int rt = 0; rt < n; rt++) {
			if(arr[rt] == 0) {
				cnt++;
			}
			while(cnt > k) {
				if(arr[lt] == 0) {
					cnt--;
				}
				lt++;
			}
			answer = Math.max(answer, rt - lt + 1);
		}
		return answer;
	}
}

public class N06_ContinuosMaximumLen {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int k = sc.nextInt();
//		int[] arr = new int[n];
//		for(int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
		int n = 14;
		int k = 2;
		int[] arr = { 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 };

		ContinuousMaximumLen sol = new ContinuousMaximumLen();
		System.out.println(sol.solution(n, k, arr));
		System.out.println(sol.solution2(n, k, arr));
		System.out.println(sol.solution3(n, k, arr));
	}
}
