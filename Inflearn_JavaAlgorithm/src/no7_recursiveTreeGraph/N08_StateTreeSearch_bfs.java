package no7_recursiveTreeGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class StateTreeSearch {
	public int bfs(int s, int e) {
		Queue<Integer> que = new LinkedList<Integer>();
		int[] dis = { 1, -1, 5 }; // 앞 1, 뒤 -1, 앞 5
		int[] check = new int[10001]; // 제한사항 10,000
		check[s] = 1;
		que.offer(s);
		int L = 0;
		while (!que.isEmpty()) {
			int len = que.size();
			for (int i = 0; i < len; i++) {
				int x = que.poll();
				for (int j = 0; j < 3; j++) {
					int nx = x + dis[j];
					if (nx == e) {
						return ++L;
					}
					if (nx >= 1 && nx <= 10000 && check[nx] == 0) {
						check[nx] = 1;
						que.offer(nx);
					}
				}
			}
			L++;
		}
		return 0;
	}
}

public class N08_StateTreeSearch_bfs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int e = sc.nextInt();

		StateTreeSearch sol = new StateTreeSearch();
		System.out.println(sol.bfs(s, e));
	}
}
