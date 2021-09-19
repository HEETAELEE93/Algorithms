package no1_string;

import java.util.Scanner;

class FindChar {
	public int solution(String str, char t) {
		int answer = 0;
		
		str = str.toUpperCase();
		t = Character.toUpperCase(t);
		
		for(char c : str.toCharArray()) {
			if(c == t) {
				answer++;
			}
		}
		return answer;
	}
}

public class No01_FindChar {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    String str = in.next();
	    char c = in.next().charAt(0);
	    
	    FindChar sol = new FindChar();
	    
	    System.out.println(sol.solution(str, c));
	    return ;
	}
}
