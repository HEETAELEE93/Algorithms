package no4_MapSet;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Anagram {
	public String solution(String s1, String s2) {
		String answer = "YES";
		
		Map<Character, Integer> map = new HashMap<>();
		
//		s1 = s1.toLowerCase();
//		s2 = s2.toLowerCase();

		for(char x : s1.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		for(char x : s2.toCharArray()) {
			if(!map.containsKey(x)) {
				return "NO";
			}
			map.put(x, map.get(x) - 1);
		}
		for(Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() != 0) {
				return "NO";
			}
		}
		return answer;
	}
	public String solution2(String s1, String s2) {
		String answer = "YES";
		
		Map<Character, Integer> map = new HashMap<>();
		for(char x : s1.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		for(char x : s2.toCharArray()) {
			if(!map.containsKey(x) || map.get(x) == 0) {
				return "NO";
			}
			map.put(x, map.get(x) - 1);
		}
		return answer;
	}
}

public class N02_Anagram {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String a = sc.next();
//		String b = sc.next();
		
		String a = "AbaAeCe";
		String b = "baeeACA";
		Anagram sol = new Anagram();
		System.out.println(sol.solution(a, b));
		System.out.println(sol.solution2(a, b));
	}
}
