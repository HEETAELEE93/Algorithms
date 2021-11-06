package no7_recursiveTreeGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class ShortestGraph {
	int[] ch;
	int n, m;
	ArrayList<ArrayList<Integer>> graph;
	Queue<Integer> que = new LinkedList<Integer>();
	public void solution_bfs(int n, int m, int[][] dirs) {
		this.n = n;
		this.m = m;
		graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 1; i <= m; i++) {
			int a = dirs[i][0];
			int b = dirs[i][1];
			graph.get(a).add(b);
		}
		que.offer(1);
		ch = new int[n + 1];
		ch[1] = 1;
		int[] answer = new int[n+1];
		int cnt = 0;
		while(!que.isEmpty()) {
			int size = que.size();

			for (int i = 0; i < size; i++) {
				int x = que.poll();
				answer[x] = cnt;
				for (int j : graph.get(x)) {
					if(ch[j] == 0 ) {
						que.offer(j);
						ch[j] = 1;
					}
				}
				
			}
			cnt++;
		}
		for(int i = 2; i <= n; i++) {
			System.out.println(i + " : " + answer[i]);
		}
	}
	
}
public class N13_ShortestGraph_bfs {
	public static void main(String[] args) {
		ShortestGraph sol = new ShortestGraph();
		int[][] dirs = {
				{6,9},
				{1,3},
				{1,4},
				{2,1},
				{2,5},
				{3,4},
				{4,5},
				{4,6},
				{6,2},
				{6,5}
		};
		int n = dirs[0][0];	// 정점의 수
		int m = dirs[0][1];	// 간선의 수
		sol.solution_bfs(n, m, dirs);
	}
}
