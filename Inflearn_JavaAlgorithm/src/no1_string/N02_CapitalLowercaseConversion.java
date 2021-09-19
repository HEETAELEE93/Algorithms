package no1_string;

import java.util.Scanner;

class CapitalLoswercaseConversion{
	public String solution (String str) {
		String answer = "";
		for(char c : str.toCharArray()) {
			if( c >= 65 && c <= 90 ) { // 대문자
				answer += Character.toLowerCase(c);
			} else {
				answer += Character.toUpperCase(c);
			}
		}
		return answer;
	}
	
	public String solution2 (String str) {
		String answer = "";
		
		for(char c : str.toCharArray()) {
			if(Character.isUpperCase(c)) { // 대문자
				answer += Character.toLowerCase(c);
			} else {
				answer += Character.toUpperCase(c);
			}
		}
		
		return answer;
	}
}

public class N02_CapitalLowercaseConversion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    String str = in.next();
	    
	    CapitalLoswercaseConversion sol = new CapitalLoswercaseConversion();
	    System.out.println(sol.solution(str));
	}
}
