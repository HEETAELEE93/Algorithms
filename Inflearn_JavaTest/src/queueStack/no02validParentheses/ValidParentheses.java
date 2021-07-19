package queueStack.no02validParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
	public boolean isValid(String s) {
		if(s.length()%2 != 0) {
			return false;
		}
		
		Stack<Character> st = new Stack<Character>();
		
		for(char i : s.toCharArray()) {
			switch (i) {
			case ')':
				if(!st.empty() && st.peek() == '(') {
					st.pop();
				}
				break;
			case ']':
				if(!st.empty() && st.peek() == '[') {
					st.pop();
				}
				break;
			case '}':
				if(!st.empty() && st.peek() == '{') {
					st.pop();
				}
				break;
			default:
				st.push(i);
				break;
			}
		}
		
		return st.empty();
	 }
}

class MySolution {
	public boolean isValid(String s) {
		if(s.length()%2 != 0) {
			return false;
		}
		Stack<Character> st = new Stack<Character>();
		Map<Character, Character> hm = new HashMap<Character, Character>();
		
		hm.put('(', ')');
		hm.put('[', ']');
		hm.put('{', '}');
		
		for(char a : s.toCharArray()) {
			switch (a) {
			case '(':
				st.push(a);
				break;
			case '[':
				st.push(a);
				break;
			case '{':
				st.push(a);
				break;
			default:
				if(hm.get(st.peek()) == a ) {
					st.pop();
				} else {
					return false;
				}
				break;
			}
		}
		return true;
	 }
}

public class ValidParentheses {
	public static void main(String[] args) {
		String s = "{[]}";
		String s1 = "(]";
		String s2 = "([)]";
		String s3 = "(){}[]";
		
		Solution so = new Solution();
		System.out.println(so.isValid(s));
		
		MySolution ms = new MySolution();
		System.out.println(ms.isValid(s));
	}
}
