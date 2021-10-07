package no3_twoPointers;

import java.util.Scanner;

class MaximumSales {
	public int solution(int n, int k, int[] arr) {
		int answer = 0;
		int tmp = 0;
		for(int i = 0; i < k; i++) {
			answer += arr[i];
		}
		tmp = answer;
		for(int i = k; i < n; i++) {
			tmp -= arr[i - k];
			tmp += arr[i];
			if(answer < tmp) {
				answer = tmp;
			}
		}
		return answer;
	}
}

public class N03_MaximumSales {
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
		int[] arr = { 12, 15, 11, 20, 25, 10, 20, 19, 13, 15 };

		MaximumSales sol = new MaximumSales();
		System.out.println(sol.solution(n, k, arr));
	}
}
