package no6_SortingSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class MischievousPerson{
	// 틀림
	public ArrayList<Integer> solution(int n, int[] arr){
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for(int i = 1; i < n; i++) {
			if(arr[i-1] > arr[i]) {
				if(answer.isEmpty()) {
					answer.add(i);
				} else {
					answer.add(i + 1);
				}
			}
		}
		return answer;
	}
	public ArrayList<Integer> solution2(int n, int[] arr){
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		int[] tmp = arr.clone(); // 깊은 복사
		Arrays.sort(tmp);
		for(int i = 0; i < n; i++) {
			if(arr[i] != tmp[i]) {
				answer.add(i+1);
			}
		}
		
		return answer;
	}
}

public class N06_MischievousPerson {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] arr = new int[n];
//		for(int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
		
		int n = 9;
		int[] arr = {120,125,152,130,135,135,143,127,160};
		
		MischievousPerson sol = new MischievousPerson();
		for(int x : sol.solution(n, arr)) {
			System.out.print(x + " ");
		}
		System.out.println();
		for(int x : sol.solution2(n, arr)) {
			System.out.print(x + " ");
		}
	}
}
