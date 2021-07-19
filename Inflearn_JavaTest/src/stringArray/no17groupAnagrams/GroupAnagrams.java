package stringArray.no17groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public List<List<String>> groupAnagram(String[] strs){
		double start = System.nanoTime();
		List<List<String>> result = new ArrayList<List<String>>();
		
		if(strs == null || strs.length == 0) {
			return result;
		}
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		for(String str : strs) {
			char[] charArr = str.toCharArray();
			Arrays.sort(charArr);
			
			String key = String.valueOf(charArr);
			if(map.containsKey(key)) {
				map.get(key).add(str);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(str);
				map.put(key, list);
			}
		}
		result.addAll(map.values());
		
		double end = System.nanoTime();
		System.out.println("실행 시간1 : " + ( end - start ) / 1000.0);
		return result;
	}
}

class Solution2 {
	public List<List<String>> groupAnagram(String[] strs){
		double start = System.nanoTime();
		List<List<String>> result = new ArrayList<List<String>>();
		
		if(strs == null || strs.length == 0) {
			return result;
		}
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		for(String str : strs) {
			int[] strArr = new int[26];
			
			for(char i : str.toCharArray()) {
				strArr[i - 'a']++;
			}
			
			String key = Arrays.toString(strArr);
			
			if(map.containsKey(key)) {
				map.get(key).add(str);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(str);
				map.put(key, list);
			}
			
		}
		result.addAll(map.values());
		
		double end = System.nanoTime();
		System.out.println("실행 시간2 : " + ( end - start ) / 1000.0);
		return result;
	}
}

public class GroupAnagrams {
	public static void main(String[] args) {
		String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};
		Solution s = new Solution();
		System.out.println(s.groupAnagram(list));
		
		System.out.println("================");
		Solution2 s2 = new Solution2();
		System.out.println(s2.groupAnagram(list));
		
		
	}
}
