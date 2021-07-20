package twoPointer;

import java.util.HashMap;
import java.util.Map;

/*
 * 최대 2개의 고유 문자를 포함하는 가장 긴 부분 문자열 길이 리턴
 * 1 <= s.length <= 10^4
 * input s = "eceba";
 * output = 3
 * ex) "ece"
 * 
 * i s = "ccaabbb"
 * o = 5
 * ex) "aabbb"
 */

class LongestSubstrWithAtMostTwoDistinctChar {
	public int solve(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0, right = 0, counter = 0, max = 0;
		
		while(right < s.length()) {
			char c = s.charAt(right);
			map.put(c, map.getOrDefault(c, 0) + 1);
			
			if(map.get(c) == 1) {
				counter++;
			}
			right++;
			
			while(counter > 2) {
				char c2 = s.charAt(left);
				map.put(c2, map.get(c2) - 1);
				if(map.get(c2) == 0) {
					counter--;
				}
				left++;
			}
		
			max = Math.max(max, right - left);
			//System.out.println("r: " + right + " l: " + left + " " + (right-left));
		}
		
		return max;
	}
}

public class No02_LongestSubstrWithAtMostTwoDistinctChar {
	public static void main(String[] args) {
		String s1 = "eceba";
		String s2 = "aabbccc";
		LongestSubstrWithAtMostTwoDistinctChar  sol = 
				new LongestSubstrWithAtMostTwoDistinctChar();
		System.out.println(sol.solve(s1));
		System.out.println(sol.solve(s2));
	}
}
