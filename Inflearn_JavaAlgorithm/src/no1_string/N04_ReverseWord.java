package no1_string;

import java.util.ArrayList;
import java.util.Scanner;

class ReverseWord{
	public ArrayList<String> solution (int n, String[] str){
		ArrayList<String> answer = new ArrayList<String>();
		
		for(String x : str) {
			String tmp = new StringBuilder(x).reverse().toString();
			answer.add(tmp);
		}
		
		return answer;
	}
	
	public ArrayList<String> solution2 (int n, String[] str){
		ArrayList<String> answer = new ArrayList<String>();
		
		for(String x : str) {
			char[] c = x.toCharArray();
			int lt = 0;
			int rt = x.length() - 1;
			while(lt <= rt) {
				char tmp = c[lt];
				c[lt] = c[rt];
				c[rt] = tmp;
				lt++; rt--;
			}
			String tmp = String.valueOf(c);
			answer.add(tmp);
		}
		
		return answer;
	}
}

public class N04_ReverseWord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String[] str = new String[n];
		for(int i = 0; i < n; i++) {
			str[i] = sc.next();
		}
		
		ReverseWord sol = new ReverseWord();
		for(String x : sol.solution(n, str)) {
			System.out.println(x);
		}
		System.out.println(sol.solution2(n, str));
		
	}
}
