package no1_string;

import java.util.Scanner;

class ReverseSpecificWord {
	public String solution (String str){
		String answer = "";
		
		char[] c = str.toCharArray();
		
		int lt = 0;
		int rt = str.length() - 1;
		
		while(lt < rt) {
			if(!Character.isAlphabetic(c[lt])) { // 알파벳 아닐 때
				lt++;
			} else if(!Character.isAlphabetic(c[rt])) {
				rt--;
			} else {
				char tmp = c[lt];
				c[lt] = c[rt];
				c[rt] = tmp;
				lt++; rt--;
			}
		}
		answer = String.valueOf(c);
		return answer;
	}
}

public class N05_ReverseSpecificWord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		ReverseSpecificWord sol = new ReverseSpecificWord();
		System.out.println(sol.solution(str));
	}
}
