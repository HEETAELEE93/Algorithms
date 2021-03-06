package twoPointer;

/*
 * 중복 없는 가장 긴 String값을 리턴 
 */

import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepeatingCharacter{
	public int solve(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int right = 0, left = 0, counter = 0, max = 0;
		
		while(right < s.length()) {
			char c = s.charAt(right);	// 처음: right=0 a 뽑음
			map.put(c, map.getOrDefault(c, 0) + 1);
			if(map.get(c) > 1) {
				counter++;	// 문자가 2개 이상(중복되면) counter 값 증가
			}
			right++;
			
			while(counter > 0) { // 카운터값 있을 때 까지, left값을 right전까지 올리기
				char c2 = s.charAt(left);
				if(map.get(c2) > 1) {
					counter--;
				}
				map.put(c2, map.get(c2) - 1);
				left++;
			}
			max = Math.max(max, right - left);
		}
		
		return max;
	}
}

public class No01_LongestSubstringWithoutRepeatingChar {
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacter sol = new LongestSubstringWithoutRepeatingCharacter();
		String s1 = "abcabcd";
		System.out.println(sol.solve(s1));
		String s2 = "pwwkeac";
		System.out.println(sol.solve(s2));
	}
}
