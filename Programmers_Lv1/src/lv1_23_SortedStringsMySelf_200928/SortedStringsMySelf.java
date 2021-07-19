package lv1_23_SortedStringsMySelf_200928;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public String[] solution(String[] strings, int n) {
		Arrays.sort(strings);
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.charAt(n) - o2.charAt(n);
			}
		});
		return strings;
	}
}

public class SortedStringsMySelf {
	public static void main(String[] args) {
		String[] strings = {"sun", "bed", "car"};
		int n = 1;
		
		String[] strings2 = {"abce", "abcd", "cdx"};
		int n2 = 2;
		
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.solution(strings2, n2)));
	}
}
