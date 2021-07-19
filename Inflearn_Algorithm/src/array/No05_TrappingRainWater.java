package array;

import java.util.Arrays;

/*
 * height는 벽.
 * 비가 내린 후, height 안에 가둘 수 있는 물의 양 계산
 * Math.min(left[i], right[i]) - height[i]
 */
class TrappingRainWater {
	public int solve(int[] height) {
		int result = 0;

		if (height == null || height.length <= 2) {
			return result;
		}

		int len = height.length;
		int[] left = new int[len];
		int[] right = new int[len];
		int[] result1 = new int[len];

		// 1. leftMax[]
		int max = height[0];
		left[0] = height[0];

		for (int i = 1; i < len; i++) {
			if (height[i] < max) {
				left[i] = max;
			} else {
				left[i] = height[i];
				max = height[i];
			}
		}

		// 2. rightMax[]
		max = height[len - 1];
		right[len - 1] = height[len - 1];

		for (int i = len - 2; i > 0; i--) {
			if (height[i] < max) {
				right[i] = max;
			} else {
				right[i] = height[i];
				max = height[i];
			}
		}

		// 3. min() - height
		for (int i = 0; i < len; i++) {
			result1[i] = Math.min(left[i], right[i]) - height[i];
			result += Math.min(left[i], right[i]) - height[i];
		}
		System.out.println(Arrays.toString(result1));
		return result;
	}
	
	public int solve2 (int[] height) {
		int result = 0;
		int len = height.length;
		int[] result1 = new int[len];
		
		for(int i = 1; i < len - 1; i++) {
			int maxLeft = 0, maxRight = 0;
			for(int j = i; j >= 0; j--) {
				maxLeft = Math.max(maxLeft, height[j]);
			}
			for(int j = i; j < len; j++) {
				maxRight = Math.max(maxRight, height[j]);
			}
			result1[i] = Math.min(maxLeft, maxRight) - height[i];
			result += Math.min(maxLeft, maxRight) - height[i];
		}
		System.out.println(Arrays.toString(result1));
		return result;
	}
}

public class No05_TrappingRainWater {
	public static void main(String[] args) {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		TrappingRainWater sol = new TrappingRainWater();
		System.out.println(sol.solve(height));
		System.out.println(sol.solve2(height));
	}
}
