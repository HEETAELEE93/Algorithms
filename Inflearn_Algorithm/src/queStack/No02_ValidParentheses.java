package queStack;

import java.util.Stack;

class ValidParentheses{
	public boolean solve(String str) {
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
				stack.push(str.charAt(i));
			} else if(str.charAt(i) == ')' && !stack.empty() && stack.peek() == '(' ) {
				stack.pop();
			} else if(str.charAt(i) == ']' && !stack.empty() && stack.peek() == '[' ) {
				stack.pop();
			} else if(str.charAt(i) == '}' && !stack.empty() && stack.peek() == '{' ) {
				stack.pop();
			} else {
				return false;
			}
		}
		
		return stack.isEmpty();
	}
}

public class No02_ValidParentheses {
	public static void main(String[] args) {
		String str1 = "()[]{}";
		String str2 = ")[]";
		ValidParentheses sol = new ValidParentheses();
		System.out.println(sol.solve(str1));
		System.out.println(sol.solve(str2));
	}
}
