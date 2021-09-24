package no1_string;

import java.util.Scanner;

class PassCode {
	public String solution(int n, String s) {
		String answer = "";
		
		for(int i = 0; i < s.length(); i+=7) {
			String binaryNum = "";
			for(int j = i; j < i + 7; j++) {
				if(s.charAt(j) == '#') {
					binaryNum += "1";
				} else {
					binaryNum += "0";
				}
			}
			int decimal = Integer.parseInt(binaryNum, 2);
			answer += (char) decimal;
		}
		return answer;
	}
	
	public String solution2(int n, String s) {
		String answer = "";
		
		for(int i = 0; i < n; i++) {
			String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
			
			int num = Integer.parseInt(tmp, 2);
			answer += (char) num;
			s = s.substring(7);
		}
		
		return answer;
	}
}

public class N12_PassCode {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		String str = sc.next();
		
		int n = 4;
		String str = "#****###**#####**#####**##**";
		
		PassCode sol = new PassCode();
		System.out.println(sol.solution(n, str));
		System.out.println(sol.solution2(n, str));
	}
}
