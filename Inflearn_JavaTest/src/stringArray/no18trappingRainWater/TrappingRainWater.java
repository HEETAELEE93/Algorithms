package stringArray.no18trappingRainWater;

import java.util.Arrays;

class Solution {
	public int solve(int[] height) {
		int result = 0;
		
		if(height == null || height.length <= 2) {
			return result;
		}
		
		int[] left = new int[height.length];
		int[] right = new int[height.length];
		// int[] minLR = new int[height.length];
		
		int max = height[0];
		left[0]	= height[0];
		for(int i = 1; i < height.length; i++) {
			if(max < height[i]) {
				left[i] = height[i];
				max = height[i];
			} else {
				left[i] = max;
			}
		}
		
		max = height[height.length - 1];
		right[height.length - 1] = height[height.length - 1];
		for(int i = height.length - 2; i >= 0; i--) {
			if(max < height[i]) {
				right[i] = height[i];
				max = height[i];
			} else {
				right[i] = max;
			}
		}
		
		for(int i = 0; i < height.length; i++) {
			result += Math.min(left[i], right[i]) - height[i];
		}
		
		return result;
	}
}

class MySolution {
	public int solve(int[] height) {
		int result = 0;
		
		if(height == null || height.length == 0) {
			return result;
		}
		
		int[] left = new int[height.length];
		int[] right = new int[height.length];
		int[] minLR = new int[height.length];
		
		left[0] = height[0];
		for(int i = 1; i < height.length; i++) {
			left[i] = Math.max(left[i-1], height[i]);
		}
		
		right[height.length -1] = height[height.length - 1];
		for(int i = height.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i+1], height[i]);
		}
		
		for(int i = 0; i < height.length; i++) {
			minLR[i] = Math.min(left[i], right[i]);
		}

		for(int i = 0; i < height.length; i++) {
			result += (minLR[i] - height[i]);
		}
		
		return result;
	}
}

public class TrappingRainWater {
	public static void main(String[] args) {
		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2 ,1, 2, 1};
		Solution s = new Solution();
		System.out.println(s.solve(height));
		System.out.println("--------");
		MySolution ms = new MySolution();
		System.out.println(ms.solve(height));
	}
}
