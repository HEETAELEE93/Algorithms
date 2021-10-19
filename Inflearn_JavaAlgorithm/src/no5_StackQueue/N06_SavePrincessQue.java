package no5_StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class SavePrincess {
	public int solution (int input1, int input2) {
		int answer = 0;
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i = 1; i <= input1; i++) {
			que.offer(i);
		}
		while(que.size() > 1) {
			for(int i = 1; i < input2; i++) {
				que.offer(que.poll());
			}
			que.poll();
		}
		answer = que.poll();
		return answer;
	}
	
	public int solution2(int n, int k) {
		int answer = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i <= n; i++) q.offer(i);
		
		while(!q.isEmpty()) {
			for(int i = 1; i < k; i++) {
				q.offer(q.poll());
			}
			q.poll();
			if(q.size() == 1) {
				answer = q.poll();
			}
		}
		
		return answer;
	}
}
public class N06_SavePrincessQue {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str = br.readLine();
//		String[] split = str.split(" ");
//		int input1 = Integer.parseInt(split[0]);
//		int input2 = Integer.parseInt(split[1]);
		
		int input1 = 8;
		int input2 = 3;
		
		SavePrincess sol = new SavePrincess();
		System.out.println(sol.solution(input1, input2));
		System.out.println(sol.solution2(input1, input2));
	}
}
