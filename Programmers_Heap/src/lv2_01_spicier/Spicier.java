package lv2_01_spicier;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        int sco = 0;
        // 섞은 스코빌 = 가장 안매운거 + 2번째 안매운거*2
        
//        Queue<Integer> que = new PriorityQueue<Integer>(scoville.length, comp);
        Queue<Integer> que = new PriorityQueue<Integer>();
        
        for(int i : scoville) {
        	que.offer(i);
        }
        
        if(que.peek() >= K) {
        	return answer;
        }
        
        while(que.peek() < K && que.size() >= 2) {
        	int first = que.poll();
        	int second = que.poll();
        	
        	sco = first + (second * 2);
        	answer++;
        	
        	que.offer(sco);
        	if(que.peek() >= K) {
        		return answer;
        	}
        }
        
        if(que.peek() >= K) {
        	return answer;
        }
        
        answer = -1;
        
        return answer;
    }
    
//    public Comparator<Integer> comp = new Comparator<Integer>() {
//		@Override
//		public int compare(Integer o1, Integer o2) {
//			return o1 - o2;
//		}
//	};
}

public class Spicier {
	public static void main(String[] args) {
		int[] scoville = {1,2,3,9,10,12};
		int K = 7;
		
		int[] scoville2 = {1,2,3};
		int K2 = 100;
		
		int[] scoville3 = {1,1,1,1};
		int K3 = 1;
		
		Solution s = new Solution();
		System.out.println(s.solution(scoville, K));
		System.out.println(s.solution(scoville2, K2));
		System.out.println(s.solution(scoville3, K3));
	}
}
