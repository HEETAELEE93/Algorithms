package no5_StackQueue;

import java.util.Scanner;
import java.util.Stack;

class CorrectParenthesis {
	public String solution(String str) {
		String answer = "YES";
		Stack<Character> stack = new Stack<Character>();
		for(char c : str.toCharArray()) {
			if(c == '(') {
				stack.push(c);
			} else {
				if(!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else {
					return "NO";
				}
			}
		}
		if(!stack.isEmpty()) {
			return "NO";
		}
		return answer;
	}
	
	public String solution2(String str) {
		String answer = "YES";
		Stack<Character> stack = new Stack<Character>();
		for(char x : str.toCharArray()) {
			if(x == '(') stack.push(x);
			else {
				if(stack.isEmpty()) 
					return "NO";
				stack.pop();
			}
		}
		if(!stack.isEmpty()) {
			return "NO";
		}
		return answer;
	}
}

public class N01_CorrectParenthesis {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
		
		String str = "(()(()))(()";
		CorrectParenthesis sol = new CorrectParenthesis();
		System.out.println(sol.solution(str));
		System.out.println(sol.solution2(str));
	}
}
