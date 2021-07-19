/*
 * 정수 삼각형 Integer Triangle
 * https://programmers.co.kr/learn/courses/30/lessons/43105
 
 문제 설명

위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 
거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다. 
아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 
예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.

삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 
거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.

제한사항
삼각형의 높이는 1 이상 500 이하입니다.
삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.

입출력 예
triangle												result
[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]	30
 */

package lv3_01_integerTriangle;

class Solution {
	public int solution(int[][] triangle) {
		int triLen = triangle.length;

		int[][] dp = new int[triLen][triLen];

		dp[0][0] = triangle[0][0];

		for (int i = 1; i < triLen; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					dp[i][j] = triangle[i][j] + dp[i - 1][j];
				} else if (i == j) {
					dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j], triangle[i][j] + dp[i - 1][j]);
					dp[i][j] = Math.max(dp[i][j], triangle[i][j] + dp[i - 1][j - 1]);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			max = Math.max(max, dp[dp.length - 1][i]);
		}

		return max;
	}
}

class AnotherSolution {
	private static int[][] nodes;
	private static int[][] nodesSum;

	public int solution(int[][] triangle) {
		nodes = triangle;
		nodesSum = new int[triangle.length][triangle.length];
		return preOrder(0, 0);
	}

	private static int preOrder(int row, int col) {
		if (nodes.length == row)
			return 0;
		
		if (nodesSum[row][col] > 0)
			return nodesSum[row][col];
		
		return nodesSum[row][col] = nodes[row][col] 
				+ Math.max(preOrder(row + 1, col), preOrder(row + 1, col + 1));
	}

}

public class IntegerTriangle {
	public static void main(String[] args) {
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		
//		Solution s = new Solution();
//		System.out.println(s.solution(triangle));
		
		AnotherSolution an = new AnotherSolution();
		System.out.println(an.solution(triangle));
	}
}
