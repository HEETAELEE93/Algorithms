package no1_string;

import java.util.Scanner;

class wordinSentence{
	public String solution (String str) {
		String answer = "";
		int m = Integer.MIN_VALUE;
		
		String[] sArr = str.split(" ");
		
		for(String s : sArr) {
			int len = s.length();
			if(len > m) {
				m = len;
				answer = s;
			}
		}
		
		return answer;
	}
	
	public String solution2 (String str) {
		String answer = "";
		int m = Integer.MIN_VALUE, pos;
		
		while((pos = str.indexOf(' ')) != -1) {
			String tmp = str.substring(0, pos);
			int len = tmp.length();
			if(len > m) {
				m = len;
				answer = tmp;
			}
			str = str.substring(pos + 1);
		}
		
		if(str.length() > m) {
			answer = str;
		}
		
		return answer;
	}
	
}

public class N03_wordInTheSentence {
	public static void main(String[] args) {
		Scanner sc = new java.util.Scanner(System.in);
		String str = sc.nextLine();
		wordinSentence sol = new wordinSentence();
		System.out.println(sol.solution(str));
	}
}
