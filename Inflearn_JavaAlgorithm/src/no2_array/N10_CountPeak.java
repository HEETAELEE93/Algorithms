package no2_array;

import java.util.Scanner;

class CountPeak {
	public int solution(int n, int[][] arr) {
		int answer = 0;
		
		
		return answer;
	}
}
public class N10_CountPeak {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[][] arr = new int[n][n];
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				arr[i][j] = sc.nextInt();
//			}
//		}
		
		int n = 5;
		int[][] arr = {
				{5, 3, 7, 2, 3},
				{3, 7, 1, 6, 1},
				{7, 2, 5, 3, 4},
				{4, 3, 6, 4, 1},
				{8, 7, 3, 5, 2}
		};
		CountPeak sol = new CountPeak();
		System.out.println(sol.solution(n, arr));
	}
}
