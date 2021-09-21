package no1_string;

import java.util.Scanner;

class ExtractNumberOnly {
	public int solution (String str) {
		int answer = 0;
		for(char c : str.toCharArray()) {
			if( c >= 48 && c <= 57) {
				answer = answer * 10 + (c - 48);
			}
		}
		return answer;
	}
	
	public int solution2 (String str) {
		String answer = "";
		
		for(char c : str.toCharArray()) {
			if(Character.isDigit(c)) {
				answer += c;
			}
		}
		
		return Integer.parseInt( answer );
	}
}

public class N09_ExtractNumberOnly {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
		String str = "g0en2T0s8eSoft";
		ExtractNumberOnly sol = new ExtractNumberOnly();
		System.out.println(sol.solution(str));
		ExtractNumberOnly sol2 = new ExtractNumberOnly();
		System.out.println(sol2.solution2(str));
	}
}
