package backTracking.no01generateParentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<String> generateParentheses_dfs(int n) {
		List<String> result = new ArrayList<String>();

		dfs(result, "", n, n, "");

		return result;
	}

	int count = 0;

	private void dfs(List<String> result, String str, int left, int right, String str2) {
		count++;
		System.out.println("str:\t " + str + "\t left:" + left + " right: " + right + "\t count: " + count + " str2: " + str2);
		// 1 제약 조건
		if (left < 0 || left > right) {
			return;
		}

		// 2 for
		if (left == 0 && right == 0) {
			result.add(str);
			return;
		}

		dfs(result, str + '(', left - 1, right, str2 + "+");
		dfs(result, str + ')', left, right - 1, str2 + "-");

	}
}

public class GenerateParentheses {
	public static void main(String[] args) {
		int n = 3;
		Solution s = new Solution();
		System.out.println(s.generateParentheses_dfs(n));
	}
}
