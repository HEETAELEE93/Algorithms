package dp.no01uniquePath;

class Solution {
	public int uniquPaths(int m, int n) {
		
		if(m == 0 && n == 0) {
			return 0;
		}
		
		Integer[][] map = new Integer[m][n];
		
		for(int i = 0; i < m; i++) {
			map[i][0] = 1;
			
		}
		
		for(int i = 0; i < n; i++) {
			map[0][i] = 1;
		}
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				map[i][j] = map[i][j-1] + map[i-1][j];
			}
		}
		
		return map[m-1][n-1];
	}
}

public class UniquePath {
	public static void main(String[] args) {
		int m = 7;
		int n = 3;
		Solution s = new Solution();
		System.out.println(s.uniquPaths(m, n));
	}
}
