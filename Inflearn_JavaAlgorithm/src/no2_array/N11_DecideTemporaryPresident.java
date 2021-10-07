package no2_array;

import java.util.Scanner;

class DecideTemporaryPresident {
	public int solution(int n, int[][] arr) {
		int answer = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i <= n; i++) {
			int cnt = 0;
			for(int j = 1; j <= n; j++) {
				for(int k = 1; k <= 5; k++) {
					if(arr[i][k] == arr[j][k]) {
						cnt++;
						break;
					}
				}
			}
			
			if(cnt > max) {
				max = cnt;
				answer = i;
			}
		}
		return answer;
	}
}

public class N11_DecideTemporaryPresident {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[][] arr = new int[n + 1][6];
//		for(int i = 1; i <= n; i++) {
//			for(int j = 1; j <= 5; j++) {
//				arr[i][j] = sc.nextInt();
//			}
//		}
		
		int n = 5;
		int[][] arr = {
				{0, 0, 0, 0, 0, 0},
				{0, 2, 3, 1, 7, 3},
				{0, 4, 1, 9, 6, 8},
				{0, 5, 5, 2, 4, 4},
				{0, 6, 5, 2, 6, 7},
				{0, 8, 4, 2, 2, 2}
		};
		
		DecideTemporaryPresident sol = new DecideTemporaryPresident();
		System.out.println(sol.solution(n, arr));
		
	}
}
