package no5_StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class CurriculumDesign {
	public String solution(String need, String plan) {
		String answer = "YES";
		
		Queue<Character> que = new LinkedList<Character>();
		for(char x : need.toCharArray()) {
			que.offer(x);
		}
		for(char x : plan.toCharArray()) {
			if(que.contains(x)) {
				if(x != que.poll()) {
					return "NO";
				}
			}
		}
		if(!que.isEmpty()) {
			return "NO";
		}
		return answer;
	}
}
public class N07_CurriculumDesign {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String a = br.readLine();
//		String b = br.readLine();
		
//		Scanner sc = new Scanner(System.in);
//		String a = sc.next();
//		String b = sc.next();
		
		String a = "CBA";
		String b = "CBDAGE";
		
		CurriculumDesign sol = new CurriculumDesign();
		System.out.println(sol.solution(a, b));
	}
}
