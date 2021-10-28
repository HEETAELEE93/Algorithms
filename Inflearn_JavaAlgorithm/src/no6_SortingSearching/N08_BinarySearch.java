package no6_SortingSearching;

import java.util.Arrays;
import java.util.Scanner;

class BinarySearch {
	public int solution(int n, int m, int[] arr) {
		int answer = 0;
		
		Arrays.sort(arr);
		answer = Arrays.binarySearch(arr, m);
		
		return ++answer;
	}
	
	public int solution2(int n, int m, int[] arr) {
		int answer = 1;
		Arrays.sort(arr);
		int lt = 0, rt = n - 1;
		while(lt <= rt) {
			int mid = (lt + rt)/2;
			if(arr[mid] == m) {
				answer += mid;
				break;
			}
			if(arr[mid] > m) {
				rt = mid - 1;
			} else {
				lt = mid + 1;
			}
		}
		
		return answer;
	}
}
public class N08_BinarySearch {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		int[] arr = new int[n];
//		for(int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
		
		int n = 8;
		int m = 32;
		int[] arr = {23,87,65,12,57,32,99,82};
		
		BinarySearch sol = new BinarySearch();
		System.out.println(sol.solution(n, m, arr));
		System.out.println(sol.solution2(n, m, arr));
	}
}
