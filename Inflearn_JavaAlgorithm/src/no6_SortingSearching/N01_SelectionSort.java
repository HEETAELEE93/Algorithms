package no6_SortingSearching;

import java.util.Scanner;

class SelectionSort{
	public int[] solution(int n, int[] arr) {
		for(int i = 0; i < n - 1; i++) {
			int idx = i;
			for(int j = i+1; j < n; j++) {
				if(arr[idx] > arr[j]) {
					idx = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		return arr;
	}
}
public class N01_SelectionSort {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] arr = new int[n];
//		for(int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
		
		int n = 6;
		int[] arr = {13, 5, 11, 7, 23, 15};
		
		SelectionSort sol = new SelectionSort();
		for(int x : sol.solution(n, arr)) {
			System.out.print(x + " ");
		}
	}
}
