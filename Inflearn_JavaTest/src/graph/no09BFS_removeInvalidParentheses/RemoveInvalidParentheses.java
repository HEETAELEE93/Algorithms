package graph.no09BFS_removeInvalidParentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
	public List<String> solve(String s) {
		List<String> result = new ArrayList<String>();
		
		if(s == null) {
			return result;
		}
		
		Queue<String> que = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		
		que.offer(s);
		visited.add(s);
		boolean found = false;
		
		while(!que.isEmpty()) {
			int size = que.size();
			
			for(int i = 0; i < size; i++) {
				String str = que.poll();
				if(isValid(str)) {
					result.add(str);
					found = true;
				}
				if(found) {
					continue;
				}
				for(int j = 0; j < str.length(); j++) {
					if(str.charAt(j) != '(' && str.charAt(j) != ')') {
						continue;
					}
					String newStr = str.substring(0, j) + str.substring(j + 1);
					if(!visited.contains(newStr)) {
						que.offer(newStr);
						visited.add(newStr);
					}
				}
			}
		}
		return result;
	}

	private boolean isValid(String str) {
		int count = 0;
		
		for(char c : str.toCharArray()) {
			if(c == '(') {
				count++;
			} else if(c == ')') {
				count--;
				if(count < 0) {
					return false;
				}
			}
		}
		return count==0;
	}
}

class MySolution {
	public List<String> solve(String s) {
		List<String> result = new ArrayList<String>();
		
		if(s == null) {
			return result;
		}
		
		Queue<String> que = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		
		que.offer(s);
		visited.add(s);
		boolean found = false;
		
		while(!que.isEmpty()) {
			int size = que.size();
			
			for(int i = 0; i < size; i++) {
				String str = que.poll();
				if(isValid(str)) {
					result.add(str);
					found = true;
				}
				if(found) {
					continue;
				}
				for(int j = 0; j < str.length(); j++) {
					if(str.charAt(j) != '(' && str.charAt(j) != ')') {
						continue;
					}
					String newStr = str.substring(0, j) + str.substring(j + 1);
					if(!visited.contains(newStr)) {
						que.offer(newStr);
						visited.add(newStr);
					}
				}
			}
		}
		return result;
	}

	private boolean isValid(String str) {
		int count = 0;
		
		for(char c : str.toCharArray()) {
			if(c == '(') {
				count++;
			} else if(c == ')') {
				count--;
				if(count < 0) {
					return false;
				}
			}
		}
		return count==0;
	}
}

public class RemoveInvalidParentheses {
	public static void main(String[] args) {
		String input = "(a)())()";
		String input1 = "()())()";
		String input2 = "()))";
		
		Solution s = new Solution();
		System.out.println(s.solve(input));
		
		MySolution ms = new MySolution();
		System.out.println(ms.solve(input2));
	}
}
