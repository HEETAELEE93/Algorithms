package no3_twoPointers;

import java.util.ArrayList;
import java.util.Scanner;

class CombineTwoArrays{
	public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		int arr1 = 0, arr2 = 0;
		
		for(int i = 0; i < n+m; i++) {
			if(arr1 == n) {
				answer.add(b[arr2]);
				arr2++;
				continue;
			}
			if(arr2 == m) {
				answer.add(a[arr1]);
				arr1++;
				continue;
			}
			if(a[arr1] < b[arr2]) {
				answer.add(a[arr1]);
				arr1++;
			} else {
				answer.add(b[arr2]);
				arr2++;
			}
		}
		
		return answer;
	}
	
	public ArrayList<Integer> solution2(int n, int m, int[] a, int[] b){
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		int p1 = 0, p2 = 0;
		while(p1 < n && p2 < m) {
			if(a[p1] < b[p2]) {
				answer.add(a[p1++]);
			} else {
				answer.add(b[p2++]);
			}
		}
		while(p1 < n) {
			answer.add(a[p1++]);
		}
		while(p2 < m) {
			answer.add(b[p2++]);
		}
		
		return answer;
	}
}

public class N01_CombineTwoArrays {
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
		int n = 3;
		int[] a = {1,3,5};
		int m = 5;
		int[] b = {2,3,6,7,9};
		
		CombineTwoArrays sol = new CombineTwoArrays();
		for(int x : sol.solution(n, m, a, b)) {
			System.out.print(x + " ");
		}
		System.out.println();
		for(int x : sol.solution2(n, m, a, b)) {
			System.out.print(x + " ");
		}
	}
}
