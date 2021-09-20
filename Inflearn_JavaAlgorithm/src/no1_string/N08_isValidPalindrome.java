package no1_string;

import java.util.Scanner;

class isValidPalindrome {
	public String solution (String str) {
		String answer = "NO";
		
		str = str.toUpperCase().replaceAll("[^A-Z]", "");
		
		String tmp = new StringBuilder(str).reverse().toString();
		
		if(str.equals(tmp)) {
			return "YES";
		}
		
		return answer;
	}
}

public class N08_isValidPalindrome {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.nextLine();
		String str = "found7, time: study; Yduts; emit, 7Dnuof";
		isValidPalindrome sol = new isValidPalindrome();
		System.out.println(sol.solution(str));
	}
}
