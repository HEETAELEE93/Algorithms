package backTracking.no04letterCombinations;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<String> solve(String digits) {
		String[] digitletter = { "", "", "abc", "def", "ghi", "jkl", "pqrs", "tuv", "wxyz" };
		List<String> result = new ArrayList<String>();

		if (digits.length() == 0) {
			return result;
		}
		
		result.add("");
		
		for(int i = 0; i < digits.length(); i++) {
			result = combine(result, digitletter[digits.charAt(i) - '0']);
		}
		
		return result;
	}

	private List<String> combine(List<String> firstResult, String digit) {
		List<String> result = new ArrayList<String>();
		
		for(int i = 0; i < digit.length(); i++) {
			for(String firstStr : firstResult) {
				result.add(firstStr + digit.charAt(i));
			}
		}
		return result;
	}
}

public class LetterCombinationsOfAPhonenumber {
	public static void main(String[] args) {
		String digits = "24";

		Solution s = new Solution();
		System.out.println(s.solve(digits));
	}
}
