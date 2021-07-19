package graph.no07BFS_wordLadder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
	public int ladder(String beginWord, String endWord, List<String> wordList) {
		if(wordList == null || !wordList.contains(endWord)) {
			return 0;
		}
		Queue<String> que = new LinkedList<String>();
		Set<String> dict = new HashSet<String>(wordList);
		
		que.offer(beginWord);
		dict.add(endWord);
		dict.remove(beginWord);
		int level = 1;
		
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i = 0; i < size; i++) {
				String str = que.poll();
				if(str.equals(endWord)) {
					return level;
				}
				for(String neighbor : neighbors(str, wordList)) {
					que.offer(neighbor);
				}
			}
			level++;
		}
		return 0;
	}
	
	public List<String> neighbors(String s, List<String> wordList){
		List<String> res = new LinkedList<String>();
		Set<String> dict = new HashSet<String>(wordList);
		
		for(int i = 0; i < s.length(); i++) {
			char[] chars = s.toCharArray();
			for(char ch = 'a'; ch <= 'z'; ch++) {
				chars[i] = ch;
				String word = new String(chars);
				if(dict.remove(word)) {
					res.add(word);
				}
			}
		}
		return res;
	}
}

class Solution2 {
	public int ladder(String beginWord, String endWord, List<String> wordList) {
		if(wordList == null || !wordList.contains(endWord)) {
			return 0;
		}
		Queue<String> que = new LinkedList<String>();
		Set<String> dict = new HashSet<String>(wordList);
		
		que.offer(beginWord);
		dict.remove(beginWord);
		int level = 1;
		
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i = 0; i < size; i++) {
				String str = que.poll();
				if(str.equals(endWord)) {
					return level;
				}
				for(String neighbor : neighbors(str, dict)) {
					que.offer(neighbor);
				}
			}
			level++;
		}
		return 0;
	}
	
	public List<String> neighbors(String s, Set<String> dict){
		List<String> res = new LinkedList<String>();
		
		for(int i = 0; i < s.length(); i++) {
			char[] chars = s.toCharArray();
			for(char ch = 'a'; ch <= 'z'; ch++) {
				chars[i] = ch;
				String word = new String(chars);
				if(dict.remove(word)) {
					res.add(word);
				}
			}
		}
		return res;
	}
}

public class WordLadder {
	public static void main(String[] args) {
		String[] words = {"hot","dot","lot","log","cog"};
		List<String> wordList = Arrays.asList(words);
		String beginWord = "hit";
		String endWord = "cog";
		
		Solution s = new Solution();
		System.out.println(s.ladder(beginWord, endWord, wordList));
		
		Solution2 s2 = new Solution2();
		System.out.println(s2.ladder(beginWord, endWord, wordList));
		
	}
}
