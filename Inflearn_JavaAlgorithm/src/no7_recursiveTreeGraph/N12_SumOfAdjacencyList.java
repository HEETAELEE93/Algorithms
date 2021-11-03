package no7_recursiveTreeGraph;

import java.util.ArrayList;

class SumOfAdjacencyList {
	int[] ch;
	int n, m, answer = 0;
	ArrayList<ArrayList<Integer>> graph;
	public void solution(int n, int m, int[][] dirs) {
		this.n = n;
		this.m = m;
		graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		ch = new int[n + 1];

		for (int i = 1; i <= m; i++) {
			int a = dirs[i][0];
			int b = dirs[i][1];
			graph.get(a).add(b);
		}
		ch[1] = 1;
		dfs(1);
		System.out.println(answer);
	}

	public void dfs(int v) {
		if(v == n) {
			answer++;
		}
		for(int nv : graph.get(v)) {
			if(ch[nv] == 0) {
				ch[nv] = 1;
				dfs(nv);
				ch[nv] = 0;
			}
		}
	}
}
public class N12_SumOfAdjacencyList {
	public static void main(String[] args) {
		SumOfAdjacencyList sol = new SumOfAdjacencyList();
		int n = 5;	// 정점의 수
		int m = 9;	// 간선의 수
		
		int[][] dirs = {
				{5,9},
				{1,2},
				{1,3},
				{1,4},
				{2,1},
				{2,3},
				{2,5},
				{3,4},
				{4,2},
				{4,5},
		};
		sol.solution(n, m, dirs);
	}
}
