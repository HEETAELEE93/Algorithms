package no3_twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class FindCommonElements {
	public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
		ArrayList<Integer> answer = new ArrayList<Integer>();

		int p1 = 0, p2 = 0;
		Arrays.sort(a);
		Arrays.sort(b);
		while (p1 < n && p2 < m) {
			if (a[p1] == b[p2]) {
				answer.add(a[p1++]);
				p2++;
			} else if (a[p1] < b[p2]) {
				p1++;
			} else if (a[p1] > b[p2]) {
				p2++;
			}
		}
		return answer;
	}
}

public class N02_FindCommonElements {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] a= new int[n];
//		for(int i = 0; i < n; i++) {		
//			a[i] = sc.nextInt();
//		}
//		
//		int m = sc.nextInt();
//		int[] b = new int[m];
//		for(int i = 0; i < m; i++) {
//			b[i] = sc.nextInt();
//		}

		int n = 5;
		int[] a = { 1, 3, 9, 5, 2 };
		int m = 5;
		int[] b = { 3, 2, 5, 7, 8 };

		FindCommonElements sol = new FindCommonElements();
		for (int x : sol.solution(n, m, a, b)) {
			System.out.print(x + " ");
		}
	}
}
