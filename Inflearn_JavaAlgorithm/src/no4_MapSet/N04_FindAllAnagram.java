package no4_MapSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class FindAllAnagram {
	public int solution(String a, String b) {
		int answer = 0;
		
		Map<Character, Integer> map1 = new HashMap<Character, Integer>();
		Map<Character, Integer> map2 = new HashMap<>();
		for(int i = 0; i < b.length(); i++) {
			map2.put(b.charAt(i), map2.getOrDefault(b.charAt(i), 0)+1);
		}
		for(int i = 0; i < b.length() - 1; i++) {
			map1.put(a.charAt(i), map1.getOrDefault(a.charAt(i), 0)+1);
		}
		int lt = 0;
		for(int rt = b.length() - 1; rt < a.length(); rt++) {
			map1.put(a.charAt(rt), map1.getOrDefault(a.charAt(rt), 0)+1);
			if(map1.equals(map2)) {
				answer++;
			}
			map1.put(a.charAt(lt), map1.get(a.charAt(lt))-1);
			if(map1.get(a.charAt(lt)) == 0) {
				map1.remove(a.charAt(lt));
			}
			lt++;
		}
		return answer;
	}
	
	public int solution2(String a, String b) {
		int answer = 0;
		
		Map<Character, Integer> map1 = new HashMap<Character, Integer>();
		Map<Character, Integer> map2 = new HashMap<>();
		for(char x : b.toCharArray()) {
			map2.put(x, map2.getOrDefault(x, 0)+1);
		}
		int L = b.length() - 1;
		for(int i = 0; i < L; i++) {
			map1.put(a.charAt(i), map1.getOrDefault(a.charAt(i), 0)+1);
		}
		int lt = 0;
		for(int rt = L; rt < a.length(); rt++) {
			map1.put(a.charAt(rt), map1.getOrDefault(a.charAt(rt), 0)+1);
			if(map1.equals(map2)) {
				answer++;
			}
			map1.put(a.charAt(lt), map1.get(a.charAt(lt))-1);
			if(map1.get(a.charAt(lt)) == 0) {
				map1.remove(a.charAt(lt));
			}
			lt++;
		}
		return answer;
	}
}

public class N04_FindAllAnagram {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String a = sc.next();
//		String b = sc.next();
		
		String a = "bacaAacba";
		String b = "abc";
		
		FindAllAnagram sol = new FindAllAnagram();
		System.out.println(sol.solution(a, b));
		System.out.println(sol.solution2(a, b));
	}
}
