package string;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public int solve(String jew, String stones) {
		Set<Character> set = new HashSet<Character>();
		
		char[] charArr = jew.toCharArray();
		
		for(int i = 0; i < charArr.length; i++) {
			set.add(charArr[i]);
		}
		
		char[] stoneArr = stones.toCharArray();
		int count = 0;
		for(int i = 0; i < stoneArr.length; i++) {
			if(set.contains(stoneArr[i])) {
				count++;
			}
		}
		return count;
	}
}

public class No03_JewelsAndStones {
	public static void main(String[] args) {
		String jewels = "aA";
		String stones = "aAAbbbb";
		Solution s = new Solution();
		System.out.println(s.solve(jewels, stones));
	}
}
