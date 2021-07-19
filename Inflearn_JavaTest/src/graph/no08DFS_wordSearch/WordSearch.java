package graph.no08DFS_wordSearch;

class Solution {
	int[][] dirs = { {-1,0}, {1,0}, {0,-1}, {0,1} };
	int m, n;
	
	public boolean solve(char[][] grid, String word) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return false;
		}
		
		m = grid.length;
		n = grid[0].length;
		
		boolean[][] visited = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(dfs(grid, visited, i, j, 0, word)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean dfs(char[][] grid, boolean[][] visited, int x, int y, int start, String word) {
		if(start == word.length()) {
			return true;
		}
		
		if(x < 0 || x >= m || y < 0 || y >= n) {
			return false;
		}
		
		if(visited[x][y]) {
			return false;
		}
		
		if(grid[x][y] != word.charAt(start)) {
			return false;
		}
		
		visited[x][y] = true;
		
		for(int[] dir : dirs) {
			if(dfs(grid, visited, x+dir[0], y+dir[1], start+1, word)) {
				return true;
			}
		}
		visited[x][y] = false;
		
		return false;
	}
}

class MySolution {
	int m, n;
	public boolean solve(char[][] grid, String word) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return false;
		}
		m = grid.length;
		n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(dfs(grid, visited, i, j, 0, word)) {
					return true;
				}
				visited = new boolean[m][n];
			}
		}
		
		return false;
	}
	private boolean dfs(char[][] grid, boolean[][] visited, int i, int j, int wordStart, String word) {
		if(wordStart == word.length()) {
			return true;
		}
		if(i < 0 || i >= m || j < 0 || j >= n) {
			return false;
		}
		if(visited[i][j]) {
			return false;
		}
		if(grid[i][j] != word.charAt(wordStart)) {
			return false;
		}
		visited[i][j] = true;
		
		return (dfs(grid, visited, i, j+1, wordStart+1, word) || 
				dfs(grid, visited, i+1, j, wordStart+1, word) ||
				dfs(grid, visited, i-1, j, wordStart+1, word) ||
				dfs(grid, visited, i, j-1, wordStart+1, word)
				);
	}
}

public class WordSearch {
	public static void main(String[] args) {
		char[][] grid = {
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'}
		};
		String word1 = "ABCCED";
		String word2 = "SEE";
		String word3 = "ABCD";
		
		Solution s = new Solution();
		System.out.println(s.solve(grid, word1));
		
		MySolution ms = new MySolution();
		System.out.println(ms.solve(grid, word3));
	}
}
