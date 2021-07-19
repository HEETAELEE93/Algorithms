package string;

import java.util.Arrays;

class PlusOne {
	public int[] solve(int[] k) {
		
		int n = k.length;
		
		for(int i = n-1; i >= 0; i--) {
			k[i]++;
			if(k[i] < 10) {
				return k;
			}
			k[i] = 0;
		}
		
		int[] result = new int[n+1];
		result[0] = 1;
		
		return result;
	}
}

public class No05_PlusOne {
	public static void main(String[] args) {
		int[] k = {9,9,9};
		PlusOne sol = new PlusOne();
		System.out.println(Arrays.toString(sol.solve(k)));
	}
}
