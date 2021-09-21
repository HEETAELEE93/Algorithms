package no1_string;

import java.util.Scanner;

class StringCompression{
	public String solution(String s) {
		String answer = "";
		
		s = s + " ";
		int cnt = 1;
		
		for(int i = 0; i < s.length() - 1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				cnt++;
			} else {
				answer += s.charAt(i);
				if(cnt > 1) {
					answer += String.valueOf(cnt);
				}
				cnt = 1;
			}
		}
		return answer;
	}
}

public class N11_StringCompression {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
		String str = "KKHSSSSSSSE";
		StringCompression sol = new StringCompression();
		System.out.println(sol.solution(str));
	}
}
