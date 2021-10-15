package no5_StackQueue;

import java.util.Scanner;
import java.util.Stack;

class RemoveTextInParenthesis {
	public String solution(String str) {
		String answer = "";
		Stack<Character> stack = new Stack<Character>();
		
		for(char c : str.toCharArray()) {
			if(c == '(') {
				stack.push(c);
			} else if(c == ')') {
				stack.pop();
			} else {
				if(stack.isEmpty()) {
					answer += c;
				}
			}
		}
		return answer;
	}
	
	public String solution2(String str) {
		String answer = "";
		Stack<Character> stack = new Stack<Character>();
		
		for(char x : str.toCharArray()) {
			if(x == ')') {
				while(stack.pop() != '(');
			} else {
				stack.push(x);
			}
		}
		for(char x : stack) {
			answer += x;
		}
		return answer;
	}
}
public class N02_RemoveTextInParenthesis {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
		
		String str = "(A(BC)D)EF(G(H)(IJ)K)LM(N)";
		RemoveTextInParenthesis sol = new RemoveTextInParenthesis();
		System.out.println(sol.solution(str));
		System.out.println(sol.solution2(str));
	}
}
