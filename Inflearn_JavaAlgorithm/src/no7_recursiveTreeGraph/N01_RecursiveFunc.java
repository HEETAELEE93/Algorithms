package no7_recursiveTreeGraph;

import java.util.Scanner;

class RecursiveFunc {
	public void DFS(int n) {
		if(n <= 0) {
			return;
		}
		DFS(n-1);
		System.out.print(n + " ");
	}
}

public class N01_RecursiveFunc {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		
		int n = 3;
		RecursiveFunc sol = new RecursiveFunc();
		sol.DFS(10);
	}
}
