package twoPointer;

/*
 * 두개의 문자열 s, p에서
 * p의 문자열이 s의 문자열에 특정 인덱스에서부터 모든 아나그램을 찾아서 인덱스 리턴
 * input s = "bacdgabcda", p = "abcd"
 * output = [0,5,6]
 */

import java.util.ArrayList;
import java.util.List;

class FindAllAnagramInAStr{
	public List<Integer> solve(String s, String p){
		List<Integer> result = new ArrayList<Integer>();
		
		if(s == null || s.length() == 0 || p == null || p.length() == 0) {
			return result;
		}
		
		int[] pArr = new int[26];
		for(int i = 0; i < p.length(); i++) {
			pArr[p.charAt(i) - 'a']++;
		}
		
		
		for(int i = 0; i < s.length() - p.length() + 1; i++) {
			int[] sArr = new int[26];
			for(int j = 0; j < p.length(); j++) {
				sArr[s.charAt(i + j) - 'a']++;
			}
			if(check(pArr, sArr)) {
				result.add(i);
			}
		}
		return result;
	}

	private boolean check(int[] pArr, int[] sArr) {
		for(int i = 0; i < pArr.length; i++) {
			if(pArr[i] != sArr[i]) {
				return false;
			}
		}
		return true;
	}
}

public class No03_FindAllAnagramInAString {
	public static void main(String[] args) {
		String s = "bacdgabcda";
		String p = "abcd";
		FindAllAnagramInAStr sol = new FindAllAnagramInAStr();
		System.out.println(sol.solve(s, p));
	}
}
