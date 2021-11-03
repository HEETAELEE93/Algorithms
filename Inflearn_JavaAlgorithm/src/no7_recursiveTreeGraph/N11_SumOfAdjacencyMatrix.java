package no7_recursiveTreeGraph;

class SumOfPathSearch {
	int[][] graph;
	int[] ch;
	int n, m;
	int answer = 0;

	public void solution(int n, int m, int[][] dirs) {
		this.n = n;
		this.m = m;
		graph = new int[n + 1][n + 1];
		ch = new int[n + 1];

		for (int i = 1; i <= m; i++) {
			int a = dirs[i][0];
			int b = dirs[i][1];
			// 방향 그래프
			graph[a][b] = 1;
		}
		ch[1] = 1;
		dfs(1);
		System.out.println(answer);
	}

	public void dfs(int v) {
		if(v == n) {
			answer++;
		}
		for(int i = 1; i <= n; i++) {
			if(graph[v][i] == 1 && ch[i] == 0) {
				ch[i] = 1;
				dfs(i);
				ch[i] = 0;
			} 
		}
	}
}

public class N11_SumOfAdjacencyMatrix {
	public static void main(String[] args) {
		SumOfPathSearch sol = new SumOfPathSearch();
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
