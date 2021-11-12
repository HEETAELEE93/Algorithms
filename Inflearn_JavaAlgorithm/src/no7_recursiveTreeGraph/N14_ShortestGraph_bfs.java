package no7_recursiveTreeGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class ShortestGraph_bfs1 {
	int[] ch, answer;
	int n, m;
	ArrayList<ArrayList<Integer>> graph;

	public void solution_bfs(int n, int m, int[][] dirs) {
		this.n = n;
		this.m = m;
		graph = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		ch = new int[n + 1];
		answer = new int[n + 1];
		
		for (int i = 1; i <= m; i++) {
			int a = dirs[i][0];
			int b = dirs[i][1];
			graph.get(a).add(b);
		}
		bfs(1);
		
		for (int i = 2; i <= n; i++) {
			System.out.println(i + " : " + answer[i]);
		}
	}
	
	public void bfs(int v) {
		Queue<Integer> que = new LinkedList<Integer>();
		ch[1] = 1;
		que.offer(v);
		int cnt = 0;

		while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				int x = que.poll();
				answer[x] = cnt;
				for (int j : graph.get(x)) {
					if (ch[j] == 0) {
						que.offer(j);
						ch[j] = 1;
					}
				}
			}
			cnt++;
		}
	}
}

class ShortestGraph_bfs2 {
	int n, m;
	int[] ch, dis;
	ArrayList<ArrayList<Integer>> graph;

	public void solution_bfs(int n, int m, int[][] dirs) {
		this.n = n;
		this.m = m;
		graph = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}

		ch = new int[n + 1];
		dis = new int[n + 1];

		for (int i = 1; i <= m; i++) {
			int a = dirs[i][0];
			int b = dirs[i][1];
			graph.get(a).add(b);
		}
		
		bfs(1);
		for(int i = 2; i <= n; i++) {
			System.out.println(i + " : " + dis[i]);
		}
	}
	
	public void bfs(int v) {
		Queue<Integer> que = new LinkedList<Integer>();
		ch[v] = 1;
		dis[v] = 0;
		que.offer(v);
		
		while(!que.isEmpty()) {
			int currentV = que.poll();
			for(int nv : graph.get(currentV)) {
				if(ch[nv] == 0) {
					ch[nv] = 1;
					que.offer(nv);
					dis[nv] = dis[currentV] + 1;
				}
			}
		}
	}
}

public class N14_ShortestGraph_bfs {
	public static void main(String[] args) {
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
		int n = dirs[0][0];	// 정점의 수 1 to 6
		int m = dirs[0][1];	// 간선의 수 9
		
		ShortestGraph_bfs1 sol1 = new ShortestGraph_bfs1();
		sol1.solution_bfs(n, m, dirs);
		
		System.out.println();
		
		ShortestGraph_bfs2 sol2 = new ShortestGraph_bfs2();
		sol2.solution_bfs(n, m, dirs);
	}
}
