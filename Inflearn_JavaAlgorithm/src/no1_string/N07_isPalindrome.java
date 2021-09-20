package no1_string;

import java.util.Scanner;

class isPalindrom {
	public String solution (String str) {
		String answer = "YES";
		str = str.toLowerCase();
		int len = str.length();
		
		for(int i = 0; i < len/2; i++) {
			if(str.charAt(i) != str.charAt( len - i - 1)) {
				return "NO";
			}
		}
		
		return answer;
	}
	
	public String solution2 (String str) {
		String answer = "NO";
		
		String tmp = new StringBuilder(str).reverse().toString();
		
		if(str.equalsIgnoreCase(tmp)) {
			return "YES";
		}
		
		return answer;
	}
}

public class N07_isPalindrome {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
		String str = "gooG";
		isPalindrom sol = new isPalindrom();
		System.out.println(sol.solution(str));
		System.out.println(sol.solution2(str));
	}
}
