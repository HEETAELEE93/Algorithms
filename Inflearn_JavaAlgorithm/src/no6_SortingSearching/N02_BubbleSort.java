package no6_SortingSearching;

import java.util.Scanner;

class BubbleSort {
	public int[] solution(int n, int[] arr) {
		
		for(int i = 0; i < n - 1; i++) {
			int cnt = 0;
			for(int j = 0; j < n - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					cnt++;
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
			if(cnt == 0) {
				break;
			}
		}
		
		return arr;
	}
}

public class N02_BubbleSort {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] arr = new int[n];
//		for(int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
		
		int n = 6;
		int[] arr = {13, 5, 11, 7, 23, 15};
		
		BubbleSort sol = new BubbleSort();
		for(int x : sol.solution(n, arr)) {
			System.out.print(x + " ");
		}
	}

}
