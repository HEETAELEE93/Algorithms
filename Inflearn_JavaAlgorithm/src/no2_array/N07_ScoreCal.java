package no2_array;

import java.util.Scanner;

class ScoreCal {
	public int solution(int n, int[] arr) {
		int answer = 0;
		
		int cnt = 0;
		if(arr[0] == 1) {
			cnt++;
			answer++;
		}
		for(int i = 1; i < n; i++) {
			if(arr[i] == 1 && cnt != 0) {
				cnt++;
				answer += cnt;
			} else if(arr[i] == 1 && cnt == 0) {
				answer++;
				cnt++;
			} else {
				cnt = 0;
			}
		}
		return answer;
	}
	public int solution2(int n, int[] arr) {
		int answer = 0;
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			if(arr[i] == 1) {
				cnt++;
				answer += cnt;
			} else {
				cnt = 0;
			}
		}
		return answer;
	}
}

public class N07_ScoreCal {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] arr = new int[n];
//		for(int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
		int n = 10;
		int[] arr = {1, 0, 1, 1, 1, 0, 0, 1, 1, 0};
		ScoreCal sol = new ScoreCal();
		System.out.println(sol.solution(n, arr));
		System.out.println(sol.solution2(n, arr));
	}
}
