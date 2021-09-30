package no2_array;

import java.util.Scanner;

class PrimeNumber{
	public int solution(int n) {
		int answer = 0;
		int[] ch = new int[n+1];
		for(int i = 2; i <= n; i++) {
			if(ch[i] == 0) {
				answer++;
				for(int j = i; j <= n; j = j+i) {
					ch[j] = 1;
				}
			}
		}
		return answer;
	}
}

public class N05_PrimeNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PrimeNumber sol = new PrimeNumber();
		System.out.println(sol.solution(n));
	}
}
