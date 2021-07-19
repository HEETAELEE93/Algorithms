package sort;

import java.util.Arrays;

class MMergeSort{
	
	public int[] mergeSort(int[] A, int p, int r) {
		if(p < r) {
			int q = (p+r)/2;
			mergeSort(A, p, q);
			mergeSort(A, q+1, r);
			merge(A, p, q, r);
		}
		return A;
	}
	
	public int[] merge(int data[], int p, int q, int r){
		int i = p;
		int j = q+1;
		int k = p;
		int[] tmp = new int[data.length];
		
		while(i <= q && j <= r) {
			if(data[i] <= data[j]) {
				tmp[k++] = data[i++];
			} else {
				tmp[k++] = data[j++];
			}
		}
		while(i <= q) {
			tmp[k++] = data[i++];
		}
		while(j <= r) {
			tmp[k++] = data[j++];
		}
		for(int z = p; z <= r; z++) {
			data[i] = tmp[i];
		}
		
		return data;
	}
}

public class MyMergeSort {
	public static void main(String[] args) {
		MMergeSort MS = new MMergeSort();
		int[] A = {3, 5, 2, 4, 1, 6};
		System.out.println(Arrays.toString(MS.mergeSort(A, 0, 5)));
	}
}
