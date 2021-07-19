package sort;

import java.util.Arrays;

public class MySelectionSort {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void mySelectionSort(int[] a) {
		for(int i = 0; i < a.length; i++) {
			int min = i;
			for(int j = i+1; j < a.length; j++) {
				if(a[j] < a[min]) {
					min = j;
				}
			}
			swap(a, i, min);
		}
		System.out.println(Arrays.toString(a));
	}
	
	public static void main(String[] args) {
		int[] a = {3,2,1,4,5};
		mySelectionSort(a);
	}

}
