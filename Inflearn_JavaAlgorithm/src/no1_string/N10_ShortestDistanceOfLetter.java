package no1_string;

import java.util.Arrays;
import java.util.Scanner;

class ShortestDistanceOfLetter {
	public int[] mySolution(String s, char t) {
		int[] answer = new int[s.length()];
		
		int[] left = new int[s.length()];
		int[] right = new int[s.length()];
		
		int tmp = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == t) {
				tmp = i;
				left[i] = 0;
				continue;
			} else {
				left[i] = i - tmp;
			}
		}
		tmp = s.length() - 1;
		for(int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) == t) {
				tmp = i;
				right[i] = 0;
				continue;
			} else {
				right[i] = tmp - i;
			}
		}
		
		int whereFirst = s.indexOf(t);
		int whereLast = s.lastIndexOf(t);
		
		for(int i = 0; i < s.length(); i++) {
			if(i < whereFirst) {
				answer[i] = right[i];
			} else if( i > whereLast) {
				answer[i] = left[i];
			} else {
				answer[i] = Math.min(left[i], right[i]);
			}
			
		}
		
		return answer;
	}
	
	public int[] solution(String s, char t) {
		int[] answer = new int[s.length()];
		
		int p = 1000;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == t) {
				p = 0;
				answer[i] = p;
			} else {
				p++;
				answer[i] = p;
			}
		}
		p = 1000;
		for(int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) == t) {
				p = 0;
			} else {
				p++;
				answer[i] = Math.min(answer[i], p);
			}
		}
		
		return answer;
	}
}

public class N10_ShortestDistanceOfLetter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char c = sc.next().charAt(0);
//		String str = "teachermode e";
		ShortestDistanceOfLetter sol = new ShortestDistanceOfLetter();
		for(int x : sol.mySolution(str, c)) {
			System.out.print(x + " ");
		}
		System.out.println();
		for(int x : sol.solution(str, c)) {
			System.out.print(x + " ");
		}
	}
}
