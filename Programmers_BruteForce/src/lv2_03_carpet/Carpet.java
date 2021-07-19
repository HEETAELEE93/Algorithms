package lv2_03_carpet;

import java.util.Arrays;

class Solution {
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		int area = brown + yellow;

		int maxHeight = (int) Math.sqrt(yellow) + 3;
		int height = 3;
		int minWidth = 3;
		int width = yellow + 2;

		first: for (int i = width; i >= minWidth; i--) {
			for (int j = height; j <= maxHeight; j++) {
				if (i * j > area) {
					break;
				}
				if (i * j == area && (j - 2) * (i - 2) == yellow) {
					answer[0] = i;
					answer[1] = j;
					break first;
				}
			}
		}

		return answer;
	}
}

class Solution1 {
	public int[] solution(int brown, int yellow) {
		int a = (brown + 4) / 2;	// width + height 14
		int b = yellow + 2 * a - 4;	// area 48
		int[] answer = { 
				(int) (a + Math.sqrt(a * a - 4 * b)) / 2, 
				(int) (a - Math.sqrt(a * a - 4 * b)) / 2 
		};
		return answer;
	}
}

public class Carpet {
	public static void main(String[] args) {
		int brown1 = 10;
		int yellow1 = 2;

		int brown2 = 8;
		int yellow2 = 1;

		int brown3 = 24;
		int yellow3 = 24;

		int brown4 = 50;
		int yellow4 = 22; // return 24, 3

		Solution s = new Solution();
		System.out.println(Arrays.toString(s.solution(brown3, yellow3)));
	}
}
