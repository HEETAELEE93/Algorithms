package sort;

class MyQuickSort{
	public int partition(int[] a, int p, int pivot) {
		int x = a[pivot];
		int i = p - 1;
		for(int j = p; j < pivot - 1; j++) {
			if(a[j] <= x) {
				i += 1;
				swap(a, a[i], a[j]);
			}
		}
		swap(a, a[i+1], a[pivot]);
		return i + 1;
	}

	public void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
}


public class QuickSort {
	public static void main(String[] args) {

	}
}
