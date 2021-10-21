package no6_SortingSearching;

import java.util.Scanner;

class InsertionSort {
	public int[] solution(int n, int[] arr) {
		for(int i = 1; i < n; i++) {
			int tmp = arr[i];
			int j;
			for(j = i - 1; j >= 0; j--) {
				if(tmp < arr[j]) {
					arr[j+1] = arr[j];
				} else {
					break;
				}
			}
			arr[j+1] = tmp;
		}
		
		return arr;
	}
}
public class N03_InsertionSort {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] arr = new int[n];
//		for(int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
		
		int n = 6;
		int[] arr = {11,7,5,6,10,9};
		
		InsertionSort sol = new InsertionSort();
		for(int x : sol.solution(n, arr)) {
			System.out.print(x + " ");
		}
	}
}
