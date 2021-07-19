package stringArray.no15findAllAnagrams;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> findAnagrams(String txt, String pat) {
		double start = System.nanoTime();
		List<Integer> list = new ArrayList<Integer>();

		if (txt == null || txt.length() == 0 || pat == null || pat.length() == 0 || txt.length() < pat.length()) {
			return list;
		}

		int[] patArr = new int[256];

		for (char i : pat.toCharArray()) {
			patArr[i]++;
		}

		for (int i = 0; i < txt.length() - pat.length() + 1; i++) {
			int[] txtArr = new int[256];
			for (int j = i; j < i + pat.length(); j++) {
				txtArr[txt.charAt(j)]++;
			}
			if (check(patArr, txtArr) == true) {
				list.add(i);
			}
//			if(Arrays.equals(txtArr, patArr)) {
//				list.add(i);
//			}

		}
		double end = System.nanoTime();
		System.out.println("실행 시간 : " + (end - start) / 1000.0);
		return list;
	}

	private boolean check(int[] patArr, int[] txtArr) {
		for (int i = 0; i < patArr.length; i++) {
			if (patArr[i] != txtArr[i]) {
				return false;
			}
		}

		return true;
	}
}

public class FindAllAnagrams {
	public static void main(String[] args) {
		String txt = "bacdgabcda";
		String pat = "abcd";
		Solution s = new Solution();
		System.out.println(s.findAnagrams(txt, pat));
	}
}
