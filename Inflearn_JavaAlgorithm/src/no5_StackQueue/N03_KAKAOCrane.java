package no5_StackQueue;

import java.util.Scanner;
import java.util.Stack;

class KAKAOCrane {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> st = new Stack<Integer>();
		
		for(int m : moves) {
			m = m-1;
			for(int i = 0; i < board.length; i++) {
				if(board[i][m] != 0) {
					if(!st.isEmpty() && st.peek() == board[i][m]) {
						st.pop();
						answer++;
					} else {
						st.push(board[i][m]);
					}
					board[i][m] = 0;
					break;
				}
			}
		}
		return answer*2;
	}
	
	public int solution2(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> st = new Stack<Integer>();
		
		for(int pos : moves) {
			for(int i = 0; i < board.length; i++) {
				if(board[i][pos-1] != 0) {
					int tmp = board[i][pos-1];
					board[i][pos-1] = 0;
					if(!st.isEmpty() && tmp == st.peek()) {
						answer+=2;
						st.pop();
					} else {
						st.push(tmp);
					}
					break;
				}
			}
		}
		
		return answer;
	}
}
public class N03_KAKAOCrane {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[][] board = new int[n][n];
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				board[i][j] = sc.nextInt();
//			}
//		}
//		int m = sc.nextInt();
//		int[] moves = new int[m];
//		for(int i = 0; i < m; i++) {
//			moves[i] = sc.nextInt();
//		}
		
		int n = 5;
		int[][] board = {
				{0,0,0,0,0},
				{0,0,1,0,3},
				{0,2,5,0,1},
				{4,2,4,4,2},
				{3,5,1,3,1}
		};
		int m = 8;
		int[] moves = {1,5,3,5,1,2,1,4};
		KAKAOCrane sol = new KAKAOCrane();
//		System.out.println(sol.solution(board, moves));
		System.out.println(sol.solution2(board, moves));
	}
}
