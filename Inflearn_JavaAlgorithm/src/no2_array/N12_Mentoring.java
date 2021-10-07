package no2_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Mentoring {
	public int solution(int n, int m, int[][] arr) {
		List<int[]> list = new ArrayList<int[]>();
		
		for (int i = 1; i <= n; i++) {	// 사람
			for (int j = 1; j <= n; j++) {	// 사람
				if (i != j) {
					int cnt = 0;
					for (int k = 0; k < m; k++) {	// 시험
						int pi = 0, pj = 0;
						for (int s = 0; s < n; s++) { // 등수
							if (arr[k][s] == i)
								pi = s;
							if (arr[k][s] == j)
								pj = s;
						}
						if (pi < pj) {
							cnt++;
						} else {
							break;
						}
					}
					if (cnt == m) {
						int[] nums = {i, j};
						list.add(nums);
					}
				}
			}
		}

		return list.size();
	}
}

public class N12_Mentoring {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		int[][] arr = new int[m][n];
//		for(int i = 0; i < m; i++) {
//			for(int j = 0; j < n; j++) {
//				arr[i][j] = sc.nextInt();
//			}
//		}
		
		int n = 4;	// n명의 학생
		int m = 3;	// m번의 시험
		int[][] arr = {
				{3,4,1,2},
				{4,3,2,1},
				{3,1,4,2}
		};
		Mentoring sol = new Mentoring();
		System.out.println(sol.solution(n, m, arr));
		
	}
}
