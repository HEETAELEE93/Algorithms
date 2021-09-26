package no2_array;

import java.util.Scanner;

class CanSeeStudent {
	public int solution (int n, int[] arr) {
		int answer = 1;
		int max = arr[0];
		for(int i = 1; i < n; i++) {
			if(arr[i] > max) {
				answer++;
				max = arr[i];
			}
		}
		
		return answer;
	}
	
	public int solution2(int n, int[] arr) {
		int answer = 0;
		
		
		
		return answer;
	}
}

public class N02_CanSeeStudent {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] arr = new int[n];
//		for(int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
		
		int n = 8;
		int[] arr = {130, 135, 148, 140, 145, 150, 150, 153};
		
		CanSeeStudent sol = new CanSeeStudent();
		System.out.println(sol.solution(n, arr));
		System.out.println(sol.solution2(n, arr));
	}
}
