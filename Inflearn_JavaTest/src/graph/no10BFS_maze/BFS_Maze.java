package graph.no10BFS_maze;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	int m, n;

	public boolean hasPath(int[][] maze, int[] start, int[] dest) {
		m = maze.length;
		n = maze[0].length;

		if (start[0] == dest[0] && start[1] == dest[1]) {
			return true;
		}

		boolean[][] visited = new boolean[m][n];
		visited[start[0]][start[1]] = true;

		Queue<int[]> que = new LinkedList<int[]>();

		que.offer(new int[] { start[0], start[1] });

		while (!que.isEmpty()) {
			int[] p = que.poll();
			for (int[] dir : dirs) {
				int x = p[0] + dir[0];
				int y = p[1] + dir[1];
				while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
					x += dir[0];
					y += dir[1];
				}
				x -= dir[0];
				y -= dir[1];

				if (visited[x][y]) {
					continue;
				}
				visited[x][y] = true;
				System.out.println("--------------");
				print(visited);
				if (x == dest[0] && y == dest[1]) {
					return true;
				}
				que.offer(new int[] { x, y });
			}
		}

		return false;
	}

	private void print(boolean[][] visited) {
		if (visited == null || visited.length == 0) {
			return;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(visited[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

class Solution2 {
	int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	int m, n;

	public boolean hasPath(int[][] maze, int[] start, int[] dest) {
		m = maze.length;
		n = maze[0].length;
		
		if(start[0] == dest[0] && start[1] == dest[1]) {
			return true;
		}
		
		boolean[][] visited = new boolean[m][n];
		visited[start[0]][start[1]] = true;
		
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(start);
		
		while(!que.isEmpty()) {
			int[] p = que.poll();
			for(int[] dir : dirs) {
				int x = p[0] + dir[0];
				int y = p[1] + dir[1];
				while(x > 0 && x < m && y > 0 && y < n && maze[x][y] == 0) {
					x += dir[0];
					y += dir[1];
				}
				x -= dir[0];
				y -= dir[1];
				
				if(visited[x][y]) {
					continue;
				}
				visited[x][y] = true;
				
				if(x == dest[0] && y == dest[1]) {
					return true;
				}
				que.offer(new int[] {x,y});
			}
		}
		
		return false;
	}
}

public class BFS_Maze {
	public static void main(String[] args) {
		int[][] maze = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		int[] start = { 0, 4 };
		int[] dest = { 4, 4 };

		Solution s = new Solution();
		System.out.println(s.hasPath(maze, start, dest));
		
		Solution2 s2 = new Solution2();
		System.out.println(s2.hasPath(maze, start, dest));
	}
}
