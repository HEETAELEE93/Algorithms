package no2_array;

import java.util.Arrays;
import java.util.Scanner;

class MakeRanking{
	public int[] solution(int n, int[] arr) {
		int[] answer = new int[n];
		
		for(int i = 0; i < n; i++) {
			answer[i] = 1;
			for(int j = 0; j < n; j++) {
				if(arr[i] < arr[j]) {
					answer[i]++;
				}
			}
		}
		
		return answer;
	}
}
public class N08_MakeRanking {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] arr = new int[n];
//		for(int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
		
		int n = 5;
		int[] arr = {92, 89, 92, 100, 76};
		
		MakeRanking sol = new MakeRanking();
		for(int x : sol.solution(n, arr)) {
			System.out.print(x + " ");
		}
	}
}
