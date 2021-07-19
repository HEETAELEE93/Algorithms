package queStack;

import java.util.Stack;

class BaseballGame {
	public int solve(String[] strs) {
		Stack<Integer> stack = new Stack<Integer>();

		for (String op : strs) {
			switch (op) {
			case "C":
				stack.pop();
				break;
			case "D":
				stack.push(stack.peek() * 2);
				break;
			case "+":
				int x = stack.pop();
				int y = stack.peek();
				int z = x + y;
				stack.push(x);
				stack.push(z);
				break;
			default:
				stack.push(Integer.valueOf(op));
			}
		}
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		return sum;
	}
}

public class No01_BaseballGame {
	public static void main(String[] args) {
		String[] strs = { "5", "-2", "4", "C", "D", "9", "+", "+" };
		BaseballGame sol = new BaseballGame();
		System.out.println(sol.solve(strs));
	}
}
