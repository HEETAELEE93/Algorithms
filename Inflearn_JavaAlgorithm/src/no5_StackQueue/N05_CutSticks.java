package no5_StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class CutSticks {
	public int solution(String str) {
		int answer = 0;
		Stack<Character> stack = new Stack<Character>();
		int i = 0;
		for(char x : str.toCharArray()) {
			if(x == '(') {
				stack.push(x);
			} else {
				stack.pop();
				if(str.charAt(i - 1) == '(') {
					answer += stack.size();
				} else {
					answer++;
				}
			}
			i++;
		}
		
		return answer;
	}
}
public class N05_CutSticks {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str = br.readLine();
		
		String str = "(((()(()()))(())()))(()())";
		
		CutSticks sol = new CutSticks();
		System.out.println(sol.solution(str));
	}
}
