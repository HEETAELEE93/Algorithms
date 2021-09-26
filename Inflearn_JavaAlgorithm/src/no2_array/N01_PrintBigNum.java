package no2_array;

import java.util.ArrayList;
import java.util.Scanner;

class PrintBigNum {
	public ArrayList<Integer> solution (int n, int[] arr){
		ArrayList<Integer> answer = new ArrayList<Integer>();
		answer.add(arr[0]);
		for(int i = 0; i < n - 1; i++) {
			if(arr[i] < arr[i+1]) {
				answer.add(arr[i+1]);
			}
		}
		
		return answer;
	}
	public ArrayList<Integer> solution2 (int n, int[] arr){
		ArrayList<Integer> answer = new ArrayList<Integer>();
		answer.add(arr[0]);
		
		for(int i = 1; i < n; i++) {
			if(arr[i] > arr[i-1]) {
				answer.add(arr[i]);
			}
		}
		
		return answer;
	}
}

public class N01_PrintBigNum {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] arr = new int[n];
//		for(int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
		
		int n = 6;
		int[] arr = {7, 3, 9, 5, 6, 12};
		
		PrintBigNum sol = new PrintBigNum();
		for(int x : sol.solution(n, arr)) {
			System.out.print(x + " ");
		}
		System.out.println();
		for(int x : sol.solution2(n, arr)) {
			System.out.print(x + " ");
		}
	}
}
