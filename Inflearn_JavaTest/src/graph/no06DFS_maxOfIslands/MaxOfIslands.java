package graph.no06DFS_maxOfIslands;

class Solution {

	int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	int m, n;
	
	public int maxAreaOfIsland(int[][] grid) {
		if(grid == null || grid.length == 0) {
			return 0;
		}
		
		m = grid.length;
		n = grid[0].length;
		int max = 0;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 1) {
					int area = dfs(grid, i, j, 0);
					System.out.println(area);
					max = Math.max(max, area);
				}
			}
		}
		return max;
	}
	
	int dfs(int[][] grid, int x, int y, int area) {
		if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
			return area;
		}
		
		grid[x][y] = 0;
		area++;
		for(int[] dir : dirs) {
			area = dfs(grid, x+dir[0], y+dir[1], area);
		}
		
		return area;
	}
}

class MySolution{
	public int maxAreaOfIsland(int[][] grid) {
		if(grid == null) {
			return 0;
		}
		
		int maxIsland = 0;
		int dfsIsland = 0;
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 1) {
					dfsIsland = dfs(grid, i, j);
					System.out.println(dfsIsland);
					maxIsland = Math.max(maxIsland, dfsIsland);
				}
			}
		}
		return maxIsland;
	}

	private int dfs(int[][] grid, int x, int y) {
		if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
			return 0;
		} else if (grid[x][y] != 1) {
			return 0;
		} else {
			grid[x][y] = 2;
			
			return (1 + dfs(grid, x, y+1) + dfs(grid, x+1, y) + 
					dfs(grid, x-1, y) + dfs(grid, x, y-1));
		}
	}
	
}

public class MaxOfIslands {
	public static void main(String[] args) {
		int[][] grid = {
	            {1,1,0,1,1},
				{0,1,1,0,0},
				{0,0,0,0,0},
				{1,1,0,1,1},
				{1,0,1,1,1},
				{1,0,1,1,1}
			};
		Solution s = new Solution();
		System.out.println("Solution: " + s.maxAreaOfIsland(grid));
		
		int[][] grid1 = {
	            {1,1,0,1,1},
				{0,1,1,0,0},
				{0,0,0,0,0},
				{1,1,0,1,1},
				{1,0,1,1,1},
				{1,0,1,1,1}
			};
		MySolution ms = new MySolution();
		System.out.println("MySolution: " + ms.maxAreaOfIsland(grid1));
		
	}
}
