package array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/*
 * String배열 안에서 다른 String과 아나그램 관계
 * 순서 상관없이 같은 아나그램 리턴
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 */
import java.util.List;
import java.util.Map;

class GroupAnagram {
	public List<List<String>> solve(String[] strs) {
		
		List<List<String>> result = new ArrayList<List<String>>();
		
		if(strs == null || strs.length == 0) {
			return result;
		}
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		for(String str : strs) {
			char[] charArr = str.toCharArray(); 	// e, a, t
			Arrays.sort(charArr);		// a, e, t
			
			String key = String.valueOf(charArr);
			
			if(map.containsKey(key)) {
				map.get(key).add(str);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(str);
				map.put(key, list);
			}
			/* if문 대체
				List<String> list = map.getOrDefault(key, new ArrayList<String>());
				list.add(str);
				map.put(key, list);
			*/
		}
//		1. result.addAll(map.values());
//		return result;
		
//		2. return new ArrayList<List<String>>(map.values());
		
		for(Map.Entry<String, List<String>> entry : map.entrySet()) {
			result.add(entry.getValue());
		}
			
		return result;
	}
	
	public List<List<String>> solve_ascii(String[] strs){
		
		List<List<String>> result = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		for(String str : strs) {
			int[] count = new int[26];
			for(int i = 0; i < str.length(); i++) {
				count[str.charAt(i) - 'a']++;	// a = 97
			}
			String key = Arrays.toString(count);
			
			List<String> list = map.getOrDefault(key, new ArrayList<String>());
			list.add(str);
			map.put(key, list);
		}
		for(Map.Entry<String, List<String>> entry : map.entrySet()) {
			result.add(entry.getValue());
		}
		
		return result;
	}
}

public class No04_GroupAnagram {
	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		GroupAnagram sol = new GroupAnagram();
		System.out.println(sol.solve(strs));
		System.out.println(sol.solve_ascii(strs));
	}
}
