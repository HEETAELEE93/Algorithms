package stringArray.no14findAnagramsMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution{
	public int[] anagramMapping(int[] A, int[] B) {
		double start = System.nanoTime();
		
		int[] result = new int[A.length];
		
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < A.length; i++) {
			hm.put(B[i], i);
		}
		
		for(int i = 0; i < A.length; i++) {
			result[i] = hm.get(A[i]);
		}
		
		double end = System.nanoTime();
		System.out.println("실행 시간 : " + ( end - start ) / 1000.0);
		
		return result;
	}
}

class MySolution{
	public int[] anagramMapping(int[] A, int[] B) {
		double start = System.nanoTime();
		int[] result = new int[A.length];

		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < B.length; j++) {
				if(A[i] == B[j]) {
					result[i] = j;
					break;
				}
			}
		}
		double end = System.nanoTime();
		System.out.println("실행 시간 : " + ( end - start ) / 1000.0);
		return result;
	}
}

public class FindAnagramsMapping {
	public static void main(String[] args) {
		int[] A = {12, 28, 46, 32, 50};
		int[] B = {50, 12, 32, 46, 28};
		
//		int[] A = {12, 28, 46, 32, 50, 43, 90, 15, 37, 24, 99, 57};
//		int[] B = {50, 15, 24, 12, 43, 32, 37, 46, 99, 90, 28, 57};
		
		Solution s = new Solution();
		MySolution ms = new MySolution();
		System.out.println(Arrays.toString(s.anagramMapping(A, B)));
		System.out.println("=========");
		System.out.println(Arrays.toString(ms.anagramMapping(A, B)));
	}
}
