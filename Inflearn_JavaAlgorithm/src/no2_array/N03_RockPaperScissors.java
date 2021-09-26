package no2_array;

import java.util.Scanner;

class RockPaperScissors {
	public String solution(int n, int[] a, int[] b) {
		String answer = "";
		// 1: 가위 2: 바위 3: 보
		for(int i = 0; i < n; i++) {
			if(a[i] == b[i]) {
				answer += "D";
			} else if(a[i] == 1 && b[i] == 3) {
				answer += "A";
			} else if(a[i] == 2 && b[i] == 1) {
				answer += "A";
			} else if(a[i] == 3 && b[i] == 2) {
				answer += "A";
			} else {
				answer += "B";
			}
		}
		
		return answer;
	}
}

public class N03_RockPaperScissors {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] a = new int[n];
//		int[] b = new int[n];
//		for(int i = 0; i < n; i++) {
//			a[i] = sc.nextInt();
//		}
//		for(int i = 0; i < n; i++) {
//			b[i] = sc.nextInt();
//		}
		
		int n = 5;
		int[] a = {2,3,3,1,3};
		int[] b = {1,1,2,2,3};
		
		RockPaperScissors sol = new RockPaperScissors();
		for(char c : sol.solution(n, a, b).toCharArray()) {
			System.out.println(c);
		}
	}
}
