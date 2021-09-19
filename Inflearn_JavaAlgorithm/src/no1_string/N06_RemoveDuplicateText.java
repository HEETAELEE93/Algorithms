package no1_string;

import java.util.Scanner;

class RemoveDuplicateText {
	public String solution (String str) {
		String answer = "";
		
		for(int i = 0; i < str.length(); i++) {
//			System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));
			if(str.indexOf(str.charAt(i)) == i) {
				answer += str.charAt(i);
			}
		}
		
		return answer;
	}
}

public class N06_RemoveDuplicateText {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
		String str = "ksekkset";
		RemoveDuplicateText sol = new RemoveDuplicateText();
		System.out.println(sol.solution(str));
	}
}
