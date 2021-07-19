package stringArray.no12longestSubstringWithAtMostTwoDistinct;

import java.util.HashMap;
import java.util.Map;

class Solution{
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		
		// 1. 그릇 만들기
		int startPtr = 0, 
				endPtr = 0, 
				len = 0, 
				cntChar = 0;
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		
		// 2. for문이나 while문
		while(endPtr < s.length()) {
			char endChar = s.charAt(endPtr);
			hm.put(endChar, hm.getOrDefault(endChar, 0)+1);
			if(hm.get(endChar) == 1) {
				cntChar++;
			}
			endPtr++;
			
			// 3. 앞에꺼 삭제하기
			while(cntChar > 2) {
				char startChar = s.charAt(startPtr);
				hm.put(startChar, hm.get(startChar) - 1);
				if(hm.get(startChar) == 0) {
					cntChar--;
				}
				startPtr++;
			}
			
			len = Math.max(len, endPtr-startPtr);
		}
		
		return len;
	}
}

public class LongestSubstringWithAtMostTwoDistinct {
	public static void main(String[] args) {
		String s = "ccaabbb";
		Solution so = new Solution();
		System.out.println(so.lengthOfLongestSubstringTwoDistinct(s));
	}
}
