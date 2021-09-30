package no2_array;

import java.util.Scanner;

class Fibonacci {
	public int[] solution(int n) {
		int[] answer = new int[n];
		
		answer[0] = 1;
		answer[1] = 1;
		
		for(int i = 2; i < n; i++) {
			answer[i] = answer[i-1] + answer[i-2];
		}
		
		return answer;
	}
	
	public void solution2(int n) {
		int a = 1;
		int b = 1;
		int c;
		System.out.print(a + " " + b + " ");
		for(int i = 2; i < n; i++) {
			c = a + b;
			System.out.print(c + " ");
			a = b;
			b = c;
		}
	}
}

public class N04_Fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Fibonacci sol = new Fibonacci();
		for(int x :sol.solution(n)) {
			System.out.print(x + " ");
		}
		System.out.println();
		sol.solution2(n);
	}
}
