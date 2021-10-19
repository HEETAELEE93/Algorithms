package no5_StackQueue;

import java.util.Scanner;
import java.util.Stack;

class Postfix {
	public int solution(String str) {
		int answer = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(char x : str.toCharArray()) {
			if(Character.isDigit(x)) {
				stack.push(x - 48);
			} else {
				int rt = stack.pop();
				int lt = stack.pop();
				if(x == '+') {
					stack.push(lt + rt);
				} else if(x =='-') {
					stack.push(lt - rt);
				} else if(x =='*') {
					stack.push(lt * rt);
				} else if(x =='/') {
					stack.push(lt / rt);
				}
			}
		}
		answer = stack.pop();
		return answer;
	}
}

public class N04_Postfix {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
		
		String str = "352+*9-"; // 3 * (5+2) - 9
		
		Postfix sol = new Postfix();
		System.out.println(sol.solution(str));
	}
}
