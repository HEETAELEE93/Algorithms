package recursion;

public class CountingCells {
	private static int[][] grid = { 
			{ 1, 0, 0, 0, 0, 0, 0, 1 }, 
			{ 0, 1, 1, 0, 0, 1, 0, 0 }, 
			{ 1, 1, 0, 0, 1, 0, 1, 0 },
			{ 0, 0, 0, 0, 0, 1, 0, 0 }, 
			{ 0, 1, 0, 1, 0, 1, 0, 0 }, 
			{ 0, 1, 0, 1, 0, 1, 0, 0 },
			{ 1, 0, 0, 0, 1, 0, 0, 1 }, 
			{ 0, 1, 1, 0, 0, 1, 1, 1 } 
	};
	private static int N = 8;
	private static int backGround = 0;
	private static int image = 1;
	private static int already = 2;
	
	public static int countCells(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N) {
			return 0;
		} else if (grid[x][y] != image) {	 // 0 or counted
			return 0;
		} else {
			grid[x][y] = already;
//			return (1 + countCells(x-1, y+1) + countCells(x, y+1) + 
//					countCells(x+1, y+1) + countCells(x-1, y) +
//					countCells(x+1, y) + countCells(x-1, y-1) +
//					countCells(x, y-1) + countCells(x+1, y-1));
			return (1 + countCells(x, y+1) + countCells(x+1, y+1) + 
					countCells(x+1, y) + countCells(x+1, y-1) +
					countCells(x, y-1) + countCells(x-1, y-1) +
					countCells(x-1, y) + countCells(x-1, y+1));
		}
	}
	

	public static void main(String[] args) {
		System.out.println(countCells(5, 5));
	}
}
