package No2;

class Solution {
	public int solution(int[][] office, int r, int c, String[] move) {
		int answer = 0;

		office[r][c] = 0;
		
		for(int i = 0; i < move.length; i++) {
			if(move[i].charAt(i) == 'g') {
				move();
			}
			if(move[i].charAt(i) == 'l') {
				turnL();
			}
			if(move[i].charAt(i) == 'r') {
				turnR();
			}
		}
		
		return answer;
	}
	void move(){
		
	}

	void turnR() {
		
	}
	void turnL() {
		
	}
}

public class No2 {
	public static void main(String[] args) {
		int[][] office = { { 5, -1, 4 }, { 6, 4, -1 }, { 2, -1, 1 } };
		int r = 1;
		int c = 0;
		String[] move = { "go", "go", "right", "go", "right", "go", "left", "go" };

		Solution s = new Solution();
		System.out.println(s.solution(office, r, c, move));
	}
}
