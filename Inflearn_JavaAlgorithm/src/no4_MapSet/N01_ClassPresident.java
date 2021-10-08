package no4_MapSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class classPresident {
	public String solution (int n, String str) {
		String answer = "";
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(char c : str.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		int sum = 0;
		for(Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() > sum) {
				answer = String.valueOf( entry.getKey());
				sum = entry.getValue();
			}
		}
		
		return answer;
	}
}

public class N01_ClassPresident {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		String str = sc.nextLine();
		
		int n = 15;
		String str = "BACBACCACCBDEDE";
		
		classPresident sol = new classPresident();
		System.out.println(sol.solution(n, str));
	}
}
