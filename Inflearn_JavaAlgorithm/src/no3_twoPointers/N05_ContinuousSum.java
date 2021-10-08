package no3_twoPointers;

import java.util.Scanner;

class ContinuousSum {
	public int solution (int n) {
		int answer = 0;
		
		for(int i = 1; i <= n / 2 + 1; i++) {
			int sum = 0, j = i;
			while(sum < n) {
				if(j > n/2+1) {
					break;
				}
				sum += j;
				j++;
			}
			if(sum == n) {
				answer++;
			}
		}
		return answer;
	}
}

public class N05_ContinuousSum {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		
		int n = 15;
		ContinuousSum sol = new ContinuousSum();
		System.out.println(sol.solution(n));
	}
}
