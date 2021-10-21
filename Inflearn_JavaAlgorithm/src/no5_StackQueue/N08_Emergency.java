package no5_StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Emergency {
	public int solution(int n, int m, int[] arr) {
		int answer = 0;
		
		Queue<Person> que = new LinkedList<Person>();
		
		for(int i = 0; i < n; i++) {
			que.offer(new Person(i, arr[i]));
		}
		while(!que.isEmpty()) {
			Person tmp = que.poll();
			for(Person x : que) {
				if(x.priority > tmp.priority) {
					que.offer(tmp);
					tmp = null;
					break;
				}
			}
			if(tmp != null) {
				answer++;
				if(tmp.id == m) {
					return answer;
				} 
			}
		}
		return answer;
	}
	
	public int solution2(int n, int m, int[] arr) {
		int answer = 0;
		
		Queue<Map<Integer, Integer>> que = new LinkedList<Map<Integer,Integer>>();
		for(int i = 0; i < n; i++) {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			map.put(i, arr[i]);
			que.offer(map);
		}
		while(!que.isEmpty()) {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			map.putAll(que.poll());
			int size = 0;
			for(Map<Integer, Integer> x : que) {
				size++;
				int key = x.keySet().iterator().next();
				int value = x.get(key);
				if(value > map.get(map.keySet().iterator().next())) {
					que.offer(map);
					break;
				}
			}
			if(size == que.size()) {
				answer++;
				if(map.keySet().iterator().next() == m) {
					return answer;
				}
			}
		}
		
		return answer;
	}
}

class Person {
	int id;
	int priority;
	
	public Person(int id, int priority) {
		this.id = id;
		this.priority = priority;
	}
}

public class N08_Emergency {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String first = br.readLine();
//		String[] firstSplit = first.split(" ");
//		int n = Integer.parseInt(firstSplit[0]);
//		int m = Integer.parseInt(firstSplit[1]);
//		
//		String second = br.readLine();
//		String[] secondSplit = second.split(" ");
//		int[] arr = new int[n];
//		for(int i = 0; i < n; i++) {
//			arr[i] = Integer.parseInt(secondSplit[i]);
//		}

		int n = 5;
		int m = 2;
		int[] arr = { 60, 50, 70, 80, 90 };

		Emergency sol = new Emergency();
		System.out.println(sol.solution(n, m, arr));
		System.out.println(sol.solution2(n, m, arr));
	}
}
