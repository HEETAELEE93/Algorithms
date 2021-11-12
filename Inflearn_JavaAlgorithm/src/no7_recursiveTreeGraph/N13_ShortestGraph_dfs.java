package no7_recursiveTreeGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class ShortestGraphDFS {
	int[] ch;
	int n, m, answer = 0;
	ArrayList<ArrayList<Integer>> graph;
	Stack<Integer> stack = new Stack<Integer>();;
	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	public void solution_dfs(int n, int m, int[][] dirs) {
		this.n = n;
		this.m = m;
		graph = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 1; i <= m; i++) {
			int a = dirs[i][0];
			int b = dirs[i][1];
			graph.get(a).add(b);
		}

		ch = new int[n + 1];
		ch[1] = 1;
		stack.push(1);
		dfs(1);
		System.out.println(answer);
		for (ArrayList<Integer> li : list) {
			System.out.println(li);
		}
	}

	public void dfs(int v) {
		if (v == n) {
			answer++;
			list.add(new ArrayList<Integer>(stack));
		} else {
			for (int nv : graph.get(v)) {
				if (ch[nv] == 0) {
					ch[nv] = 1;
					stack.push(nv);
					dfs(nv);
					stack.pop();
					ch[nv] = 0;
				}
			}
		}
	}
}

public class N13_ShortestGraph_dfs {
	public static void main(String[] args) {
		ShortestGraphDFS sol = new ShortestGraphDFS();
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
				{4,5}
		};
		int n = dirs[0][0]; // 정점의 수
		int m = dirs[0][1]; // 간선의 수
		sol.solution_dfs(n, m, dirs);
	}
}
