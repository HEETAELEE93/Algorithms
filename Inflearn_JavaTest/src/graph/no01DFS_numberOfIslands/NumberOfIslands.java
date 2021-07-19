package graph.no01DFS_numberOfIslands;

class Solution {
	public int numsIslands(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length ==0) {
			return 0;
		}
		int count = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}
		return count;
	}

	private void dfs(char[][] grid, int i, int j) {
		int m = grid.length;
		int n = grid[0].length;
		
		if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
			return; 
		}
		grid[i][j] = 'x';
		
		dfs(grid, i-1, j);
		dfs(grid, i+1, j);
		dfs(grid, i, j-1);
		dfs(grid, i, j+1);
	}
}

class MySolution {
	public int numsIslands(char[][] grid) {
		if(grid == null) {
			return 0;
		} 
		int result = 0;
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(countOne(grid, i, j) >= 1) {
					result++;
				}
			}
		}
		return result;
	}
	
	public int countOne(char[][] grid, int x, int y) {
		if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
			return 0;
		} else if (grid[x][y] != '1') {
			return 0;
		} else {
			grid[x][y] = '2';
			
			return (1 + countOne(grid, x, y + 1) + countOne(grid, x + 1, y + 1) + 
					countOne(grid, x + 1, y) + countOne(grid, x + 1, y - 1) + 
					countOne(grid, x, y - 1) + countOne(grid, x - 1, y - 1) + 
					countOne(grid, x, y - 1) + countOne(grid, x + 1, y - 1));
		}
	}
}

public class NumberOfIslands {
	public static void main(String[] args) {
		char[][] grid = {
				{'1', '1', '1', '0', '1'},
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '1'},
				{'0', '0', '0', '0', '1'}
		};
		char[][] grid0 = {
				{'1', '1', '1', '0', '1'},
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '1'},
				{'0', '0', '0', '0', '1'}
		};
		
		Solution s = new Solution();
		System.out.println("s: " + s.numsIslands(grid));
		
		MySolution ms = new MySolution();
		System.out.println("ms: " + ms.numsIslands(grid0));
	}
}
