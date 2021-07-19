package queueStack.no01baseballGame;

import java.util.Stack;

class Solution{
	public int calPoints(String[] strs) {
		int result = 0;
		Stack<Integer> st = new Stack<Integer>();
		
		for(String op : strs) {
			switch (op) {
			case "C":
				st.pop();
				break;
			case "D":
				st.push(st.peek() * 2);
				break;
			case "+":
				int x = st.pop();
				int y = st.peek();
				st.push(x);
				st.push(x + y);
				break;
			default:
				st.push(Integer.parseInt(op));
				break;
			}
		}
		
		while(!st.isEmpty()) {
			result += st.pop();
		}
		
		return result;
	}
}

class MySolution{
	public int calPoints(String[] ops) {
		int result = 0;
		Stack<Integer> st = new Stack<Integer>();
		
		for(String i : ops) {
			if(isNum(i)) {
				st.push(Integer.parseInt(i));
			} else if(i == "C") {
				st.pop();
			} else if(i == "D")	{
				st.push(st.peek() * 2);
			} else if(i == "+") {
				int pop = st.pop();
				int pop2 = st.peek();
				st.push(pop);
				st.push(pop + pop2);
			}
		}
		while(!st.isEmpty()) {
			result += st.pop();
		}
		return result;
	}

	private boolean isNum(String i) {
		try {
			Double.parseDouble(i);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}

public class BaseballGame {
	public static void main(String[] args) {
		String[] strs = {"5","-2","4","C","D","9","+","+"};
		Solution s = new Solution();
		System.out.println(s.calPoints(strs));
		
		MySolution ms = new MySolution();
		System.out.println(ms.calPoints(strs));
	}
}
